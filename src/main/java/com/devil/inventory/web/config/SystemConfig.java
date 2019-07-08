package com.devil.inventory.web.config;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class SystemConfig {

    /**
     * 获取资源文件的根路径
     * @return
     * @throws FileNotFoundException
     */
    public static String getResoureceRootPath() throws FileNotFoundException {
        //获取跟目录
        File root = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!root.exists()) root = new File("");
        return root.getAbsolutePath();
    }

    /**
     * 获取静态资源的路径
     * @return
     * @throws FileNotFoundException
     */
    public static String getStaticResourecePath() throws FileNotFoundException {
        String rootPath = getResoureceRootPath();
        //获取跟目录
        File upload = new File(rootPath,"static/");
        if(!upload.exists()) upload.mkdirs();
        return upload.getAbsolutePath();
    }

    /**
     * 获取数据仓库的路径
     * @return
     * @throws FileNotFoundException
     */
    public static String getDataWarehousePath() throws FileNotFoundException {
        String rootPath = getResoureceRootPath();
        //获取跟目录
        File data = new File(rootPath,"data/");
        if(!data.exists()) data.mkdirs();
        return data.getAbsolutePath();
    }

    /**
     * 获取图片仓库的路径
     * @return
     * @throws FileNotFoundException
     */
    public static String getImageWarehousePath() throws FileNotFoundException {
        String rootPath = getResoureceRootPath();
        //获取跟目录
        File image = new File(rootPath,"image/");
        if(!image.exists()) image.mkdirs();
        return image.getAbsolutePath();
    }
}
