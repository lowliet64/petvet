package com.example.petvet.controllers;


import com.example.petvet.entities.Cat;
import com.example.petvet.exceptions.InstanceNotFoundException;
import com.example.petvet.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("cats")
public class CatController {

    @Autowired
    CatService catService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cat> findAll(){
        return catService.listAll();
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Cat findCat(@PathVariable(value="id") int id)  throws Exception{
        return catService.findById(id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCat(@PathVariable(value="id") int id)  throws Exception{
            catService.deleteCat(id);
            return ResponseEntity.noContent().build();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Cat create(@RequestBody Cat cat){
        return catService.createCat(cat);
    }

    @PutMapping(name="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Cat update(@RequestBody Cat cat , @PathVariable int id) throws  Exception{
        return catService.updateCat(id,cat);
    }

}
