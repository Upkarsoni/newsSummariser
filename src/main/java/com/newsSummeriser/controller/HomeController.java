package com.newsSummeriser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.newsSummeriser.model.TrendingNews;
import com.newsSummeriser.service.NewsScraper;

@Controller
public class HomeController {

    @Autowired
    private NewsScraper newsScraper;

    @GetMapping("/")
    public String home(Model model) {
        
        List<TrendingNews> trendingNews = newsScraper.getMainNews("https://www.amarujala.com/");

        model.addAttribute("trendingNews", trendingNews);

        return "home";
    }
}

