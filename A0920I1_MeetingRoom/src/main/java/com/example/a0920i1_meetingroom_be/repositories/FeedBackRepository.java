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
//feedback repo TriNH
public interface FeedBackRepository extends JpaRepository<FeedBack , Long> {
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE feed_back " +
                    "SET feed_back.is_handle = 1 " +
                    "WHERE feed_back.feed_back_type_id= 2 and feed_back.id = :id"
            ,nativeQuery = true
    )
    void updateFeedBack(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO feed_back(content, description,date_feedback, is_handle,title, account_id,feed_back_type_id,meetingroom_id )VALUES (?1,?2,?3,?4,?5,?6,?7,?8)",
            nativeQuery = true
    )
    void createFeedBack(String content,String description, LocalDate dateFeedback, boolean isHandle,String title,
                        int account, int feedBackType, int meetingroom_id,String imageFeedBackList);
}

