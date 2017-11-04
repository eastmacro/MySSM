package manage.controller;

import domain.User;
import manage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by Rujiao Xiong on 2017/4/8.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {


    @Autowired
    private LoginService service;

    @RequestMapping(value = "/index")
    public String loginPage() {
        return "user/userQueryMethod";
    }


    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public ModelAndView loginCheck(
            @RequestParam(value = "inputEmail", required = true) String emailAdress,
            @RequestParam(value = "inputPassword", required = true) String password,
            @CookieValue(value = "sessionId", required = false) String sessionId,
            @RequestHeader("Accept-Encoding") String encoding,
            @RequestHeader("Host") String host,
            HttpServletRequest request,
            HttpServletResponse response,
            RedirectAttributes rdAttr,
            User command) {


        boolean isValidUser = service.hasMatchUser(emailAdress, password);
        if (!isValidUser) {
            return new ModelAndView("login/login", "error", "账号或密码错误");
        } else {
            User user = service.getUserByEmail(emailAdress);
            service.loginSuccess(user,request.getRemoteAddr());
            rdAttr.addFlashAttribute("userName",user.getUsername());
            return new ModelAndView("redirect:/user/userQueryMethod");
        }
    }



    @RequestMapping(value="/fileinput")
    public String uploadFile(
            @RequestPart("file") MultipartFile[] files) throws IllegalStateException, IOException {
        for (int i = 0; i < files.length; i++) {

            files[i].transferTo(new File("D://"+files[i].getOriginalFilename()));
            System.out.println(files[i].getOriginalFilename());

        }
        return "redirect:/manage/queryMethod";
    }



}
