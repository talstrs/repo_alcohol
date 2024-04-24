package com.babify.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.babify.common.constants.Constants;
import com.babify.common.interceptor.CheckLoginSessionInterceptor;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(Constants.UPLOADED_RESSOURCE_HANDLER)
                .addResourceLocations(Constants.UPLOADED_RESSOURCE_LOCATIONS);
        
    }
    
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new CheckLoginSessionInterceptor()) //LoginCheckInterceptor 등록
//				.order(2)
				.addPathPatterns("/*Xdm*")
				.excludePathPatterns(
//						"/resources/**",
//						"/usr/**",
						"/adm/**",
						"/index/**",
//						"/usr/v1/infra/member/usrIndex",
//						"/usr/v1/infra/member/membersUsrLogin",
//						"/usr/v1/infra/member/signinUsrCheck",
//						"/usr/v1/infra/member/membersUsrRegister",
//						"/usr/v1/infra/member/productUsrList",
//						"/usr/v1/infra/member/productUsrDetail",
						
						
						"/signinXdmCheck",
						"/membersXdmLogin"
//						"/v1/infra/member/signoutXdmProc"
//						"/v1/infra/index/indexXdmView"
//						"/members/add", 
//						"/login", 
//						"/logout", 
				)
		;
	}
}
