package cn.edu.zut.jmtshop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFiletr implements Filter {

	private String characterEncoding; // 编码方式，配置在web.xml中
	private boolean enabled; // 是否启用该Filter，配置在web.xml中

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		characterEncoding = filterConfig.getInitParameter("characterEncoding");
		enabled = "true".equalsIgnoreCase(filterConfig.getInitParameter(
				"enabled").trim());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (enabled || characterEncoding!=null) {
			request.setCharacterEncoding(characterEncoding);
			response.setCharacterEncoding(characterEncoding);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		characterEncoding=null;
	}

}
