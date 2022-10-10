package com.kodtodya.practice.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class SimpleFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(SimpleFilter.class);

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
            throws IOException, ServletException {

        logger.info("Remote Host: {}", request.getRemoteHost());
        logger.info("Remote Address: {}", request.getRemoteAddr());

        filterchain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterconfig) throws ServletException {
        logger.info("Initializing filter..!!!");
    }
}