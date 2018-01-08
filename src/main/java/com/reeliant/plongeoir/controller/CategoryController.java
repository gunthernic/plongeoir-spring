package com.reeliant.plongeoir.controller;

import com.reeliant.plongeoir.dto.BookCreateDTO;
import com.reeliant.plongeoir.dto.CategoryDTO;
import com.reeliant.plongeoir.service.CategoryService;
import java.io.IOException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
        @Autowired
        private CategoryService categoryService;

        @GetMapping("/bo/category/create")
        public ModelAndView displayCategoryCreationPage() {
                return new ModelAndView("bo-create-category","category",new CategoryDTO());
        }

        @PostMapping("/bo/category/create")
        public ModelAndView submitCategoryCreation(@ModelAttribute CategoryDTO category) {
                categoryService.createCategory(category);
                return new ModelAndView("redirect:/bo/home");
        }

        @GetMapping("/bo/category/{id}")
        public ModelAndView displayDetailCategoryPage(@PathVariable("id") Long id) {
                CategoryDTO category = categoryService.getById(id);
                return new ModelAndView("bo-detail-category","category",category);
        }

        @DeleteMapping("/bo/category/delete/{id}")
        @ResponseBody
        public ResponseEntity deleteCategory(@PathVariable("id") Long id) {
                categoryService.delete(id);
                return ResponseEntity.ok(HttpStatus.OK);
        }

        @GetMapping("/bo/category/update/{id}")
        public String displayUpdateCategoryPage(@PathVariable("id") Long id, Model model) {
                CategoryDTO categoryToUpdate = categoryService.getById(id);
                model.addAttribute("category",categoryToUpdate);
                model.addAttribute("id",id);
                return "bo-update-category";
        }

        @PostMapping("/bo/category/update/{id}")
        public ModelAndView submitCategoryUpdate(@PathVariable("id") Long id, @ModelAttribute CategoryDTO category) {
                categoryService.updateCategory(category,id);
                return new ModelAndView("redirect:/bo/home");
        }
}
