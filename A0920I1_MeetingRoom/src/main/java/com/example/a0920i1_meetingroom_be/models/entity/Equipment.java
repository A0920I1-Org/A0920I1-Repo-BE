package com.example.a0920i1_meetingroom_be.models.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private int stock;
    @NotBlank
    private int repairQuantity;
    private String imageUrl;

    @JsonBackReference
    @OneToMany(mappedBy = "equipment")
    private List<OrderEquipment> orderEquipmentList;

}
