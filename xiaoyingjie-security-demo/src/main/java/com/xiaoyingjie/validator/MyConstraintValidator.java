/**
 * 
 */
package com.xiaoyingjie.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.xiaoyingjie.service.HelloService;

/**
 * @author Administrator
 *
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

	/**
	 * @param args
	 */
	@Autowired
	private HelloService helloservice;

	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		System.out.println("my validator init");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		helloservice.greeting("tom");
		System.out.println(value);
		return false;
	}

}
