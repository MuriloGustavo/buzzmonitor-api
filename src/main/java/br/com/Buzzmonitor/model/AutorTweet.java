package br.com.Buzzmonitor.model;

import java.util.List;

public class AutorTweet {

	private String name;
	
	private String name_searchable;
	
	private String description;
    
	private List<String> bios;
	
	private int followers;
	
	private int friends;
	
	private String gender;
	
	private boolean updated;
	
	private String created_at;
	
	private String screenname;
	
	private String profile_image_url;
    
    private int tweets;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_searchable() {
		return name_searchable;
	}

	public void setName_searchable(String name_searchable) {
		this.name_searchable = name_searchable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getBios() {
		return bios;
	}

	public void setBios(List<String> bios) {
		this.bios = bios;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public int getFriends() {
		return friends;
	}

	public void setFriends(int friends) {
		this.friends = friends;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isUpdated() {
		return updated;
	}

	public void setUpdated(boolean updated) {
		this.updated = updated;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getScreenname() {
		return screenname;
	}

	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}

	public String getProfile_image_url() {
		return profile_image_url;
	}

	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}

	public int getTweets() {
		return tweets;
	}

	public void setTweets(int tweets) {
		this.tweets = tweets;
	}
	
}
