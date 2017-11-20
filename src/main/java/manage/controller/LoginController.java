package manage.controller;

import domain.User;
import manage.service.LoginService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Rujiao Xiong on 2017/4/8.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    Logger log = Logger.getLogger(LoginController.class);


    @Autowired
    private LoginService service;

    @RequestMapping(value = "/index")
    public String loginPage() {
        return "user/userQueryMethod";
    }


    @RequestMapping(value = "login")
    public String login() {
        return "/manage/login/login";
    }

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public ModelAndView loginCheck(
            @RequestParam(value = "inputEmail", required = true) String emailAdress,
            @RequestParam(value = "inputPassword", required = true) String password,
            @RequestParam(value = "rememberMe", required = false)boolean rememberMe,
            @CookieValue(value = "sessionId", required = false) String sessionId,
            @RequestHeader("Accept-Encoding") String encoding,
            @RequestHeader("Host") String host,
            HttpServletRequest request,
            HttpServletResponse response,
            RedirectAttributes rdAttr,
            User command) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(emailAdress, password,rememberMe);
        String msg;
        try {
            subject.login(token);

            return new ModelAndView("redirect:/user/userQueryMethod");
        } catch (UnknownAccountException e) {
            msg = "账号不存在";
        } catch (IncorrectCredentialsException ice) {
            msg = "账号或密码错误";
        } catch (LockedAccountException lae) {
            msg = "账号已经锁定";
        } catch (Exception e) {
            msg = "账号或密码错误";
        }
        return new ModelAndView("/manage/login/login", "error", msg);
    }


    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
        }
        return "/manage/login/login";
    }



}
