package com.devil.inventory.web.controller.img;

import com.devil.inventory.model.dao.entity.UserInfoEntity;
import com.devil.inventory.web.config.SystemConfig;
import com.devil.inventory.web.utils.ImgUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/img")
public class HeadPortraitController {

    @RequestMapping(value = "/headProtrait")
    public void userProtrait(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String imageWarehousePath = SystemConfig.getImageWarehousePath();
        HttpSession session = request.getSession();
        UserInfoEntity userInfo = (UserInfoEntity) session.getAttribute("userInfo");
        long id = userInfo.getId();
        String imagePath = String.format("%s/%s/headProtrait.jpg", imageWarehousePath, id);
        System.out.println("image:  " + imagePath);
        ImgUtils.queryPic(imagePath, response);
    }
}
