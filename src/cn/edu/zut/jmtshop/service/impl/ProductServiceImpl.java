package cn.edu.zut.jmtshop.service.impl;

import java.util.List;

import cn.edu.zut.jmtshop.dao.ProductDao;
import cn.edu.zut.jmtshop.entity.Product;
import cn.edu.zut.jmtshop.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;
	@Override
	public int getProductNums(String e_productname) {
		return productDao.getProductNums(e_productname);
	}
	public ProductDao getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	@Override
	public List<Product> getAllProducts(int firstRow, String e_productname) {
		return productDao.getAllProducts(firstRow, e_productname);
	}
	@Override
	public void saveOrUpdateProduct(Product product) {
		this.productDao.saveOrUpdateProduct(product);
	}
	@Override
	public Product getProductById(int e_productid) {
		return this.productDao.getProductById(e_productid);
	}
	@Override
	public void deleteProduct(Product p) {
		this.productDao.deleteProduct(p);
	}

}
