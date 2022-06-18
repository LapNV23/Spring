package com.example.baithi_spring.controller;

import com.example.baithi_spring.entity.District;
import com.example.baithi_spring.entity.Road;
import com.example.baithi_spring.service.DistrictService;
import com.example.baithi_spring.service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/v1/district")
public class DistrictController {
    @Autowired
    DistrictService districtService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<District>> getList() {
        return ResponseEntity.ok(districtService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<District> create(@RequestBody District district) {
        return ResponseEntity.ok(districtService.save(district));
    }

}
