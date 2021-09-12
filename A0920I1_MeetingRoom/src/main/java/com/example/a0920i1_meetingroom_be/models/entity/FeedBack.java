package com.example.a0920i1_meetingroom_be.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateFeedback;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean ísHandle;

    @ManyToOne
    @JoinColumn(name="feedBackType_id" , referencedColumnName = "id")
    private FeedBackType feedBackType;

//    @JsonBackReference(value="acc-feedback")
    @ManyToOne
    @JoinColumn(name="account_id" , referencedColumnName = "id")
    private Account account;

}
