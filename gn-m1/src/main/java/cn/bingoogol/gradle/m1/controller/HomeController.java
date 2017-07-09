package cn.bingoogol.gradle.m1.controller;

import cn.bingoogol.gradle.m1.dto.AjaxObj;
import cn.bingoogol.gradle.m1.model.Person;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/9 下午12:09
 * 描述:
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String json() {
        AjaxObj ajaxObj = new AjaxObj();
        ajaxObj.setSuccess(false);
        ajaxObj.setMsg("你好，Gradle, jsjflksjdfklsjdlfkjskldfjsdfskl");
        String result = JSON.toJSONString(ajaxObj);
        System.out.println(result);
        return result;
    }

    @RequestMapping("/test")
    public String loadTestPage(Model m) {
        m.addAttribute("name", "dfsdfsdfssdfsdf呵呵哈哈");
        return "test";
    }

    @RequestMapping("/redirect")
    public String redirect() {
        return "redirect:/test";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String upload(Person person, HttpServletRequest request) {
        MultipartHttpServletRequest rm = (MultipartHttpServletRequest) request;
        CommonsMultipartFile cfile = (CommonsMultipartFile) rm.getFile("pic");
        String originalFilename = cfile.getOriginalFilename();
        System.out.println(originalFilename);
        System.out.println(person.getName());
        System.out.println(person.getBirthday());
        AjaxObj ajaxObj = new AjaxObj();
        ajaxObj.setSuccess(true);
        ajaxObj.setMsg("上传成功");
        return JSON.toJSONString(ajaxObj);
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

}