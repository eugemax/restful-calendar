package com.example.restfulcalendar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.ZonedDateTime;
import java.util.Objects;




@Entity
public class Event{

    public static final long MIN_DURATION= 5L;

    public Event(String title, String description, ZonedDateTime startDate, Long minutesDuration, String name) {

        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.minutesDuration=minutesDuration;
        this.endDate=startDate.plusMinutes(minutesDuration);
        this.name = name;
    }

    public Event(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String title;

    private String description;


    private ZonedDateTime startDate;
    private ZonedDateTime endDate;

    @Min(MIN_DURATION)
    private Long minutesDuration;
    public Long getMinutesDuration() {
        return minutesDuration;
    }

    public void setMinutesDuration(Long minutesDuration) {

        this.minutesDuration=minutesDuration;
        this.endDate=startDate.plusMinutes(minutesDuration);
    }


    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStart(ZonedDateTime start) {
        this.startDate = start;
    }

    public ZonedDateTime getEnd() {
        return endDate;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", start=" + startDate +
                ", end=" + endDate +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Event))
            return false;
        Event event = (Event) o;
        return Objects.equals(this.id, event.id) && Objects.equals(this.title, event.title)
                && Objects.equals(this.description, event.description)&& Objects.equals(this.startDate, event.startDate)
                && Objects.equals(this.endDate, event.endDate)&& Objects.equals(this.name, event.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.description, this.startDate, this.endDate, this.name);
    }




}

