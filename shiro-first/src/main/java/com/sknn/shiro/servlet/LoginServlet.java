package com.sknn.shiro.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 * Created with IntelliJ IDEA.
 * Project: shiro.
 * Package: com.sknn.shiro.servlet.
 * User: Administrator.
 * Date: 2017-11-14 09:21.
 * Author: Haiyangp.
 */
@WebServlet(urlPatterns = "/login")//注意斜杠 与SpringMVC不同,必须要加
public class LoginServlet extends HttpServlet {

  /**
   * get请求,跳转到登录页面.
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
  }

  /**
   * psot请求,处理表单提交结果.
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    Subject subject = SecurityUtils.getSubject();

    UsernamePasswordToken token = new UsernamePasswordToken(username, password);

    String msg = null;
    try {
      subject.login(token);
    } catch (UnknownAccountException e) {
      msg = "Error username!";
    } catch (IncorrectCredentialsException e) {
      msg = "Error password!";
    } catch (AuthenticationException e) {
      msg = "Other error :" + e.getMessage();
    }

    //req.getContextPath();
    if (msg != null) {
      req.setAttribute("msg", msg);
      req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
      return;
    }
    req.getRequestDispatcher("/WEB-INF/jsp/loginSuccess.jsp").forward(req, resp);
  }
}
