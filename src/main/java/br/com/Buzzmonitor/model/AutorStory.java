package br.com.Buzzmonitor.model;

public class AutorStory {

	private String login;
	
	private String name;
	
	private String name_searchable;

	private int followers;
	
	private int friends;
    
	private int tweets_count;
	
	private String image;
    
    private String gender;
    
    private boolean updated;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

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

	public int getTweets_count() {
		return tweets_count;
	}

	public void setTweets_count(int tweets_count) {
		this.tweets_count = tweets_count;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
 
}
