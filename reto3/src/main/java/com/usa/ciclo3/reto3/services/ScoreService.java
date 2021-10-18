package com.usa.ciclo3.reto3.services;

import com.usa.ciclo3.reto3.model.Score;
import com.usa.ciclo3.reto3.repository.scoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private scoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    public Optional<Score> getScore(int idScore){
        return scoreRepository.getScore(idScore);
    }
    public Score save (Score sr){
        if(sr.getIdScore()==null){
            return scoreRepository.save(sr);
        }else{
            Optional<Score> paux=scoreRepository.getScore(sr.getIdScore());
            if(paux.isEmpty()){
                return scoreRepository.save(sr);
            }else {
                return sr;
            }
        }
    }
}
