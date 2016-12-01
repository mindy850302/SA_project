package com.practice.webapp.dao;

import java.util.List;
import com.practice.webapp.entity.Comment;
public interface CommentDAO {
	public void insert(Comment comment);
	public void delete(Comment comment);
	public void update(Comment comment);  
	public List<Comment> getList();
	public Comment get(Comment comment);
	
	

}
