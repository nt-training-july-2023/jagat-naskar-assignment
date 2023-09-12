//package com.feedback.filter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.feedback.serviceImplementation.AuthenticationService;
//
//import java.io.IOException;
//import java.util.Base64;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//
////@WebFilter(urlPatterns = {"http://localhost:3000/api/users/login", "/api/dept"})
//@Component
//public class AuthenticationFilter implements Filter {
//
//  @Autowired
//  private AuthenticationService authenticationService;
//  
//  
//
//  public AuthenticationFilter(AuthenticationService authenticationService) {
//	super();
//	this.authenticationService = authenticationService;
//}
//
//
//
//@Override
//  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//      throws IOException, ServletException {
//    HttpServletRequest httpRequest = (HttpServletRequest) request;
//    String username1 = httpRequest.getHeader("email");
//    String password2 = httpRequest.getHeader("password");
//    
//    String username = new String(Base64.getDecoder().decode(username1));
//    String password = new String(Base64.getDecoder().decode(password2));
//    
//    System.out.println("USerName = "+username);
//    System.out.println("pass = "+password);
//    
//    System.out.println("___FIL__TER_____");
//    if (authenticationService.authenticate(username, password)) {
//    System.out.println("End____Filter1");
//      chain.doFilter(request, response);
//    } else {System.out.println("else End____Filter");
//      HttpServletResponse httpResponse = (HttpServletResponse) response;
//      httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials");
//      
//    }System.out.println("End____Filter2");
//
//  }
//
//  // Initialization and cleanup methods remain the same
//}