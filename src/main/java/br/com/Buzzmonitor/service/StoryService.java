package br.com.Buzzmonitor.service;

import static br.com.Buzzmonitor.util.InstagramConstant.INDEX;
import static br.com.Buzzmonitor.util.InstagramConstant.TYPE;

import java.util.ArrayList;
import java.util.List;

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

import br.com.Buzzmonitor.model.Story;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StoryService {
	
	@Autowired
	private RestHighLevelClient client;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public List<Story> findAll() throws Exception {
        SearchRequest searchRequest = buildSearchRequest(INDEX,TYPE);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
        searchRequest.source(searchSourceBuilder);
        
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        
        return getSearchResult(searchResponse);    
    }
	
	public Story findById(String post_id) throws Exception {
		SearchRequest searchRequest = buildSearchRequest(INDEX,TYPE);
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
	     
		MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("post_id", post_id);
	     
	    searchSourceBuilder.query(matchQueryBuilder);

        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        return getResult(searchResponse);
	}
	
	public List<Story> findByUser(String user) throws Exception {
		SearchRequest searchRequest = buildSearchRequest(INDEX,TYPE);
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
	     
	    MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("author.login",user);
	     
	    searchSourceBuilder.query(matchQueryBuilder);

        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        return getSearchResult(searchResponse);
	}
	
	private Story getResult(SearchResponse searchResponse) {
		SearchHit[] searchHit = searchResponse.getHits().getHits();
		
		List<Story> storys = new ArrayList<>();
		
		for (SearchHit hit : searchHit){
			storys.add(objectMapper.convertValue(hit.getSourceAsMap(), Story.class));
		}
		
		return storys.get(0);
	}
	
	public List<Story> getSearchResult(SearchResponse searchResponse) {
		SearchHit[] searchHit = searchResponse.getHits().getHits();
		
		List<Story> stories = new ArrayList<>();
		
		for (SearchHit hit : searchHit){
			stories.add(objectMapper.convertValue(hit.getSourceAsMap(), Story.class));
		}
		
		return stories;
	}
	

	public SearchRequest buildSearchRequest(String index, String type) {

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(index);
        searchRequest.types(type);

        return searchRequest;
    }

}
