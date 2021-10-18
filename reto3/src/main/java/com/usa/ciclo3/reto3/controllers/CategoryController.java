package com.usa.ciclo3.reto3.controllers;

import com.usa.ciclo3.reto3.model.Category;
import com.usa.ciclo3.reto3.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getCategorys(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return categoryService.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category ct){
        return categoryService.save(ct);
    }
}