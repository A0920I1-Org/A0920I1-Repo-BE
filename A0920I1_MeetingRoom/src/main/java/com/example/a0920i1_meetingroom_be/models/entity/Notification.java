package com.example.a0920i1_meetingroom_be.models.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate dateNotification;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isSeen;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feedback_id", referencedColumnName = "id")
    private FeedBack feedBack;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateNotification() {
        return dateNotification;
    }

    public void setDateNotification(LocalDate dateNotification) {
        this.dateNotification = dateNotification;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }

    public FeedBack getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(FeedBack feedBack) {
        this.feedBack = feedBack;
    }


}
