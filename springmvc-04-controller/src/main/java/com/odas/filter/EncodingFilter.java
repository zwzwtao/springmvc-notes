package com.odas.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf8");
        servletResponse.setCharacterEncoding("utf8");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
