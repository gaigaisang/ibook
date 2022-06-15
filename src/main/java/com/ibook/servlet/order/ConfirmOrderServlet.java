package com.ibook.servlet.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibook.bean.CartItem;
import com.ibook.dao.impl.CartDaoImpl;
import com.ibook.service.impl.CartServiceImpl;
import com.ibook.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ConfirmOrderServlet", value = "/ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userid");
        String bookIds = request.getParameter("bookIds");
        String[] bookId = bookIds.split(",");

        List<CartItem> cartItems = new ArrayList<>();
        for (String id : bookId) {
            CartDaoImpl cartDao = new CartDaoImpl();
            CartItem item = cartDao.getCartItem(userId, id);
            cartItems.add(item);
        }
        CartServiceImpl cartService = new CartServiceImpl();
        for (String id : bookId) {
            cartService.delCartitem(userId, id);
        }
        OrderServiceImpl orderService = new OrderServiceImpl();
        String orderid = orderService.initOrder(userId, cartItems);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), orderid);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
