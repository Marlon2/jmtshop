package cn.edu.zut.jmtshop.action;

import java.util.List;

import cn.edu.zut.jmtshop.entity.Comment;
import cn.edu.zut.jmtshop.service.CommentService;
import cn.edu.zut.jmtshop.util.PageConstants;

import com.opensymphony.xwork2.ActionSupport;

public class CommentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private CommentService commentService;
	private List<Comment> comments;
	private Comment comment;
	private int id;
	private String ids;
	private int currentPage;//当前页码
	private int allPageCounts;//总页码
	private int commentid;
	private String productNameTXT;
	
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getAllPageCounts() {
		return allPageCounts;
	}
	public void setAllPageCounts(int allPageCounts) {
		this.allPageCounts = allPageCounts;
	}
	
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	

	public String getProductNameTXT() {
		return productNameTXT;
	}
	public void setProductNameTXT(String productNameTXT) {
		this.productNameTXT = productNameTXT;
	}
	/**
	 * 以商品名称类分
	 * */
	public String searchComment() throws Exception {
		if(productNameTXT==null||productNameTXT.equals("")){			
			return getCommentView();
		}else{
			try {
				int allRows = commentService.getCommentCount(productNameTXT);
				if(allRows%PageConstants.MAX_PAGESIZE==0){
					allPageCounts = allRows/PageConstants.MAX_PAGESIZE;
				}else{
					allPageCounts = allRows/PageConstants.MAX_PAGESIZE+1;
				}
				if(currentPage>allPageCounts){
					currentPage = allPageCounts;
				}
				List<Comment> list = commentService.getCommentsPrePage(currentPage,productNameTXT);
				if(!comments.isEmpty()){
					comments.removeAll(comments);
				}
				if(list != null){					
					comments.addAll(list);
				}
				return "list";
			} catch (Exception e) {
				e.printStackTrace();
	            return ERROR;
			}
			
			
		}
	}
	/**
	 * 执行列表显示
	 * */
	public String getCommentView() throws Exception {
		if(productNameTXT==null){
			productNameTXT = "";
		}
		if(currentPage==0){
			currentPage = 1;
		}
		try {
			int allRows = commentService.getCommentCount(productNameTXT);
			if(allRows%PageConstants.MAX_PAGESIZE==0){
				allPageCounts = allRows/PageConstants.MAX_PAGESIZE;
			}else{
				allPageCounts = allRows/PageConstants.MAX_PAGESIZE+1;
			}
			if(currentPage>allPageCounts){
				currentPage = allPageCounts;
			}
			comments = commentService.getCommentsPrePage(currentPage,productNameTXT);
			return "list";
		} catch (Exception e) {
			e.printStackTrace();
            return ERROR;
		}
	}
	/**
	 * 查看留言
	 * */
	public String getCommentInfo() throws Exception {
		try {
			comment = commentService.getCommentByid(commentid);
			System.err.println(comment.getUser().getUserName());
				return "info";
		} catch (Exception e) {
			e.printStackTrace();
            return ERROR;
		}		
	}
	/**
	 * 删除单个留言
	 * */
	public String deleteComment()throws Exception{
		try {
			if(commentService.deleteComment(commentid)){
				return "deleteSuccess";
			}else{
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
			}
	}
	/**
	 * 批量删除留言
	 * */
	public String deleteCommentBeach()throws Exception{
		try {
			String[] strIds = ids.split(",");
			int[] intIds = new int[strIds.length];
			for(int i=0;i<strIds.length;i++){
				intIds[i] = Integer.parseInt(strIds[i]);
			}
			if(intIds.length>0){	
				if(commentService.deleteBeachComment(intIds)){
					return "deleteSuccess";
				}else{
					return "error";
				}
			}else {
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
			}
	}

}
