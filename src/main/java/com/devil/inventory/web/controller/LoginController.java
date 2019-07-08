package com.devil.inventory.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.devil.inventory.model.service.result.LoginResult;
import com.devil.inventory.service.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description TODO
 * @Author huguangyin
 * @Date 2019/6/26-17:38
 *  
 */
@Controller
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "/login/{userName}/{passWord}", method = RequestMethod.GET)
    public LoginResult request(@PathVariable("userName") String userName, @PathVariable("passWord") String passWord) throws Exception {
        LoginResult result = loginService.login(userName, passWord);
        logger.info(String.format("result : %s.", JSONObject.toJSONString(result)));
        return result;
    }
    @RequestMapping(value = "/login")
    public String login(){
        return "views/login";
    }

    @RequestMapping(value = "/index")
    public ModelAndView onLogin(@RequestParam(name = "userName", required = true)  String userName,
                                @RequestParam(name = "password", required = true)String password,
                                HttpServletRequest request) throws Exception {
        logger.info(userName);
        logger.info(String.format("request : %s.",request.getSession()));
        ModelAndView mv = new ModelAndView("views/index");
        ModelAndView mv2 = new ModelAndView("#");
        HttpSession session = request.getSession();
        LoginResult result = loginService.login(userName, password);
        mv.addObject("userInfo", result.getEntity());
        session.setAttribute("userInfo",result.getEntity());

        if (result.getCode()==0) {
            return mv;
        }
        return  mv2;

    }
}
