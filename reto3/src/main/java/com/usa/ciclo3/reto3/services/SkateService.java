package com.usa.ciclo3.reto3.services;

import com.usa.ciclo3.reto3.model.Category;
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
    public Skate update(Skate s) {
        if (s.getId() != null) {
            Optional<Skate> st = skateRepository.getSkate(s.getId());
            if (!st.isEmpty()) {
                if(s.getName()!=null){
                    st.get().setName(s.getName());
                }
                if(s.getBrand()!=null){
                    st.get().setBrand(s.getBrand());
                }
                if(s.getYear()!=null){
                    st.get().setYear(s.getYear());
                }
                if(s.getDescription()!=null){
                    st.get().setDescription(s.getDescription());
                }
                return skateRepository.save(st.get());
            }
        }
        return s;
    }

    public boolean deleteSkate(int id){
        boolean dst= getSkate(id).map(skate -> {
            skateRepository.delete(skate);
            return true;
        }).orElse(false);
        return dst;
    }
}