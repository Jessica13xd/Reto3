package com.usa.ciclo3.reto3.services;

import com.usa.ciclo3.reto3.model.Category;
import com.usa.ciclo3.reto3.repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private categoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category ct) {
        if (ct.getId() == null) {
            return categoryRepository.save(ct);
        } else {
            Optional<Category> paux = categoryRepository.getCategory(ct.getId());
            if (paux.isEmpty()) {
                return categoryRepository.save(ct);
            } else {
                return ct;
            }
        }
    }

    public Category update(Category ct) {
        if (ct.getId() != null) {
            Optional<Category> g = categoryRepository.getCategory(ct.getId());
            if (!g.isEmpty()) {
                if(ct.getName()!=null){
                    g.get().setName(ct.getName());
                }
                if(ct.getDescription()!=null){
                    g.get().setDescription(ct.getDescription());
                }
                return categoryRepository.save(g.get());
            }
        }
        return ct;
    }

    public boolean deleteCategory(int id){
        boolean d= getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }

}
