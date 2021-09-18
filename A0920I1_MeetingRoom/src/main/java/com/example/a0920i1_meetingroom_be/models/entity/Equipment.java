package com.example.a0920i1_meetingroom_be.models.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
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

    @JsonBackReference(value = "equipment_id")
    @OneToMany(mappedBy = "equipment")
    private List<OrderEquipment> orderEquipmentList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getRepairQuantity() {
        return repairQuantity;
    }

    public void setRepairQuantity(int repairQuantity) {
        this.repairQuantity = repairQuantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<OrderEquipment> getOrderEquipmentList() {
        return orderEquipmentList;
    }

    public void setOrderEquipmentList(List<OrderEquipment> orderEquipmentList) {
        this.orderEquipmentList = orderEquipmentList;
    }
}
