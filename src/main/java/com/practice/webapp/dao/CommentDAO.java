package com.practice.webapp.dao;

import java.util.List;


import com.practice.webapp.entity.Comment;
public interface CommentDAO {
	public void insert(Comment comment);
	public void delete(long id);
	public void update(Comment comment,long id);  
	public List<Comment> getC_commentList(String sql);
	public Comment get(Comment comment);
	
	

}
