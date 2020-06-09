package org.hdwyl.tags.controller;

import com.atme8.commons.utils.StringUtil;
import org.hdwyl.tags.common.Constants;
import org.hdwyl.tags.common.security.Authentication;
import com.atme8.project.insuser.model.InsuserModel;
import com.atme8.project.insuser.service.InsuserService;
import com.atme8.tax.cloud.core.exception.SystemException;
import com.atme8.tax.cloud.core.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

@Controller
public class LoginController {

    @Autowired
    private InsuserService insuserService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String account, String password, Model model, HttpServletRequest request) {

        if (StringUtils.isNull(account)) {
            model.addAttribute("errors", Constants.MSG_ERROR_3); // 账号不存在
            return "login";
        }
        model.addAttribute("account", account);

        try {
            InsuserModel insuserModel = new InsuserModel();
            insuserModel.setUsrCode(account);
            InsuserModel result = insuserService.checkInsuser(insuserModel);
            if (result == null) {
                insuserModel.setUsrCode(null);
                insuserModel.setUsrName(account);
                result = insuserService.checkInsuser(insuserModel);
            }
            if (result == null) {
                model.addAttribute("errors", Constants.MSG_ERROR_1); // 账号不存在
                model.addAttribute("account", account);
                return "login";
            }
            InsuserModel iModel = insuserService.searchInsuser(insuserModel);
            if (iModel.getPassword() == null && StringUtil.isEmpty(password)) {
                request.getSession().setAttribute(Constants.KEY_LOGIN_USER, result);
                return "redirect:/";
            } else if (iModel.getPassword() != null && StringUtil.isEmpty(password)) {
                model.addAttribute("account", account);
                model.addAttribute("errors", Constants.MSG_ERROR_2);
                return "login";
            } else if (iModel.getPassword() == null && !StringUtil.isEmpty(password)) {
                model.addAttribute("account", account);
                model.addAttribute("errors", Constants.MSG_ERROR_2);
                return "login";
            } else if (!iModel.getPassword().equals(password)) {
                model.addAttribute("account", account);
                model.addAttribute("errors", Constants.MSG_ERROR_2);
                return "login";
            } else {
                request.getSession().setAttribute(Constants.KEY_LOGIN_USER, result);
                return "redirect:/";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw, true));
            model.addAttribute("errors", sw.toString());
            return "login";
        }
    }

    @RequestMapping(value = "/logout")
    public String signout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/toLogin";
    }

    /**
     * token登录
     * @param token
     * @return
     */
    @RequestMapping(value = "/authorize")
    public String authorize(String token, HttpServletRequest request) {
        String usrCode = Authentication.decodeUser(token);
        if(StringUtil.isEmpty(usrCode)){
            return "login";
        }
        InsuserModel insuserModel = new InsuserModel();
        insuserModel.setUsrCode(usrCode);
        try {
            InsuserModel iModel = insuserService.checkInsuser(insuserModel);
            if(iModel == null){
                return "login";
            }else if(StringUtil.isEmpty(iModel.getName())){
                return "login";
            }
            request.getSession().setAttribute(Constants.KEY_LOGIN_USER, iModel);
            return "redirect:/";
        } catch (SystemException e) {
            e.printStackTrace();
            return "login";
        }
    }

}
