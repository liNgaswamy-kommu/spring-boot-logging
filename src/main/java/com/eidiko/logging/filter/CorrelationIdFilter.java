package com.eidiko.logging.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class CorrelationIdFilter extends OncePerRequestFilter {

    private static final String CORRELATION_ID="correlationId";
    private static final String HEADER_NAME = "X-Correlation-ID";

    @Override
    public void doFilterInternal(HttpServletRequest request,
                         HttpServletResponse response,
                         FilterChain filterChain)
            throws ServletException, IOException
    {
        String CID = request.getHeader(HEADER_NAME);
        if(CID == null || CID.isBlank()){
            CID = UUID.randomUUID().toString();
        }
        MDC.put(CORRELATION_ID,CID);
        response.setHeader(HEADER_NAME,CID);

        try{
            filterChain.doFilter(request,response);
        }finally {
            MDC.remove(CORRELATION_ID);
        }
    }
}
