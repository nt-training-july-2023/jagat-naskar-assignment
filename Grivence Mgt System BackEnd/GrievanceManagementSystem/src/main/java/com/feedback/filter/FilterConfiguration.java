//package com.feedback.filter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.feedback.serviceImplementation.AuthenticationService;
//
//@Configuration
//  public class FilterConfiguration {
//    
//     private final AuthenticationService authenticationService;
//   @Autowired
//   public FilterConfiguration(AuthenticationService authenticationService) {
//       this.authenticationService = authenticationService;
//   }
//
//  @Bean
//  public FilterRegistrationBean<AuthenticationFilter> registrationBean() {
//    FilterRegistrationBean<AuthenticationFilter> regBean
//        = new FilterRegistrationBean<AuthenticationFilter>();
//    regBean.setFilter(new AuthenticationFilter(authenticationService));
//    regBean.addUrlPatterns("/api/users/login");
//    System.out.println("in config filter.");
//    return regBean;
//  }
//}
