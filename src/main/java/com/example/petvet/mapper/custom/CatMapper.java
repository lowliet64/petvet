package com.example.petvet.mapper.custom;

import com.example.petvet.data.vo.v2.CatVOV2;
import com.example.petvet.entities.Cat;
import org.springframework.stereotype.Service;

@Service
public class CatMapper {

    public CatVOV2 convertEntityToVo(Cat cat){
        CatVOV2 vo = new CatVOV2();
        vo.setId(cat.getId());
        vo.setName(cat.getName());
        vo.setGender("M");
        return vo;
    }


    public Cat convertVoToEntity(CatVOV2 vo){
        Cat cat = new Cat();
        cat.setId(vo.getId());
        cat.setName(vo.getName());
        //cat.setGender("M");

        return cat;
    }
}
