package org.hdwyl.tags.controller;

import org.hdwyl.tags.common.Constants;
import org.hdwyl.tags.domain.TagTheme;
import org.hdwyl.tags.domain.TagType;
import org.hdwyl.tags.service.TagsService;
import org.hdwyl.tags.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class TagsController {

    protected TagsService tagsService;

    protected SearchService searchService;

    @Autowired
    public TagsController(TagsService tagsService, SearchService searchService) {
        this.tagsService = tagsService;
        this.searchService = searchService;
    }

    @RequestMapping("/")
    String index(HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }

    @RequestMapping("/home")
    String home(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }

    @RequestMapping("/toLogin")
    public String index(Model model, HttpServletRequest request){
        if (this.checkSignin(request)){
            return "redirect:/";
        }
        return "login";
    }

    @RequestMapping("/searchConfig")
    String searchConfig(HttpServletRequest request, HttpServletResponse response, Map<String, Object> resultMap) {
        List<TagTheme> tagThemeList = tagsService.getAllTagTheme();
        List<TagType> tagTypeList = tagsService.getAllTagType();
        resultMap.put("tagThemeList", tagThemeList);
        resultMap.put("tagTypeList", tagTypeList);
        return "searchConfig";
    }

    public boolean checkSignin(HttpServletRequest request){
        if (request.getSession().getAttribute(Constants.KEY_LOGIN_USER) == null){
            return false;
        }

        return true;
    }
}
