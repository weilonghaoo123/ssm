package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(ModelAndView modelAndView) {
        List<Product> productList = productService.findAll();
        modelAndView.addObject("productList", productList);
        modelAndView.setViewName("product-list1");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(Product product) {
        productService.save(product);
        return "redirect:findAll.do";
    }


}
