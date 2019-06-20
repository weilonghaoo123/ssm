package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    //分页前
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() {
//        ModelAndView modelAndView = new ModelAndView();
//        List<Orders> ordersList = ordersService.findAll();
//        modelAndView.addObject("ordersList",ordersList);
//        modelAndView.setViewName("orders-list");
//        return modelAndView;
//
//    }
    //分页后
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") int page,
                                @RequestParam(name = "size", defaultValue = "4") int size) {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(ordersList);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;

    }
}
