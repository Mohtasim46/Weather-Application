package com.mohtasimtest.thinkificweather.security;

import com.mohtasimtest.thinkificweather.models.Customer;
import com.mohtasimtest.thinkificweather.services.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

import static com.mohtasimtest.thinkificweather.contracts.SecurityContracts.HEADER_STRING;
import static com.mohtasimtest.thinkificweather.contracts.SecurityContracts.TOKEN_PREFIX;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CustomerDetailService customerDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        try{
            String jwtToken = getJwtFromRequest(httpServletRequest);

            if(StringUtils.hasText(jwtToken) && jwtTokenProvider.isValidToken(jwtToken)) {
                Long customerId = jwtTokenProvider.getCustomerIdFromJwt(jwtToken);
                Customer customerDetails = customerDetailService.loadUserById(customerId);

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        customerDetails, null, Collections.emptyList()
                );

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                        httpServletRequest
                ));

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }

        }catch (Exception ex) {
            logger.error("Could not set user authentication in security context", ex);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String getJwtFromRequest(HttpServletRequest httpServletRequest) {
        String bearerToken = httpServletRequest.getHeader(HEADER_STRING);

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}
