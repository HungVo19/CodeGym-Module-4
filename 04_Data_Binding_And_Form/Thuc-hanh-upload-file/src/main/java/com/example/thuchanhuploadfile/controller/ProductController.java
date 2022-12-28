package com.example.thuchanhuploadfile.controller;

import com.example.thuchanhuploadfile.model.Product;
import com.example.thuchanhuploadfile.model.ProductForm;
import com.example.thuchanhuploadfile.service.IProductService;
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
@RequestMapping("/product")
public class ProductController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public ModelAndView view() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") ProductForm productForm) {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try{
            FileCopyUtils.copy(productForm.getImage().getBytes(),new File(fileUpload + fileName));
        }catch (IOException ex){
            ex.printStackTrace();
        }
        Product product = new Product(productForm.getId(), productForm.getName(),
                productForm.getDescription(), fileName);
        productService.save(product);
        return "redirect:/product";
    }
}
