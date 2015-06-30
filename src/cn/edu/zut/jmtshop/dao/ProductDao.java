package cn.edu.zut.jmtshop.dao;

import java.util.List;

import cn.edu.zut.jmtshop.entity.Product;

public interface ProductDao {

	int getProductNums(String e_productname);

	List<Product> getAllProducts(int firstRow, String e_productname);

	void saveOrUpdateProduct(Product product);

	Product getProductById(int e_productid);

	void deleteProduct(Product p);

}
