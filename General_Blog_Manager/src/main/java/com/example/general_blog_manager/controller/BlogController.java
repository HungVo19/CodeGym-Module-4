package com.example.general_blog_manager.controller;

import com.example.general_blog_manager.model.Blog;
import com.example.general_blog_manager.model.Tag;
import com.example.general_blog_manager.service.IBlogService;
import com.example.general_blog_manager.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Value("${upload}")
    private String upload;
    @Autowired
    IBlogService blogService;
    @Autowired
    ITagService tagService;

    @ModelAttribute("tags")
    public Page<Tag> getAllTags(Pageable pageable) {
        return tagService.findAll(pageable);
    }

    @GetMapping
    public ModelAndView list(@RequestParam(name = "search") Optional<String> search, @PageableDefault(size = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/blog/index");
        if (!search.isPresent()) {
            modelAndView.addObject("blogs", blogService.findAll(pageable));
        } else {
            modelAndView.addObject("blogs", blogService.findByNameContaining(search.get(), pageable));
            modelAndView.addObject("search", search.get());
        }
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blogService.findById(id).get());
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/blog/view");
        modelAndView.addObject("blog", blogService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Blog blog) {
        MultipartFile multipartFile = blog.getImg();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(blog.getImg().getBytes(), new File(upload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        blog.setImage(fileName);
        blogService.save(blog);
        return new ModelAndView("redirect:/blogs");
    }

    @GetMapping("remove/{id}")
    public ModelAndView remove(@PathVariable Long id) {
        blogService.deleteById(id);
        return new ModelAndView("redirect:/blogs");
    }

}
