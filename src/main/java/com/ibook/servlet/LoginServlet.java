package com.ibook.servlet;

import com.ibook.bean.User;
import com.ibook.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals("userid")) {
//                System.out.println("cookie.getValue() = " + cookie.getValue());
//                User user = userService.findUserById(cookie.getValue());
//                if (user!= null) {
//                    System.out.println("111");
//                    request.getSession().setAttribute("user", user);
//                    request.getRequestDispatcher("/index.html").forward(request, response);
//                    return;
//
//                }
//                break;
//            }
//        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String logincheck = request.getParameter("logincheck");
        User user = userService.findUser(username, password);
        if (user != null) {
            if (logincheck != null) {
                Cookie cookie = new Cookie("userid", user.getId());
                cookie.setMaxAge(60 * 60 * 24 * 10);
                response.addCookie(cookie);
            }
            HttpSession session = request.getSession();
            session.setAttribute("userid", user.getId());
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }

    }
}
