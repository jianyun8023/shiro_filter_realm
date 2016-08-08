package cc.yihy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by z9475 on 2016/8/7.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @RequestMapping(value = "/login.html",method = {RequestMethod.GET})
    public String UserLogin(){
        return "userlogin";
    }
    @RequestMapping(value = "/login.html",method = {RequestMethod.POST})
    public String doUserLogin(HttpServletRequest request){
        String message="普通用户登陆失败！";

        request.setAttribute("message",message);
        return "userlogin";
    }
    @RequestMapping(value = "/adminlogin.html",method = {RequestMethod.GET})
    public String AdminLogin(){
        return "adminlogin";
    }
    @RequestMapping(value = "/adminlogin.html",method = {RequestMethod.POST})
    public String doAdminLogin(HttpServletRequest request){

        String message="普通用户登陆失败！";

        request.setAttribute("message",message);
        return "adminlogin";
    }
}
