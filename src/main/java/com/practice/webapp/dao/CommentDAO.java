package com.practice.webapp.dao;

import java.util.List;
import com.practice.webapp.entity.Comment;
import com.practice.webapp.entity.Product;
public interface CommentDAO {
	public void insert(Comment comment);
	public void delete(Comment comment);
	public void update(Comment comment);  
	public List<Comment> getList();
	public Comment get(Comment comment);
	 public List<Comment>search(String keyword);
	 public int countComment();
	


}
