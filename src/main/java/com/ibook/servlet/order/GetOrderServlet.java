package com.ibook.servlet.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibook.bean.CartItem;
import com.ibook.bean.Order;
import com.ibook.dao.impl.CartDaoImpl;
import com.ibook.service.impl.CartServiceImpl;
import com.ibook.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetOrderServlet", value = "/GetOrderServlet")
public class GetOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userid");
        String state = request.getParameter("state");

        if (userId==null||state==null){
            return;
        }
        OrderServiceImpl orderService = new OrderServiceImpl();
        List<Order> orders = orderService.getOrderList(userId, state);
        if (orders == null) {
            response.getWriter().write("false");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getWriter(), orders);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
