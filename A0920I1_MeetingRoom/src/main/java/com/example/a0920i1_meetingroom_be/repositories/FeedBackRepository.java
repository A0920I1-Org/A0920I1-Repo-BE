package com.example.a0920i1_meetingroom_be.repositories;
import com.example.a0920i1_meetingroom_be.models.entity.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;


import java.util.List;


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

    @Query(value = "select* from feed_back", nativeQuery = true)
    List<FeedBack> feedbackList();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO feed_back(date_feedback,description,is_handle, title,account_id,feed_back_type_id,meetingroom_id) VALUES (?1,?2,?3,?4,?5,?6,?7)", nativeQuery = true)
    void createFeedback(LocalDate dateFeedback, String description, boolean isHandle, String title, int account, int feedBackType, int meetingRoom);



    @Transactional
    @Query(value = "SELECT * FROM feed_back where id = ?1",nativeQuery = true)
    FeedBack findFeedbackById(long id);

    @Modifying
    @Transactional
    @Query(value = " UPDATE feed_back SET date_feedback = ?1, description = ?2, is_handle = ?3, title = ?4, account_id = ?5, feed_back_type_id = ?6, meetingroom_id = ?7, content = ?8 WHERE id = ?9", nativeQuery = true)
    void handleFeedback(LocalDate dateFeedback, String description, boolean isHandle, String title, int account, int feedBackType, int meetingRoom, String content, String id);
    @Modifying
    @Transactional
    @Query(value = " DELETE FROM feed_back where id = ?1  ",nativeQuery = true)
    void deleteFeedbackById(long id);
}

