package com.ibook.servlet.user;

import com.ibook.bean.User;
import com.ibook.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IsUsernameServlet", value = "/IsUsernameServlet")
public class IsUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        if (!username.isEmpty()) {
            UserServiceImpl userService = new UserServiceImpl();
            List<User> users = userService.findUserByUsername(username);
            if (users != null) {
                response.getWriter().write("true");

            } else {
                response.getWriter().write("false");

            }
        }
    }
}
