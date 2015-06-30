package cn.edu.zut.jmtshop.action;

import java.util.List;

import cn.edu.zut.jmtshop.entity.Product;
import cn.edu.zut.jmtshop.entity.SubType;
import cn.edu.zut.jmtshop.service.ProductAttrService;
import cn.edu.zut.jmtshop.service.ProductService;
import cn.edu.zut.jmtshop.service.SubTypeService;
import cn.edu.zut.jmtshop.util.PageConstants;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Product> products;
	
	private List<SubType> subTypes;
	
	private ProductService productService;
	
	private SubTypeService subTypeService;
	
	private ProductAttrService productAttrService;
	
	private Product product;
	// 接受用户看的是第几页
	private int currentPage;
	private int totalPage;
	//查找的参数
	private String e_productname="";
	//删除商品和他的属性
	private int e_productid;
	
	public String list(){
		totalPage = (productService.getProductNums(e_productname)-1)/PageConstants.MAX_PAGESIZE+1;
		int firstRow = (currentPage-1)*PageConstants.MAX_PAGESIZE;
		products = productService.getAllProducts(firstRow, e_productname);
		return "list";
	}
	
	public String edit(){
		product = productService.getProductById(e_productid);
		
		return "edit";
	}
	

	public String delete() {
		Product p = productService.getProductById(e_productid);
		// 删除商品属性
//		productAttrService.deleteByPid(p.getProductid());
		// 删除商品
		productService.deleteProduct(p);
		return list();
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String getE_productname() {
		return e_productname;
	}

	public void setE_productname(String e_productname) {
		this.e_productname = e_productname;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public List<SubType> getSubTypes() {
		return subTypes;
	}
	public void setSubTypes(List<SubType> subTypes) {
		this.subTypes = subTypes;
	}
	
	public SubTypeService getSubTypeService() {
		return subTypeService;
	}
	public void setSubTypeService(SubTypeService subTypeService) {
		this.subTypeService = subTypeService;
	}

	public int getE_productid() {
		return e_productid;
	}

	public void setE_productid(int e_productid) {
		this.e_productid = e_productid;
	}

	public ProductAttrService getProductAttrService() {
		return productAttrService;
	}

	public void setProductAttrService(ProductAttrService productAttrService) {
		this.productAttrService = productAttrService;
	}
	

}
