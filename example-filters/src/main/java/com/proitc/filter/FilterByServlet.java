package com.proitc.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterByServlet implements Filter {

	private static final Logger log = Logger.getLogger(FilterByServlet.class.getName());
	private String attribValue;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		attribValue=filterConfig.getInitParameter("param2");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.info("Filtrado por servlet");
		request.setAttribute("param2", attribValue);
		chain.doFilter(request, response);
	}
	@Override
	public void destroy() {
	}

}
