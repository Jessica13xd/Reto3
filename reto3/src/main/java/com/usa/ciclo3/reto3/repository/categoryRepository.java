package com.usa.ciclo3.reto3.repository;

import com.usa.ciclo3.reto3.model.Category;
import com.usa.ciclo3.reto3.repository.crud.categoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class categoryRepository {
    @Autowired
    private categoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    public Category save(Category ct){
        return categoryCrudRepository.save(ct);
    }
    public void delete (Category ct){categoryCrudRepository.delete(ct);}
}