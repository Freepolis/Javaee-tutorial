package com.system.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.service.AccountBiz;

/**
 * Created by c0de8ug on 16-2-16.
 */
@Controller

@RequestMapping("account.do")
public class AccountController {
	@Autowired
    private AccountBiz accountBiz;

    @RequiresAuthentication
    @RequestMapping("profile.view")
    public String profileView() {
        return "/admin/system/account/profile";

    }

    @RequiresAuthentication
    @RequestMapping("update")
    public String update(HttpSession session, String password) {
        String id = (String) session.getAttribute("username");
        accountBiz.updatePassword(id, password);
        return "redirect:/account.do/profile.view";
    }
}
