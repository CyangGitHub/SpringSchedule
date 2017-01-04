package com.example.module.controller;

import com.example.interceptor.AvoidRepeatSubmission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;


/**
 * Created by admin on 2016/11/18.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    /**
     *http://localhost:10010/test/notify
     */
    @RequestMapping(value = "notify",produces = "text/plain;charset=GBK")
    @ResponseBody
    public String notify(String customerId, String data, String timestamp, String sign) throws UnsupportedEncodingException {

/*        System.out.println(customerId);
        System.out.println(data);
        System.out.println(timestamp);*/
        System.out.println(sign);

        String gbk = new String(sign.getBytes("GBK"), "UTF-8");
        System.out.println("gbk"+gbk);


        return "{\"retCode\":\"100\",\"retMessage\":\"接受成功\"}";
    }


    /**
     * localhost:10010/test/hello
     * @return
     */
    @RequestMapping("/hello")
    public String sayHello(String merchantID, String sign,String data,String keyPass, ModelMap modelMap){
        modelMap.addAttribute("merchantID",merchantID);
        modelMap.addAttribute("sign",sign);
        modelMap.addAttribute("data",data);
        modelMap.addAttribute("keyPass",keyPass);
        return "index";
    }
    @RequestMapping("token")
    @AvoidRepeatSubmission(isSaveToken = true)
    public String token(HttpServletRequest request,
                        ModelMap modelMap){

/*        HttpSession session = request.getSession();
        if(session.getAttribute("token")!=null){
            modelMap.addAttribute("token",session.getAttribute("token"));
        }*/

        return "index";
    }

}
