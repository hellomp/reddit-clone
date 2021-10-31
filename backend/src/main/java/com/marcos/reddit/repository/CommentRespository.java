package com.marcos.reddit.repository;

import com.marcos.reddit.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRespository extends JpaRepository<Comment, Long>{
  
}
