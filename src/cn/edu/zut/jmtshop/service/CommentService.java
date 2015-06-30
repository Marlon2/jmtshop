package cn.edu.zut.jmtshop.service;

import java.util.List;

import cn.edu.zut.jmtshop.entity.Comment;

public interface CommentService {
	public boolean addComment(Comment comment);
	public boolean deleteComment(int id);
	public boolean deleteBeachComment(int[] ids);
	public Comment getCommentByid(int id);
	public int getCommentCount(String productName);
	public List<Comment> getCommentsPrePage(int currentPage,String productName);
}
