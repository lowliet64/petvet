package com.example.petvet.controllers;


import com.example.petvet.data.vo.v1.CatVO;
import com.example.petvet.data.vo.v2.CatVOV2;
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
    public List<CatVO> findAll(){
        return catService.listAll();
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CatVO findCat(@PathVariable(value="id") int id)  throws Exception{
        return catService.findById(id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCat(@PathVariable(value="id") int id)  throws Exception{
            catService.deleteCat(id);
            return ResponseEntity.noContent().build();
    }


    // ======================== Treinando versionamento de endpoints
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public CatVO create(@RequestBody CatVO cat){
        return catService.createCat(cat);
    }

    @PostMapping(value="/v2",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public CatVOV2 createV2(@RequestBody CatVOV2 cat){
        return catService.createCatV2(cat);
    }
    //======================


    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public CatVO update(@RequestBody CatVO cat , @PathVariable int id) throws  Exception{
        return catService.updateCat(id,cat);
    }

}
