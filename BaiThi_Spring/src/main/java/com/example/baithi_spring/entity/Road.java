package com.example.baithi_spring.entity;

import com.example.baithi_spring.entity.enums.RoadStatus;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "roads")
public class Road {
    @Id
    private String name;
    private String district_id;
    private  String founding;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private RoadStatus status;
}
