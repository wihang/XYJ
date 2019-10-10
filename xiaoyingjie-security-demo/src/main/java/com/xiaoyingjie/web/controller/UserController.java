package com.xiaoyingjie.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.xiaoyingjie.dto.User;
import com.xiaoyingjie.dto.User.UserDetailView;
import com.xiaoyingjie.dto.User.UserSimpleView;
import com.xiaoyingjie.dto.UserQueryCondition;
import com.xiaoyingjie.exception.UserNotExistException;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@PostMapping
	public User Create(@RequestBody @Valid User user ) {
//		,BindingResult erros
//		if(erros.hasErrors()) {
//			erros.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
//		}
		
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBrithday());
		user.setId("1");
		return user;
	}
	
	@PutMapping("/{id:\\d+}")
	public User update(@RequestBody @Valid User user ,BindingResult erros) {
		
		if(erros.hasErrors()) {
			erros.getAllErrors().stream().forEach(error -> {
//				FieldError fieldError = (FieldError) error;
//				String message = fieldError.getField() + error.getDefaultMessage();
				System.out.println(error.getDefaultMessage());
			}
			);
		}
		
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBrithday());
		user.setId("1");
		return user;
	}
	
	@DeleteMapping("/{id:\\d+}")
	public void delete(@PathVariable String id) {
		System.out.println(id);
	}
	
	@GetMapping
	@JsonView(User.UserSimpleView.class)
	@ApiOperation(value = "用户查询服务")
	public List<User> query(UserQueryCondition condition,@PageableDefault(size = 17,page = 3,sort = "username,asc")Pageable pageable){
		System.out.println(ReflectionToStringBuilder.toString(condition,ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getSort());
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users; 
	}
	
	@GetMapping("/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	//@PathVariable ,将{id}这个值传递到方法里
	public User getInfo(@PathVariable String id) {
//		throw new UserNotExistException(id);
		System.out.println("进入getInfo服务");
		User user= new User();
		user.setUsername("Tom");
		return user;
	}
}
