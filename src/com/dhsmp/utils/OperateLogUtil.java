package com.dhsmp.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.dhsmp.annotation.LogInfo;

/**
 * @description
 * @version 1.0,2017年9月13日 下午7:24:24,Denghs
 * @remark
 */
public class OperateLogUtil {

	/**
	 * 采用反射进行比较。获取request对象中的参数，再与原对象属性上的值进行比较 
	 * 限制条件： 
	 * 1、需要在实体类中的字段加入注解
	 * 2、有一个强制性的要求。页面JSP中需要传入到后台的参数名必须跟字段名保持一致。也就是表单中的"name='字段名'"。
	 * 3、注解只能加在定义为单一类型的字段上。不能在List、关联关系对象上进行加入
	 * 
	 * @param request
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public static <T> String getOperateLog(HttpServletRequest request, T t) throws Exception {
		StringBuffer buffer = new StringBuffer();
		Class<? extends Object> clazz = t.getClass();
		// 获取自己声明的各种字段，包括public，protected，private。不包括父类的申明字段
		// getFields()只能获取public的字段，包括父类的。请自行区别
		Field[] reflectFields = clazz.getDeclaredFields();
		for (Field field : reflectFields) {
			LogInfo annotation = field.getAnnotation(LogInfo.class);
			// 当前字段上有注解才进行比较判断
			if (annotation != null) {
				//暴力访问
				field.setAccessible(true);
				//获取到方法名
				String name = field.getName();
				String methodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
				//获取方法并执行方法得到方法返回值
				Method method = clazz.getMethod(methodName, null);
				Object invoke = method.invoke(t, null);
				String newValue = request.getParameter(name);
				if (invoke == null) {
					invoke = "";
				}
				if (newValue == null) {
					newValue = "";
				}
				String oldValue = invoke.toString();
				
				//如果字段的类型是java.util.Date。没有判断java.sql.Date类型
				if(field.getType().isAssignableFrom(Date.class)){
					SimpleDateFormat format = new SimpleDateFormat(annotation.pattern());
					Date newDate = format.parse(newValue);
					Date oldDate = (Date) invoke;
					String oldDateStr = format.format(oldDate);
					if(!newDate.equals(oldDate)){
						String setMethodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
						//获取方法并执行方法得到方法返回值
						Method setMethod = clazz.getMethod(setMethodName, Date.class);
						//执行设置方法，把新值设置进去
						setMethod.invoke(t, newDate);
						buffer.append(String.format("%s：由【%s】修改为【%s】。",
								annotation.name(), oldDateStr, newValue));
					}
				}else{
					if (!newValue.equals(oldValue)) {
						buffer.append(String.format("%s：由【%s】修改为【%s】。",
								annotation.name(), oldValue, newValue));
					}
				}
			}
		}

		return buffer.toString();
	}
}