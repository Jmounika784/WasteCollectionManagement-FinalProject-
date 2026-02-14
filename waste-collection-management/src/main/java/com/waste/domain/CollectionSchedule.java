package com.waste.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "collection_schedule")
public class CollectionSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "schedule_id", unique = true)
    private String scheduleId;

    @Column(nullable = false)
    private String zone;

    @Column(name = "collection_day", nullable = false)
    private String collectionDay;

    @Column(name = "collection_time", nullable = false)
    private String collectionTime;

    public CollectionSchedule() {}

    public Integer getId() { return id; }
    public String getScheduleId() { return scheduleId; }
    public String getZone() { return zone; }
    public String getCollectionDay() { return collectionDay; }
    public String getCollectionTime() { return collectionTime; }

    public void setId(Integer id) { this.id = id; }
    public void setScheduleId(String scheduleId) { this.scheduleId = scheduleId; }
    public void setZone(String zone) { this.zone = zone; }
    public void setCollectionDay(String collectionDay) { this.collectionDay = collectionDay; }
    public void setCollectionTime(String collectionTime) { this.collectionTime = collectionTime; }
}
