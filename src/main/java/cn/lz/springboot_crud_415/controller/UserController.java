package cn.lz.springboot_crud_415.controller;

import cn.lz.springboot_crud_415.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("getAllUser")
    public List<Map> findAll() {
        return userService.findAll();
    }
}
