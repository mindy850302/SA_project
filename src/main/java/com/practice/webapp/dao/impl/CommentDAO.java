package com.practice.webapp.dao.impl;

import java.util.List;


import com.pratice.webapp.entity.Comment;
public interface CommentDAO {
	public void insert(Comment comment);
	public void delete(Comment comment);
	public void update(Comment comment);  
	public List<Comment> getList();
	public List<Comment> getC_commentList();
	public Comment get(Comment comment);
	

}
