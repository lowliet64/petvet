package com.example.petvet.services;

import com.example.petvet.entities.Cat;
import com.example.petvet.exceptions.InstanceNotFoundException;
import com.example.petvet.repositories.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;


@Service
public class CatService {

    private  final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(CatService.class.getName());
    @Autowired
    private CatRepository catRepository;



    public List<Cat> listAll(){

        return catRepository.findAll();
    }
    public Cat createCat(Cat cat){
        logger.info("create a cat a cat!");
        return catRepository.save(cat);
    }


    public Cat findById(long id) throws Exception{
        Cat cat = catRepository.findById(id).orElseThrow(()-> new InstanceNotFoundException("Resource not found!"));
        return cat;
    }


    public Cat updateCat(long id, Cat cat) throws  Exception{
        Cat instance = catRepository.findById(id).orElseThrow(()-> new InstanceNotFoundException("Resource not found!"));
        instance.setName(cat.getName());
        return  catRepository.save(instance);
    }

    public void deleteCat(long id){
        Cat instance = catRepository.findById(id).orElseThrow(()-> new InstanceNotFoundException("Resource not found!"));
        catRepository.delete(instance);
    }

}
