package cn.edu.zut.jmtshop.action;

import cn.edu.zut.jmtshop.entity.Admin;
import cn.edu.zut.jmtshop.service.AdminService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Admin admin;
	private String vcode;
	private AdminService adminService;
	private String massage;
	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String getVcode() {
		return vcode;
	}


	public void setVcode(String vcode) {
		this.vcode = vcode;
	}


	public AdminService getAdminService() {
		return adminService;
	}


	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}


	public String getMassage() {
		return massage;
	}


	public void setMassage(String massage) {
		this.massage = massage;
	}

	@Override
	public String execute() throws Exception {
		String str = (String) ActionContext.getContext().getSession().get(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		System.err.println("-----------------------------------vcode"+vcode);
		System.err.println("--------------------------------str"+str);
		if(str.trim().equalsIgnoreCase(vcode)){
			massage = "";
			Admin adminCurrent = null;
			try {
				adminCurrent = adminService.loginAdmin(admin);
			} catch (Exception e) {
				e.printStackTrace();
				return ERROR;
			}
			if(adminCurrent==null){
				massage = "用户名或密码不匹配，请重新输入！";
				return INPUT;
			}else{
				massage = "";
				return SUCCESS;
			}
		}else{
			massage = "验证码不正确，请重新输入！";
			return INPUT;
		}
	}
}
