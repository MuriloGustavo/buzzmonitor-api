package br.com.Buzzmonitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Buzzmonitor.model.Tweet;
import br.com.Buzzmonitor.service.TweetService;

@RestController
@RequestMapping("/tweets")
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
	
	@GetMapping
    public List<Tweet> findAll() throws Exception {

        return tweetService.findAll();
    }
	
	@GetMapping("/id/{post_id}")
	public Tweet findById(@PathVariable String post_id) throws Exception {
		
		return tweetService.findById(post_id);
	}
	
	@GetMapping("/user/{user}")
	public List<Tweet> findByUser(@PathVariable String user) throws Exception {
		
		return tweetService.findByUser(user);
	}
	
	@GetMapping("/content/{content}")
    public List<Tweet> findByContent(@PathVariable String content) throws Exception {

        return tweetService.findByContent(content);
    }

}
