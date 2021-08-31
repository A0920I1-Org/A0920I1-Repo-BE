package com.example.a0920i1_meetingroom_be.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Integer stock;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean repairement;

    private String imageUrl;

    @JsonBackReference
    @OneToMany(mappedBy = "equipment")
    private List<OrderEquipment> orderEquipmentList;




}
