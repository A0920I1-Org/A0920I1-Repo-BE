package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.OrderMeeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderMeetingRepository extends JpaRepository<OrderMeeting , Long> {
    @Query(
            value = "select * " +
                    "from order_meeting om " +
                    "where (om.date_checkin >= :dateCheckin and om.date_checkout <= :dateCheckout)"
            , nativeQuery = true 
    )
    List<OrderMeeting> statisticByDate(@Param("dateCheckin")String dateCheckin,
                                  @Param("dateCheckout")String dateCheckout);

    @Query(
            value = "select * " +
                    "from order_meeting om " +
                    "where (om.date_checkout <= :dateCheckout)"
            , nativeQuery = true
    )
    List<OrderMeeting> statisticByDateCheckinNull(@Param("dateCheckout")String dateCheckout);

    @Query(
            value = "select * " +
                    "from order_meeting om " +
                    "where (om.date_checkin >= :dateCheckin )"
            , nativeQuery = true
    )
    List<OrderMeeting> statisticByDateCheckoutNull(@Param("dateCheckin")String dateCheckin);


    @Query(
            value = "select * " +
                    "from order_meeting om " +
                    "inner join meeting_room mr on mr.id = om.meeting_room_id " +
                    "where (om.meeting_room_id like %:idMeetingRoom% " +
                    "and mr.type_meeting_room_id like %:idTypeMeetingRoom% " +
                    "and month(om.date_checkin) like %:month%)"
            , nativeQuery = true
    )
    List<OrderMeeting> statisticByRoom(@Param("idTypeMeetingRoom")String idTypeMeetingRoom,
                                       @Param("idMeetingRoom")String idMeetingRoom,
                                       @Param("month")String month);

    @Query(
            value = "select * " +
                    "from order_meeting om " +
                    "where om.account_id = :accountId "
            , nativeQuery = true
    )
    List<OrderMeeting> getOrderMeetingByAccountId(@Param("accountId")String accountId);

    @Query(
            value = "select * " +
                    "from order_meeting " +
                    "where order_meeting.id = :idOrder"
            , nativeQuery = true
    )
    OrderMeeting findOrderMeetingByIdOrder(@Param("idOrder")String idOrder);

    @Query(
            value = "select * " +
                    "from order_meeting om " +
                    "inner join meeting_room mr on mr.id = om.meeting_room_id " +
                    "where mr.name like %:idMeetingRoom% " +
                    "and om.date_checkin >= :dateCheckin " +
                    "and om.date_checkout <= :dateCheckout " +
                    "and mr.room_status_id like %:idStatusRoom% " +
                    "and mr.type_meeting_room_id like %:idTypeMeetingRoom% " +
                    "and om.create_date like %:createDate% " +
                    "and om.account_id like %:accountId% "
            , nativeQuery = true
    )
    List<OrderMeeting> findRegisterHistory(
            @Param("idMeetingRoom")String idMeetingRoom,
            @Param("dateCheckin")String dateCheckin,
            @Param("dateCheckout")String dateCheckout,
            @Param("idStatusRoom")String idStatusRoom,
            @Param("idTypeMeetingRoom")String idTypeMeetingRoom,
            @Param("createDate")String createDate,
            @Param("accountId")String accountId
    );

    @Query(
            value = "select * " +
                    "from order_meeting om " +
                    "inner join meeting_room mr on mr.id = om.meeting_room_id " +
                    "where mr.name like %:idMeetingRoom% " +
                    "and om.date_checkout <= :dateCheckout " +
                    "and mr.room_status_id like %:idStatusRoom% " +
                    "and mr.type_meeting_room_id like %:idTypeMeetingRoom% " +
                    "and om.create_date like %:createDate% " +
                    "and om.account_id like %:accountId% "
            , nativeQuery = true
    )
    List<OrderMeeting> findRegisterHistoryDateCheckinNull(
            @Param("idMeetingRoom")String idMeetingRoom,
            @Param("dateCheckout")String dateCheckout,
            @Param("idStatusRoom")String idStatusRoom,
            @Param("idTypeMeetingRoom")String idTypeMeetingRoom,
            @Param("createDate")String createDate,
            @Param("accountId")String accountId
    );

    @Query(
            value = "select * " +
                    "from order_meeting om " +
                    "inner join meeting_room mr on mr.id = om.meeting_room_id " +
                    "where mr.name like %:idMeetingRoom% " +
                    "and om.date_checkin >= :dateCheckin " +
                    "and mr.room_status_id like %:idStatusRoom% " +
                    "and mr.type_meeting_room_id like %:idTypeMeetingRoom% " +
                    "and om.create_date like %:createDate% " +
                    "and om.account_id like %:accountId% "
            , nativeQuery = true
    )
    List<OrderMeeting> findRegisterHistoryDateCheckoutNull(
            @Param("idMeetingRoom")String idMeetingRoom,
            @Param("dateCheckin")String dateCheckin,
            @Param("idStatusRoom")String idStatusRoom,
            @Param("idTypeMeetingRoom")String idTypeMeetingRoom,
            @Param("createDate")String createDate,
            @Param("accountId")String accountId
    );

    @Query(
            value = "select * " +
                    "from order_meeting om " +
                    "inner join meeting_room mr on mr.id = om.meeting_room_id " +
                    "where mr.name like %:idMeetingRoom% " +
                    "and mr.room_status_id like %:idStatusRoom% " +
                    "and mr.type_meeting_room_id like %:idTypeMeetingRoom% " +
                    "and om.create_date like %:createDate% " +
                    "and om.account_id like %:accountId% "
            , nativeQuery = true
    )
    List<OrderMeeting> findRegisterHistoryDateCheckinAndCheckoutNull(
            @Param("idMeetingRoom")String idMeetingRoom,
            @Param("idStatusRoom")String idStatusRoom,
            @Param("idTypeMeetingRoom")String idTypeMeetingRoom,
            @Param("createDate")String createDate,
            @Param("accountId")String accountId
    );

    @Modifying
    @Transactional
    @Query(
            value = "update order_meeting om " +
                    "inner join meeting_room mr on mr.id = om.meeting_room_id " +
                    "inner join room_status rs on rs.id = mr.room_status_id " +
                    "set om.reason_delete = :reasonDelete, om.delete_time = :deleteTime, mr.room_status_id = 2 " +
                    "where om.id = :idOrder"
            , nativeQuery = true
    )
    void deleteRegister(
            @Param("idOrder")String idOrder,
            @Param("reasonDelete")String reasonDelete,
            @Param("deleteTime") Date deleteTime
    );


    @Query(
            value = "select * " +
                    "from order_meeting om " +
                    "where om.id = :idOrder"
            , nativeQuery = true
    )
     List<OrderMeeting> checkIsDelete(
             @Param("idOrder")String idOrder);

}
