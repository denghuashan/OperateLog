package com.dhsmp.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.dhsmp.domain.UserInfo;

/**
 * @description 
 * @version 1.0,2017年9月14日 上午9:00:03,Denghs
 * @remark 
 */
public class UserInfoDao {
	
	/**
	 * 从数据库中获取到旧记录
	 * @return
	 * @throws Exception 
	 */
	public UserInfo getUserInfoById(int id) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = format.parse("2017-09-13 18:52:13");
		//通过ID去查数据库，并返回记录
		UserInfo userInfo = new UserInfo();
		userInfo.setAge(20);
		userInfo.setBirthday(date);
		userInfo.setId(1);
		userInfo.setNameEn("Jack");
		userInfo.setNameZh("杰克");
		userInfo.setType("金牌会员");
		return userInfo;
	}
	
}
