package com.dhsmp.domain;

import java.util.Date;

import com.dhsmp.annotation.LogInfo;

/**
 * @description 
 * @version 1.0,2017年9月13日 下午7:36:17,Denghs
 * @remark 
 */
public class UserInfo {
	
	@LogInfo(name = "编号")
	private Integer id;
	
	@LogInfo(name = "中文姓名")
	private String nameZh;
	
	@LogInfo(name = "英文姓名")
	private String nameEn;
	
	@LogInfo(name = "年龄")
	private int age;
	
	@LogInfo(name = "类型")
	private String type;
	
	@LogInfo(name = "日期", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date birthday;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameZh() {
		return nameZh;
	}
	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}