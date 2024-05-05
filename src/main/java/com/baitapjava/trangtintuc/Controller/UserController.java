package com.baitapjava.trangtintuc.Controller;

import com.baitapjava.trangtintuc.Entity.User;
import com.baitapjava.trangtintuc.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl service;

    @GetMapping("/listuser")
    public List<User> alluser() {
        return service.alluser();
    }

    @PutMapping("/suauser/{id}")
    public User suauser(@PathVariable int id, @RequestBody User user) {
        return service.suauser(id, user);
    }

    @PostMapping("/themuser")
    public User themuser(@RequestBody User user) {
        return service.themuser(user);
    }

    @DeleteMapping("/xoauser/{id}")
    public void xoauser(@PathVariable int id) {
        service.xoauser(id);
    }

    @GetMapping("/loginUser")
    public User loginUser(@RequestParam String taikhoan, @RequestParam String matkhau) {
        return service.userLogin(taikhoan, matkhau);
    }

    @GetMapping("oneUser/{id}")
    public User oneUser(@PathVariable int id) {
        return service.oneuser(id);
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        return service.userSigup(user);
    }

    @DeleteMapping("/xoaUser")
    public void xoaUser(@RequestParam int id) {
        service.xoaUser(id);
    }

    @PutMapping("/resetPassword")
    public String resetPassword(@RequestParam String username, @RequestParam String email) {
        return service.resetPassword(username,email);
    }
}
