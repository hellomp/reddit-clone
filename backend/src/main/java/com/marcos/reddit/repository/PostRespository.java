package com.marcos.reddit.repository;

import com.marcos.reddit.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRespository extends JpaRepository<Post, Long>{
  
}
