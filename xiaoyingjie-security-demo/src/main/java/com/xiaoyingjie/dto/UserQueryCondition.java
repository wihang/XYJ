package com.xiaoyingjie.dto;

public class UserQueryCondition {

	private String username;
	private int age;
	private int ageTo;
	private String xxx;

	public String getName() {
		return username;
	}

	public void setName(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAgeTo() {
		return ageTo;
	}

	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}

	public String getXxx() {
		return xxx;
	}

	public void setXxx(String xxx) {
		this.xxx = xxx;
	}

}
