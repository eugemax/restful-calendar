package com.example.restfulcalendar.repositories;

import com.example.restfulcalendar.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;


public interface EventRepository extends JpaRepository <Event, Long>{

    @Query(value = "SELECT * FROM Event WHERE (  (make_timestamptz(?1, 1, 1, 0, 0, 0), make_timestamptz(?1, 12, 31, 23, 59, 0))OVERLAPS (start_date, end_date) )",nativeQuery = true)
    List <Event> findByYear(Integer year);

    @Query(value = "SELECT * FROM Event WHERE ( (make_timestamptz(?1, ?2, 1, 0, 0, 0), make_timestamptz(?1, ?2+1, 1, 0, 0, 0))OVERLAPS (start_date, end_date))",nativeQuery = true)
    List<Event> findByMonth(Integer year, Integer month);

    @Query(value = "SELECT * FROM Event WHERE ( (make_timestamptz(?1,?2,?3,0,0,0),INTERVAL '24 hours')OVERLAPS (start_date, end_date) )",nativeQuery = true)
    List<Event> findByDate( Integer year,Integer month, Integer day);

    @Query(value = "SELECT * FROM Event WHERE (  (make_timestamptz(?1, ?2, ?3, ?4, ?5, 0 ), make_timestamptz(?6, ?7, ?8, ?9, ?10, 0) ) OVERLAPS (start_date, end_date)) ",nativeQuery = true)
    List<Event> findByRange(Integer yearStart, Integer monthStart, Integer dayStart, Integer hourStart, Integer MinuteStart,
                                      Integer yearEnd, Integer monthEnd, Integer dayEnd, Integer hourEnd, Integer MinuteEnd);
}
