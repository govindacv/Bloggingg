package com.blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.entity.BlogPost;

public interface BlogPostRepo extends JpaRepository<BlogPost, Integer>
{
	

}
