package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.dto.EquipmentDto;
import com.example.a0920i1_meetingroom_be.models.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    @Query(value = " select * from Equipment;", nativeQuery = true)
    List<Equipment> findAllEquipment();

    @Transactional
    @Modifying
    @Query(value = "insert into equipment(name,stock,repair_quantity,image_url) value (?1,?2,?3,?4);", nativeQuery = true)
    void createEquipment(String name, int stock, int repairQuantity, String imageUrl);

    @Query(value = "select * from Equipment where Equipment.id=?1", nativeQuery= true)
    Equipment showDetailEquipment(long id);

    @Transactional
    @Modifying
    @Query(value = "delete from Equipment where id = ?1",nativeQuery = true)
    void deleteEquipmentById(long id);

    @Transactional
    @Modifying
    @Query(value = "update equipment set name = ?1,  stock = ?2, repair_quantity = ?3 ," +
            " image_url = ?4  where equipment.id = ?5", nativeQuery = true)

    void updateEquipment(String name , int stock , int repair_quantity , String image_url, long id);

    @Query(value = "select * from meetingroom.equipment where equipment.name like %?1% ",nativeQuery = true)
   List<Equipment> searchName(String name);

}
