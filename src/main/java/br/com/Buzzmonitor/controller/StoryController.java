package br.com.Buzzmonitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Buzzmonitor.model.Story;
import br.com.Buzzmonitor.service.StoryService;

@RestController
@RequestMapping("/stories")
public class StoryController {
	
	@Autowired
	private StoryService storyService;
	
	@GetMapping
    public List<Story> findAll() throws Exception {

        return storyService.findAll();
    }
	
	@GetMapping("/id/{post_id}")
	public Story findById(@PathVariable String post_id) throws Exception {
		
		return storyService.findById(post_id);
	}
	
	@GetMapping("/user/{user}")
	public List<Story> findByUser(@PathVariable String user) throws Exception {
		
		return storyService.findByUser(user);
	}

}
