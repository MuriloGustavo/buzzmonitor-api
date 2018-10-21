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
	
	@GetMapping("/{user}")
	public List<Tweet> findByUser(@PathVariable String user) throws Exception {
		
		return tweetService.findByUser(user);
	}

}
