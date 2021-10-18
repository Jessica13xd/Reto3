package com.usa.ciclo3.reto3.services;

import com.usa.ciclo3.reto3.model.Skate;
import com.usa.ciclo3.reto3.repository.skateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkateService {
    @Autowired
    private skateRepository skateRepository;

    public List<Skate> getAll(){
        return skateRepository.getAll();
    }
    public Optional<Skate> getSkate(int id){
        return skateRepository.getSkate(id);
    }
    public Skate save (Skate s){
        if(s.getId()==null){
            return skateRepository.save(s);
        }else{
            Optional<Skate> paux=skateRepository.getSkate(s.getId());
            if(paux.isEmpty()){
                return skateRepository.save(s);
            }else {
                return s;
            }
        }
    }
}