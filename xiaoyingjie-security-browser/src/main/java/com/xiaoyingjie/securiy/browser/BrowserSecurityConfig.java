package com.xiaoyingjie.securiy.browser;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//WebSecurityConfigurerAdapter web应用的安全认证的适配器
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.formLogin() //表单登录
//		http.httpBasic() 
			.and() 
			.authorizeRequests() //认证请求
			.anyRequest()	//所有的请求
			.authenticated(); //都需要身份验证
	}
	
}
