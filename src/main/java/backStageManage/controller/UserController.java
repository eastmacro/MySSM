package backStageManage.controller;

import backStageManage.service.UserService;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rujiao Xiong on 2017/4/23.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;


    /**
     * 处理form表单提交的文件
     * @param userName
     * @return
     */
    @RequestMapping(value= "/userQueryMethod")
    public ModelAndView queryUser(@ModelAttribute("userName") String userName){
        Map<String, Object> map = new HashMap<String, Object>();
        List<User> users = service.queryAllUsers();
        map.put("userList", users);
        map.put("loginUser", userName);
        return new ModelAndView("/user/userQuery", map);
    }

    @RequestMapping(value="/edit")
    public ModelAndView editUser(@RequestParam("id")int id){
        User user = service.getUserById(id);
        return new ModelAndView("/user/userEdit","user",user );
    }

    @RequestMapping(value = "/submitUser", method = RequestMethod.POST)
    public String submitUser(User user){
        service.updateUser(user);
        return "redirect:/user/edit?id="+user.getId();
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
            @RequestPart("file") MultipartFile file,
            @RequestParam("id") int id) {

        Map<String, Object> mm = new HashMap<String, Object>();

        try {
            service.updateUserPhoto(file,id);
            mm.put("fileSize",String.valueOf(file.getSize()));
            //throw new IOException();
        }  catch (IOException e) {
            e.printStackTrace();
            mm.put("error", "文件上传失败！");//此时fileuploaded事件和initialPreview都不会执行
        }
        mm.put("initialPreview",new String[]{"文件上传成功"});
        return mm;
    }

}
