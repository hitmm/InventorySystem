package com.devil.inventory.web.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ImgUtils {

    public static FileInputStream queryAndGetPhotoImageBlob(String adress) {
        FileInputStream is = null;
        File filePic = new File(adress);
        try {
            is = new FileInputStream(filePic);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return is;

    }

    public static void queryPic(String adress, HttpServletResponse response) throws IOException {

        if (adress != null) {
            FileInputStream is = queryAndGetPhotoImageBlob(adress);

            if (is != null) {
                int i = is.available(); // 得到文件大小
                byte data[] = new byte[i];
                int read = is.read(data);// 读数据
                is.close();
                response.setContentType("image/jpeg"); // 设置返回的文件类型
                OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
                toClient.write(data); // 输出数据
                toClient.close();
            }
        }
    }
}
