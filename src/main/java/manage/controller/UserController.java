package manage.controller;

import domain.User;
import manage.service.UserService;
import org.apache.log4j.Logger;
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

    Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService service;


    /**
     * 列出所有用户
     * @param userName 用户名
     * @return 用户列表页面
     */
    @RequestMapping(value= "/userQueryMethod")
    public ModelAndView queryUser(@ModelAttribute("userName") String userName){
        Map<String, Object> map = new HashMap<String, Object>();
        List<User> users = service.queryAllUsers();
        map.put("userList", users);
        map.put("loginUser", userName);
        return new ModelAndView("/manage/user/userQuery", map);
    }

    /**
     * 编辑用户
     * @param id 用户id
     * @return 编辑用户页面
     */
    @RequestMapping(value="/edit/{id}")
    public ModelAndView editUser(@PathVariable("id")int id){
        User user = service.getUserById(id);
        return new ModelAndView("/manage/user/userEdit","user",user );
    }

    /**
     * 提交用户信息
     * @param user 用户Modlel
     * @return 跳转到用户列表
     */
    @RequestMapping(value = "/submitUser", method = RequestMethod.POST)
    public String submitUser(User user){
        service.updateUser(user);
        return "redirect:/user/userQueryMethod/";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id")int userId){
        service.deleteByPrimaryKey(userId);
        return "redirect:/user/userQueryMethod/";
    }

    /**
     * 上传用户头像
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

        logger.debug("调用的文件上传Method");
        Map<String, Object> mm = new HashMap<String, Object>();

        try {
            service.updateUserPhoto(file,id);
            mm.put("fileSize",String.valueOf(file.getSize()));
            //throw new IOException();
        }  catch (IOException e) {
            e.printStackTrace();
            //此时fileuploaded事件和initialPreview都不会执行
            mm.put("error", "文件上传失败！");
        }
        mm.put("initialPreview",new String[]{"文件上传成功"});
        return mm;
    }

}
