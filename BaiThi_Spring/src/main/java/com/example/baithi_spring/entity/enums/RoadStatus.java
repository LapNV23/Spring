package com.example.baithi_spring.entity.enums;

import com.example.baithi_spring.entity.Road;

public enum RoadStatus {
    Using(1), Under_construction(0), Under_renovation(-1);

    private int value;
    RoadStatus(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }

    public static RoadStatus of(int value){
        for (RoadStatus status :
                RoadStatus.values()){
            if (status.getValue() == value){
                return status;
            }
        }
        return RoadStatus.Under_renovation;
    }
}
