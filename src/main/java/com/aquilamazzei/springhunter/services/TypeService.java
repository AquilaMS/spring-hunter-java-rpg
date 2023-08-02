package com.aquilamazzei.springhunter.services;

import com.aquilamazzei.springhunter.entities.Type;
import com.aquilamazzei.springhunter.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

    @Autowired
    TypeRepository typeRepository;

    public void insertType(Type type){
        typeRepository.save(type);
    }
}
