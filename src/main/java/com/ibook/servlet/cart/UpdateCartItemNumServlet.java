package com.ibook.servlet.cart;

import com.ibook.service.CartService;
import com.ibook.service.impl.CartServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateCartItemNumServlet", value = "/UpdateCartItemNumServlet")
public class UpdateCartItemNumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userid");
//        String userId = request.getParameter("userId");
        String bookId = request.getParameter("bookId");
        String num = request.getParameter("num");
        CartService cartService = new CartServiceImpl();
        Boolean flag = cartService.updateCartItemNum(userId, bookId, Integer.parseInt(num));
        response.getWriter().write(flag.toString());
    }
}
