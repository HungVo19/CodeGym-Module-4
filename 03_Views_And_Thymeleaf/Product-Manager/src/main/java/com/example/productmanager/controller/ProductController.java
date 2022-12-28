package com.example.productmanager.controller;

import com.example.productmanager.model.Category;
import com.example.productmanager.model.Product;
import com.example.productmanager.service.impl.CategoryService;
import com.example.productmanager.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @ModelAttribute(name = "categories")
    public List<Category> findAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView showDataTable() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> products = productService.findAll();
        modelAndView.addObject("products",products);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute(name = "product") Product product, @RequestParam(name = "category") String category) {
        product.setCategory(categoryService.findOneByName(category));
        productService.save(product);
        return "redirect:/products/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("product", productService.findOne(id));
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam String keyword){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productService.searchByName(keyword));
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("product", productService.findOne(id));
        return modelAndView;
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id){
        productService.deleteById(id);
        return "redirect:/products/list";
    }
}
