package com.usa.ciclo3.reto3.controllers;

import com.usa.ciclo3.reto3.model.Skate;
import com.usa.ciclo3.reto3.services.SkateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class SkateController {

    @Autowired
    private SkateService skateService;

    @GetMapping("/all")
    public List<Skate> getSkates(){
        return skateService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Skate> getSkate(@PathVariable("id") int id){
        return skateService.getSkate(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate save(@RequestBody Skate s){
        return skateService.save(s);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate update(@RequestBody Skate s){
        return skateService.update(s);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteScore(@PathVariable("id") int id){
        return skateService.deleteSkate(id);
    }
}
