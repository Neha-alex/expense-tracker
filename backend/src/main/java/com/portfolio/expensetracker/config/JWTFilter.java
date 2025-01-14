package com.portfolio.expensetracker.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.portfolio.expensetracker.service.JWTService;
import com.portfolio.expensetracker.service.MyUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTFilter  extends OncePerRequestFilter {
	
	@Autowired
	JWTService jwtService;
	
	@Autowired
	ApplicationContext context;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		System.out.println("inside jwt filter");
		
		String authHeader= request.getHeader("Authorization");
		String token = null;
		String username = null;
		
		if (authHeader==null) {
			System.out.println("authHeader is null");
		}
		
		if (authHeader != null && authHeader.startsWith("Bearer") ) {
			token = authHeader.substring(7);
			System.out.println("Extracted Token: " + token);
			username = jwtService.extractUserName(token);			
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("Authentication object: " + authentication);
	
		if (username !=null && SecurityContextHolder.getContext().getAuthentication()==null){
			System.out.println("inside get authentication method");
			
			UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(username);
			System.out.println("UserDetails Loaded: " + userDetails);
			
			if (jwtService.validateToken(token, userDetails)) {
				System.out.println("inside validate token");
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}			
		}
		filterChain.doFilter(request,response);
	}
	

}
