package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("/list")

    public String Goodslist(Model model) {
        model.addAttribute("goodsList", goodsService.findAll());
        return "goodsList";
    }

}
