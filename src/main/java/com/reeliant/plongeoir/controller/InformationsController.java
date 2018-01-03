package com.reeliant.plongeoir.controller;

import com.reeliant.plongeoir.service.MetaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class InformationsController{

    @Autowired
    private MetaDataService metaDataService;

    @GetMapping("/hours")
    public ModelAndView displayOpeningHoursPage() {
        List<String> hours = metaDataService.getOpeningHours();
        return new ModelAndView("hours","hours",hours);
    }

    @GetMapping("/rules")
    public ModelAndView displayRulesPage() {
        String rules = metaDataService.getMetaDataByKey("rules");
        return new ModelAndView("rules","rules",rules);
    }
}
