package com.example.blogmanager.controller;

import com.example.blogmanager.model.Blog;
import com.example.blogmanager.model.BlogForm;
import com.example.blogmanager.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private IBlogService blogService;
    @GetMapping
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("blogs",blogService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blogForm",new BlogForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute(name = "blog") BlogForm blogForm) {
        MultipartFile multipartFile = blogForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(blogForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Blog blog = new Blog(blogForm.getId(), blogForm.getTitle(), blogForm.getContent(),fileName);
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        blogService.remove(id);
        return "redirect:/blogs";
    }

}
