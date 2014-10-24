package com.aoyetech.fee.web.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ManagerController {
    @RequestMapping(value = { "/index.htm" })
    public String getIndexPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        return "/index";
    }
}
