package com.devil.inventory.web.controller;

import com.devil.inventory.model.dao.entity.UserInfoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description TODO
 * @Author huguangyin
 * @Date 2019/7/7-15:50
 *  
 */
@Controller
@RequestMapping(value = "/")
public class PageController {
    @RequestMapping(value = "tables")
    public ModelAndView tables(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("views/tables");
        HttpSession session = request.getSession();
        UserInfoEntity userInfo = (UserInfoEntity) session.getAttribute("userInfo");
        view.addObject("userInfo", userInfo);
        return view;
    }

    @RequestMapping(value = "forms")
    public String forms() {
        return "views/forms";
    }

    @RequestMapping(value = "charts")
    public String charts() {
        return "views/charts";
    }

    @RequestMapping(value = "register")
    public String register() {
        return "views/register";
    }
}
