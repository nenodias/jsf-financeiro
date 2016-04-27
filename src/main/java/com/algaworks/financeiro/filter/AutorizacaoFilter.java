package com.algaworks.financeiro.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algaworks.financeiro.controller.Usuario;

@WebFilter("*.xhtml")
public class AutorizacaoFilter implements Filter{
	
	private static final String RSOURCES = "/javax.faces.resource/";
	private static final String LOGIN_XHTML = "/Login.xhtml";
	@Inject
	private Usuario usuario;

	@Override
	public void destroy() {}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		if(!usuario.isLogado()
				&& !httpServletRequest.getRequestURI().endsWith(LOGIN_XHTML)
				&& !httpServletRequest.getRequestURI().contains(RSOURCES)){
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + LOGIN_XHTML);
		}else{
			chain.doFilter(httpServletRequest, httpServletResponse);
		}
	}

}
