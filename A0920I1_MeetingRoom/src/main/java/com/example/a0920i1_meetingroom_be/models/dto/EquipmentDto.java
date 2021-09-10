package com.example.a0920i1_meetingroom_be.models.dto;

public class EquipmentDto {
    private long id;

    private String name;
    private int stock;

    private int repairQuantity;

    private String imageUrl;

    public EquipmentDto() {

    }

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
}
