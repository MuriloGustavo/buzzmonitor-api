package br.com.Buzzmonitor.service;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.Buzzmonitor.model.Tweet;
import lombok.extern.slf4j.Slf4j;

import static br.com.Buzzmonitor.util.TwitterConstant.INDEX;
import static br.com.Buzzmonitor.util.TwitterConstant.TYPE;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TweetService {

	@Autowired
	private RestHighLevelClient client;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public List<Tweet> findAll() throws Exception {
        SearchRequest searchRequest = buildSearchRequest(INDEX,TYPE);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
        searchRequest.source(searchSourceBuilder);
        
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        
        return getSearchResult(searchResponse);    
    }
	
	public Tweet findById(String post_id) throws Exception {
		SearchRequest searchRequest = buildSearchRequest(INDEX,TYPE);
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
	     
		MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("post_id", post_id);
	     
	    searchSourceBuilder.query(matchQueryBuilder);

        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        return getResult(searchResponse);
	}
	
	public List<Tweet> findByUser(String user) throws Exception {
		SearchRequest searchRequest = buildSearchRequest(INDEX,TYPE);
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
	     
	    MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("author.screenname",user);
	     
	    searchSourceBuilder.query(matchQueryBuilder);

        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        return getSearchResult(searchResponse);
	}
	
	public List<Tweet> findByContent(String content) throws Exception {
		SearchRequest searchRequest = buildSearchRequest(INDEX,TYPE);
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
	     
		MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("content", content);
	     
	    searchSourceBuilder.query(matchQueryBuilder);

        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        return getSearchResult(searchResponse);
	}
	
	private Tweet getResult(SearchResponse searchResponse) {
		SearchHit[] searchHit = searchResponse.getHits().getHits();
		
		List<Tweet> tweets = new ArrayList<>();
		
		for (SearchHit hit : searchHit){
			tweets.add(objectMapper.convertValue(hit.getSourceAsMap(), Tweet.class));
		}
		
		return tweets.get(0);
	}
	
	private List<Tweet> getSearchResult(SearchResponse searchResponse) {
		SearchHit[] searchHit = searchResponse.getHits().getHits();
		
		List<Tweet> tweets = new ArrayList<>();
		
		for (SearchHit hit : searchHit){
			tweets.add(objectMapper.convertValue(hit.getSourceAsMap(), Tweet.class));
		}
		
		return tweets;
	}

	private SearchRequest buildSearchRequest(String index, String type) {

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(index);
        searchRequest.types(type);

        return searchRequest;
    }

}
