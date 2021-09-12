package com.example.a0920i1_meetingroom_be.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
//@NoArgsConstructor
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "area")
    private List<MeetingRoom> meetingRoomList;

  public Area(){

  }

    public Area(Area areaDto) {
    }
}
