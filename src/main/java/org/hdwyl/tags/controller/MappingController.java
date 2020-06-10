package org.hdwyl.tags.controller;

import com.alibaba.fastjson.JSONObject;
import org.hdwyl.tags.common.Constants;
import org.hdwyl.tags.domain.TagMapping;
import org.hdwyl.tags.domain.ThemeColumn;
import org.hdwyl.tags.service.TagsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/mapping")
public class MappingController {

    @Autowired
    protected TagsService tagsService;

    @RequestMapping(value = "/getTagMappings")
    public JSONObject getTagMappings(HttpServletRequest request, HttpServletResponse response) {
        int themeId = Integer.parseInt(request.getParameter("themeId"));
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        List<TagMapping> tagList = tagsService.getTagMappings(themeId, typeId);

        JSONObject json = new JSONObject();
        json.put("rows", tagList);
        json.put("total", tagList.size());

        return json;
    }

    @RequestMapping(value = "/getDict")
    public JSONObject getDict(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("keyword");
        String[] args = null;
        if (request.getParameter("args") != null) {
            args = StringUtils.split(request.getParameter("args"), ",");
        } else {
            args = new String[]{};
        }
        List<?> dictList = tagsService.getDict(keyword, args);

        JSONObject json = new JSONObject();
        json.put("dict", dictList);

        return json;
    }

    @RequestMapping(value = "/getDisplayColumns")
    public JSONObject getDisplayColumns(HttpServletRequest request, HttpServletResponse response) {
        int themeId = Integer.parseInt(request.getParameter("themeId"));
        List<ThemeColumn> columnList = tagsService.getDisplayColumns(themeId, Constants.Status.VALID.getValue());

        JSONObject json = new JSONObject();
        json.put("rows", columnList);
        json.put("total", columnList.size());

        return json;
    }

}
