package com.es.sms.rest.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApiSecurityFilterChain implements Filter {

    @Override
    public void destroy() {
	// TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {
	HttpServletRequest httpRequest = (HttpServletRequest) request;
	HttpServletResponse httpResponse = (HttpServletResponse) response;
	// String authToken = httpRequest.getHeader(HttpHeaders.AUTHORIZATION);

	// if (authToken != null && authToken.trim().length() > 2
	// && authToken.trim().toLowerCase().startsWith("oauth ")) {
	// remove the oauth key from the token
	// String apiToken = authToken.substring(6);
	// if (apiToken.equalsIgnoreCase("123456")) {
	chain.doFilter(httpRequest, httpResponse);
	// } else {
	// httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
	// }
	// } else {
	// httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
	// }
	return;
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
	// TODO Auto-generated method stub

    }

}
