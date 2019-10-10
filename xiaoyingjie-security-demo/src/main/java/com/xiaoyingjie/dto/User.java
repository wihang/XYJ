package com.xiaoyingjie.dto;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;
import com.mysql.fabric.xmlrpc.base.Data;
import com.xiaoyingjie.validator.MyConstraint;

public class User {
	public interface UserSimpleView{};
	public interface UserDetailView extends UserSimpleView{};
	
	private String id;
	@MyConstraint(message = "这是一个测试")
	private String username;
	@NotBlank(message = "用户密码不能为空")
	private String password;
	@Past(message = "生日必须是过去时间")
	private Date brithday;
	
	@JsonView(UserSimpleView.class)
	public Date getBrithday() {
		return brithday;
	}

	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}

	@JsonView(UserSimpleView.class)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonView(UserSimpleView.class)
	public String getUsername() {
		return username;
	}

	@JsonView(UserDetailView.class)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
