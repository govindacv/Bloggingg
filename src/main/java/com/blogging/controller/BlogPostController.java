package com.blogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.dto.BlogPostRequest;
import com.blogging.service.BlogPostService;

@RestController
@RequestMapping("/blogPost")
public class BlogPostController 
{
	@Autowired
	private  BlogPostService blogPostService;
	
	@PostMapping
	public String createBlogPost(@RequestBody BlogPostRequest blogPostRequest)
	{
		return blogPostService.createBlogPost(blogPostRequest);
	}
	
	@DeleteMapping("/{blogId}")
	public String deleteBlogPost(@PathVariable int blogId)
	{
		return blogPostService.deleteBlogPost(blogId);
	}
	
	@GetMapping("/id/{blogId}")
	public String findBlogPost(@PathVariable int blogId)
	
	{
		
		if(blogPostService.findBlogPost(blogId)!=null)
		{
			System.out.println(blogPostService.findBlogPost(blogId));
			return "Records found";
		}
		else
		{
			return "No records";
		}
	}
	
	
	@PutMapping("/{blogId}")
	public String updateBlogPost(@RequestBody BlogPostRequest blogPostRequest,@PathVariable int blogId)
	{
		if(blogPostService.updateBlogPost(blogPostRequest, blogId)!=null)
		{
			
			return "Updated Sucessfully";
		}
		else
		{
			return "could't Update";
		}
	}
	
	
	
	

}
