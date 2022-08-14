package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

import static com.example.web.utils.ExecutValue.lastPrice;
import static com.example.web.utils.ExecutValue.lists;

@Controller
public class MainController {

     @RequestMapping("/")
        public String welcome(Map<String, Object> model) {
            model.put("time", new Date());
            model.put("message", "hello world");
            return "index";
        }

        @RequestMapping(value = { "/values" }) //, method = RequestMethod.GET
        public String viewPersonList(Model model) {
            model.addAttribute("lists", lists);
            return "values";
        }

    @RequestMapping(value = { "/currentval" })
    public String getCurrentVal(HttpServletRequest request, Model model) {
        model.addAttribute("lists", lists);
        model.addAttribute("currentvalue", lastPrice(request.getParameter("listname")));
        return "values";
    }




}