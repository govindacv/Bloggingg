package com.blogging.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.dto.BlogPostRequest;
import com.blogging.entity.BlogPost;
import com.blogging.repository.BlogPostRepo;

@Service
public class BlogPostService {

	@Autowired
	private BlogPostRepo repo;

	public String createBlogPost(BlogPostRequest blogPostRequest) {
		BlogPost blogPost = new BlogPost();
		blogPost.setBlogTitle(blogPostRequest.getBlogTitle());
		blogPost.setBlogDescription(blogPostRequest.getBlogDescription());

		repo.save(blogPost);

		return "Saved Sucessfully";
	}

	public String deleteBlogPost(int id) {
		Optional<BlogPost> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return "Deleted Sucessfully";
		} else {
			return "Couldn't delete";
		}
	}

	public BlogPost findBlogPost(int blogId) {
		Optional<BlogPost> optional = repo.findById(blogId);

		if (optional != null) {
			BlogPost blogPost = optional.get();
			return blogPost;
		} else {
			return null;
		}
	}

	public BlogPost updateBlogPost(BlogPostRequest blogPostRequest, int blogPostId) {
		Optional<BlogPost> optional = repo.findById(blogPostId);
		if (optional.isPresent())

		{
			BlogPost blogPost = optional.get();
			blogPost.setBlogId(blogPostId);
			if (blogPostRequest.getBlogDescription() != null) {
				blogPost.setBlogDescription(blogPostRequest.getBlogDescription());
			}
			if (blogPostRequest.getBlogTitle() != null) {
				blogPost.setBlogTitle(blogPostRequest.getBlogTitle());
			}
			repo.save(blogPost);
			return blogPost;
		} else {
			return null;
		}
	}

}
