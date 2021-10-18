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

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    public Category save (Category ct){
        if(ct.getId()==null){
            return categoryRepository.save(ct);
        }else{
            Optional<Category> paux=categoryRepository.getCategory(ct.getId());
            if(paux.isEmpty()){
                return categoryRepository.save(ct);
            }else {
                return ct;
            }
        }
    }
}
