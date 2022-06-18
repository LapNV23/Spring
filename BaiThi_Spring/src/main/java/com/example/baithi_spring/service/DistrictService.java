package com.example.baithi_spring.service;

import com.example.baithi_spring.entity.District;
import com.example.baithi_spring.entity.Road;
import com.example.baithi_spring.repository.DistrictRepository;
import com.example.baithi_spring.repository.RoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    public Iterable<District> findAll(){
        return districtRepository.findAll();
    }
    public District save(District district){
        return districtRepository.save(district);
    }
}
