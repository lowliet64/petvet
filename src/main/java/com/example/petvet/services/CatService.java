package com.example.petvet.services;

import com.example.petvet.data.vo.v1.CatVO;

import com.example.petvet.data.vo.v2.CatVOV2;
import com.example.petvet.entities.Cat;
import com.example.petvet.exceptions.InstanceNotFoundException;
import com.example.petvet.mapper.DozerMapper;
import com.example.petvet.mapper.custom.CatMapper;
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

    @Autowired
    private CatMapper mapper;



    public List<CatVO> listAll(){

        return DozerMapper.parseListObjects( catRepository.findAll(),CatVO.class);
    }
    public CatVO createCat(CatVO cat){
        logger.info("create a cat a cat!");
        var entity = DozerMapper.parseObject(cat, Cat.class);
        var vo =  DozerMapper.parseObject(catRepository.save(entity),CatVO.class);
        return vo;
    }

    public CatVOV2 createCatV2(CatVOV2 cat){
        logger.info("create a cat a cat!");
        var entity = mapper.convertVoToEntity(cat);
        var vo =  mapper.convertEntityToVo(catRepository.save(entity));
        return vo;
    }


    public CatVO findById(long id) throws Exception{
        var entity = catRepository.findById(id).orElseThrow(()-> new InstanceNotFoundException("Resource not found!"));
        var cat = DozerMapper.parseObject(entity,CatVO.class);
        return cat;
    }


    public CatVO updateCat(long id, CatVO cat) throws  Exception{
        Cat instance = catRepository.findById(id).orElseThrow(()-> new InstanceNotFoundException("Resource not found!"));
        instance.setName(cat.getName());
        var vo = DozerMapper.parseObject( catRepository.save(instance),CatVO.class);
        return vo;
    }

    public void deleteCat(long id){
        Cat instance = catRepository.findById(id).orElseThrow(()-> new InstanceNotFoundException("Resource not found!"));
        catRepository.delete(instance);
    }

}
