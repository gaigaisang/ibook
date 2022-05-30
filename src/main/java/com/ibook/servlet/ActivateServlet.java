package com.ibook.servlet;

import com.ibook.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ActivateServlet", value = "/ActivateServlet")
public class ActivateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String activateCode = request.getParameter("activateCode");
        if (activateCode != null) {
            UserServiceImpl userService = new UserServiceImpl();
            request.setAttribute("msg", userService.activateUser(activateCode));
            request.getRequestDispatcher("/jump.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
