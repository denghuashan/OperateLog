package com.dhsmp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhsmp.dao.UserInfoDao;
import com.dhsmp.domain.UserInfo;
import com.dhsmp.utils.OperateLogUtil;

/**
 * @description 
 * @version 1.0,2017年9月13日 下午7:21:25,Denghs
 * @remark 
 */
public class UpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 2432122502196905544L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			
			//这只是示例，工作一般都是采用spring的自动注入
			UserInfoDao dao = new UserInfoDao();
			
			//从数据库中获取旧记录
			UserInfo userInfo = dao.getUserInfoById(1);
			
			//原记录与新记录进行比较，并返回被修改的记录日志。
			String operateLog = OperateLogUtil.getOperateLog(request, userInfo);
			
			request.setAttribute("userInfo", userInfo);
			request.setAttribute("operateLog", operateLog);
			request.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}