package com.practice.webapp.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.practice.webapp.entity.Comment;
import com.practice.webapp.dao.CommentDAO;

public class CommentDAOImpl implements CommentDAO {
	private List<Comment> CommentList = new ArrayList<Comment>();

	@Override
	public void insert(Comment comment) {
		// TODO Auto-generated method stub
		CommentList.add(comment);

	}

	@Override
	public void delete(Comment comment) {
		// TODO Auto-generated method stub
		for (int i = 0; i < CommentList.size(); i++) {
			if (CommentList.get(i).getComment_M_id() == comment.getComment_M_id()
					&& CommentList.get(i).getComment_p_id() == comment.getComment_p_id()) {
				CommentList.remove(i);
			}
		}
	}
	@Override
	public void update(Comment comment) {
		// TODO Auto-generated method stub
		for (int i = 0; i < CommentList.size(); i++) {
			if (CommentList.get(i).getComment_M_id() == comment.getComment_M_id()
					&& CommentList.get(i).getComment_p_id() == comment.getComment_p_id()) {
				CommentList.remove(i);
				CommentList.add(i, comment);
			}
		}
	}
	@Override
	public List<Comment> getList() {
		// TODO Auto-generated method stub
		return CommentList;
	}
	@Override
	public Comment get(Comment comment) {
		// TODO Auto-generated method stub
		Comment comment1 = new Comment();
		for (int i = 0; i < CommentList.size(); i++) {
			if (CommentList.get(i).getComment_M_id() == comment.getComment_M_id()
					&& CommentList.get(i).getComment_p_id() == comment.getComment_p_id()) {
				comment1 = CommentList.get(i);
			}
		}
		return comment1;
	}

}
