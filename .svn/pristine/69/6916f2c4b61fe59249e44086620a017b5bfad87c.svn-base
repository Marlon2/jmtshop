package cn.edu.zut.jmtshop.entity;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private int maxCountsPrePage;//每页显示最大记录数
	private int currentPageNum;//当前页码
//	private int allCounts;//总记录数
	private int allPageCounts;//总页数
	private List<T> list;//每页记录
	public int getMaxCountsPrePage() {
		return maxCountsPrePage;
	}
	public void setMaxCountsPrePage(int maxCountsPrePage) {
		this.maxCountsPrePage = maxCountsPrePage;
	}
	public int getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
//	public int getAllCounts() {
//		return allCounts;
//	}
//	public void setAllCounts(int allCounts) {
//		this.allCounts = allCounts;
//	}
	public int getAllPageCounts() {
		return allPageCounts;
	}
	public void setAllPageCounts(int allCounts) {
		if(allCounts%this.maxCountsPrePage==0){
			this.allPageCounts = allCounts/this.maxCountsPrePage;
		}else{
			this.allPageCounts = allCounts/this.maxCountsPrePage+1;
		}		
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	

//	private List<T> list;// 通过hql从数据库分页查询出来的list集合
//	private int allRows; // 总记录数
//	private int totalPage; // 总页数
//	private int currentPage; // 当前页
//	public List<T> getList() {
//		return list;
//	}
//	public void setList(List<T> list) {
//		this.list = list;
//	}
//	public int getAllRows() {
//		return allRows;
//	}
//	public void setAllRows(int allRows) {
//		this.allRows = allRows;
//	}
//	public int getTotalPage() {
//		return totalPage;
//	}
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
//	public int getCurrentPage() {
//		return currentPage;
//	}
//	public void setCurrentPage(int currentPage) {
//		this.currentPage = currentPage;
//	}
//
//	/**
//     * 得到总页数
//     * @param pageSize 每页记录数
//     * @param allRows  总记录数
//     * @return 总页数
//     */
//	public int getTotalPages(int pageSize, int allRows){
//		int totalPages = (allRows%pageSize==0)?(allRows/pageSize):(allRows/pageSize)+1;
//		return totalPages;
//	}
//	/**
//     * 得到当前开始记录号
//     * @param pageSize 每页记录数
//     * @param currentPage 当前页
//     * @return
//     */
//	public int getCurrentPageOffset(int pageSize, int currentPage)
//    {
//        int offset = pageSize * (currentPage - 1);
//        return offset;
//    }
//	/**
//     * 得到当前页， 如果为0 则开始第一页，否则为当前页
//     * @param page
//     * @return
//     */
//    public int getCurPage(int page)
//    {
//        int currentPage = (page == 0)? 1: page;
//        return currentPage;
//    }
}
