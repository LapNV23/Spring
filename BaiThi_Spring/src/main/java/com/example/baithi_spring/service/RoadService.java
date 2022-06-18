package com.example.baithi_spring.service;

import com.example.baithi_spring.entity.Road;
import com.example.baithi_spring.repository.RoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoadService {
    @Autowired
    private RoadRepository roadRepository;
    public Iterable<Road> findAll(){
        return roadRepository.findAll();
    }
    public Road save(Road road){
        return roadRepository.save(road);
    }
}
