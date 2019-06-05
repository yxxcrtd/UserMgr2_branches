package cn.edustar.usermgr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServletHandler {
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
