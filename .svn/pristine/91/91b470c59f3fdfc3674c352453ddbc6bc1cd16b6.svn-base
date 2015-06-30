package cn.edu.zut.jmtshop.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.zut.jmtshop.entity.Product;
import cn.edu.zut.jmtshop.entity.ProductAttr;
import cn.edu.zut.jmtshop.service.ProductAttrService;
import cn.edu.zut.jmtshop.service.ProductService;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAttrAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// 代表上传文件的File对象
	private File upload;
	// 上传文件名
	private String uploadFileName;
	// 上传文件的MIME类型
	private String uploadContentType;
	// 上传文件的描述信息
	private String description;
	// 保存上传文件的目录，相对于WEB应用程序的根路径，在struts.xml中配置
	private String uploadDir = "/picture";

	private Product product;
	private List<ProductAttr> productattrs;
	private ProductService productService;
	private ProductAttrService productAttrService;

	public String add() throws Exception {
		String newFileName = null;
		// 得到当前时间自1970年1月1日0时0分0秒开始走过的毫秒数
		long now = System.currentTimeMillis();
		// 得到保存上传文件的目录的真实路径
		System.out.println(ServletActionContext.getServletContext()
				.getRealPath(uploadDir) + "目录");
		File dir = new File(ServletActionContext.getServletContext()
				.getRealPath(uploadDir));
		// 如果该目录不存在，就创建
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// 为避免重名文件覆盖，判断上传文件是否有扩展名，以时间戳作为新的文件名
		int index = uploadFileName.lastIndexOf(".");
		if (index != -1) {
			newFileName = now + uploadFileName.substring(index);
		} else {
			newFileName = Long.toString(now);
		}
		// 读取保存在临时目录下的上传文件，写入到新的文件中
		product.setPicture(newFileName);
		// 保存商品
		product.setProductid(0);
		productService.saveOrUpdateProduct(product);
		// 把属性和商品关联起来
		for (int i = 0; i < productattrs.size(); i++) {
			productattrs.get(i).setProductid(product.getProductid());
			// 保存商品属性
			productAttrService.saveOrUpdateProAttr(productattrs.get(i));
		}
		//清空集合 productattrs 中的数据
		productattrs.clear();
		printProduct();
		InputStream is = new FileInputStream(upload);

		OutputStream os = new FileOutputStream(new File(dir, newFileName));
		byte[] buf = new byte[1024];
		int len = -1;
		while ((len = is.read(buf)) != -1) {
			os.write(buf, 0, len);
		}
		is.close();
		os.close();
		return "add";
	}
	
	public void printProduct() {
		for (ProductAttr p : productattrs) {
			System.out.println(p.getAttrid() + "---" + p.getAttrvalue());
		}
		System.out.println("小类ID" + product.getSubtypeid());
		System.out.println("商品名" + product.getProductname());
		System.out.println("图片路径" + product.getPicture());
		System.out.println("是否特价" + product.getIsspecial());
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<ProductAttr> getProductattrs() {
		return productattrs;
	}

	public void setProductattrs(List<ProductAttr> productattrs) {
		this.productattrs = productattrs;
	}

	public ProductAttrService getProductAttrService() {
		return productAttrService;
	}

	public void setProductAttrService(ProductAttrService productAttrService) {
		this.productAttrService = productAttrService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}
