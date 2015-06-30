package cn.edu.zut.jmtshop.dao;

import java.util.List;

import cn.edu.zut.jmtshop.entity.Comment;
import cn.edu.zut.jmtshop.entity.Product;


public interface CommentDao{
	public int commentAdd(Comment comment);
	public int commentDelet(Comment comment);
	public int commentDeletBeach(List<Comment> comments);
	public Comment getCommentById(int id);
	public List<Product> getCommentByProductName(String productName);
	public int getCommentsCounts(String productName);
	public List<Comment> getCommentsPrePage(int first,int maxPrePage,String productName);
}
