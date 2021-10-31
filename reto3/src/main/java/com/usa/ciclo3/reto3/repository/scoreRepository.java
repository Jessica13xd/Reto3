package com.usa.ciclo3.reto3.repository;

import com.usa.ciclo3.reto3.model.Score;
import com.usa.ciclo3.reto3.repository.crud.scoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class scoreRepository {
    @Autowired
    private scoreCrudRepository scoreCrudRepository;

    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScore(int idScore){
        return scoreCrudRepository.findById(idScore);
    }
    public Score save(Score sr){
        return scoreCrudRepository.save(sr);
    }
    public void delete (Score sr) {scoreCrudRepository.delete(sr);}
}