package cn.edu.zut.jmtshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zut.jmtshop.dao.CommentDao;
import cn.edu.zut.jmtshop.entity.Comment;
import cn.edu.zut.jmtshop.service.CommentService;
import cn.edu.zut.jmtshop.util.PageConstants;

public class CommentServiceImpl implements CommentService {
	private CommentDao commentDao;

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public boolean addComment(Comment comment) {
		if(commentDao.commentAdd(comment)==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteComment(int id) {
		if(commentDao.commentDelet(commentDao.getCommentById(id))==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBeachComment(int[] ids) {
		List<Comment> comments = new ArrayList<Comment>();
		for(int id:ids){
			comments.add(commentDao.getCommentById(id));
		}
		if(commentDao.commentDeletBeach(comments)==1){
			return true;
		}
		return false;
	}

	@Override
	public Comment getCommentByid(int id) {
		return commentDao.getCommentById(id);
	}

	@Override
	public int getCommentCount(String productName) {
		return commentDao.getCommentsCounts(productName);
	}

	@Override
	public List<Comment> getCommentsPrePage(int currentPage,String productName) {
		return commentDao.getCommentsPrePage((currentPage-1)*PageConstants.MAX_PAGESIZE, PageConstants.MAX_PAGESIZE,productName);
	}

}
