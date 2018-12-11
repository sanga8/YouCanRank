package com.ycr.Controller;
import org.springframework.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;;


@Controller
public class LoginController{
    //@RequestMapping(value="/login", method = RequestMethod.GET)
    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }
/*
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String verifyLogin(@RequestParam String userId, @RequestParam String password){

        Customer customer = customerService.loginCustomer(userId, password);

    }
*/
}