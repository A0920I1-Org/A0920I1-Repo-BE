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

    @JsonBackReference(value = "equipment_id")
    @OneToMany(mappedBy = "equipment")
    private List<OrderEquipment> orderEquipmentList;

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getStock() {
//        return stock;
//    }
//
//    public void setStock(Integer stock) {
//        this.stock = stock;
//    }
//
//    public Boolean getRepairement() {
//        return repairement;
//    }
//
//    public void setRepairement(Boolean repairement) {
//        this.repairement = repairement;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }

//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public List<OrderEquipment> getOrderEquipmentList() {
//        return orderEquipmentList;
//    }
//
//    public void setOrderEquipmentList(List<OrderEquipment> orderEquipmentList) {
//        this.orderEquipmentList = orderEquipmentList;
//    }
}
