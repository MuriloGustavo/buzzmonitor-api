package br.com.Buzzmonitor.model;

import java.util.List;

public class Story {

	private String interaction_type;
	
	private String post_id;
	
	private String sentiment;
	
	private String service;
	
    private int likes;
    
    private int replies;
    
    private boolean archived;
    
    private AutorStory author;
    
    private String application;
    
    private String origin;
    
    private String type;
    
    private String link;
    
    private int count;
    
    private int engagement;
    
    private String collected_time;
    
    private int reach;
    
    private int impressions;
    
    private String source;
    
    private String brand;
    
    private String date;
    
    private int comments_amounts;
    
    private String elasticsearch_id;
    
    private String elasticsearch_routing;
    
    private String picture_full_size;
    
    private List<String> tag;
    
    private String elasticsearch_index;
    
    private String external_id;
    
    private String user;

	public String getInteraction_type() {
		return interaction_type;
	}

	public void setInteraction_type(String interaction_type) {
		this.interaction_type = interaction_type;
	}

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public String getSentiment() {
		return sentiment;
	}

	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getReplies() {
		return replies;
	}

	public void setReplies(int replies) {
		this.replies = replies;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public AutorStory getAuthor() {
		return author;
	}

	public void setAuthor(AutorStory author) {
		this.author = author;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getEngagement() {
		return engagement;
	}

	public void setEngagement(int engagement) {
		this.engagement = engagement;
	}

	public String getCollected_time() {
		return collected_time;
	}

	public void setCollected_time(String collected_time) {
		this.collected_time = collected_time;
	}

	public int getReach() {
		return reach;
	}

	public void setReach(int reach) {
		this.reach = reach;
	}

	public int getImpressions() {
		return impressions;
	}

	public void setImpressions(int impressions) {
		this.impressions = impressions;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getComments_amounts() {
		return comments_amounts;
	}

	public void setComments_amounts(int comments_amounts) {
		this.comments_amounts = comments_amounts;
	}

	public String getElasticsearch_id() {
		return elasticsearch_id;
	}

	public void setElasticsearch_id(String elasticsearch_id) {
		this.elasticsearch_id = elasticsearch_id;
	}

	public String getElasticsearch_routing() {
		return elasticsearch_routing;
	}

	public void setElasticsearch_routing(String elasticsearch_routing) {
		this.elasticsearch_routing = elasticsearch_routing;
	}

	public String getPicture_full_size() {
		return picture_full_size;
	}

	public void setPicture_full_size(String picture_full_size) {
		this.picture_full_size = picture_full_size;
	}

	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public String getElasticsearch_index() {
		return elasticsearch_index;
	}

	public void setElasticsearch_index(String elasticsearch_index) {
		this.elasticsearch_index = elasticsearch_index;
	}

	public String getExternal_id() {
		return external_id;
	}

	public void setExternal_id(String external_id) {
		this.external_id = external_id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
}
