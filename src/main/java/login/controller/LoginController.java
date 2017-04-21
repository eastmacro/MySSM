package login.controller;

import domain.User;
import login.service.LoginService;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return "login/login";
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
            return new ModelAndView("redirect:/login/queryMethod");
        }
    }

    /**
     * 处理form表单提交的文件
     * @param userName
     * @return
     */
    @RequestMapping(value="/queryMethod")
    public ModelAndView queryUser(@ModelAttribute("userName") String userName){
        Map<String, Object> map = new HashMap<String, Object>();
        List<User> users = service.queryAllUsers();
        map.put("userList", users);
        map.put("loginUser", userName);
        return new ModelAndView("/login/query", map);
    }

    @RequestMapping(value="/fileinput")
    public String uploadFile(
            @RequestPart("file") MultipartFile[] files) throws IllegalStateException, IOException {
        for (int i = 0; i < files.length; i++) {

            files[i].transferTo(new File("D://"+files[i].getOriginalFilename()));
            System.out.println(files[i].getOriginalFilename());

        }
        return "redirect:/login/queryMethod";
    }

    /**
     * 处理ajax异步文件上传，异步每次上传一个
     *
     * @param file
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value="/fileinputAjax")
    public Object uploadFileAjax(
            @RequestPart("file") MultipartFile file) {

        Map<String, Object> mm = new HashMap<String, Object>();
        try {
            file.transferTo(new File("D://"+file.getOriginalFilename()));
            mm.put("fileSize",String.valueOf(file.getSize()));
        }  catch (IOException e) {
            e.printStackTrace();
            mm.put("error", "文件上传失败！");//此时fileuploaded事件和initialPreview都不会执行
        }
        mm.put("initialPreview",new String[]{"文件上传成功"});
        return mm;
    }
    @RequestMapping(value="/edit")
    public ModelAndView editUser(@RequestParam("id")int id){
        User user = service.getUserById(id);
        return new ModelAndView("/login/edit","user",user );
    }
}
