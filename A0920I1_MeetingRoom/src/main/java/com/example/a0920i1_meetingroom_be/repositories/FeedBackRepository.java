package com.example.a0920i1_meetingroom_be.repositories;
import com.example.a0920i1_meetingroom_be.models.entity.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack , Long> {
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE feed_back " +
                    "SET feed_back.is_handle = 1 " +
                    "WHERE feed_back.feed_back_type_id=2 and feed_back.id = :id"
            ,nativeQuery = true
    )
    void updateFeedBack(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO feed_back( description,date_feedback, is_handle, account_id,feed_back_type_id,meeting_room_id)VALUES (?1,?2,?3,?4,?5,?6)",
            nativeQuery = true
    )
    void createFeedBack(String description, LocalDate dateFeedback, boolean isHandle, int account, int feedBackType, int meeting_room_id);
}

