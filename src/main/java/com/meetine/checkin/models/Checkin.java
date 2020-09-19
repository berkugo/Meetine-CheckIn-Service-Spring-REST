package com.meetine.checkin.models;

import com.meetine.checkin.interfaces.CheckinRepository;
import com.meetine.checkin.interfaces.PlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "checkins")
public class Checkin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "note")
    private String checkInNote;
    @Column(name = "place")
    private String placeId;
    @Column(name = "uid")
    private String userId;
    @Column(name = "type")
    private int type;
    private Date checkInTime;

    protected Checkin()
    {}


    public Checkin(String checkInNote, int type, String placeId, String userId)
    {
        this.checkInNote = checkInNote;
        this.placeId = placeId;
        this.type = type;
        this.userId = userId;

    }


    public String getCheckInNote() {
        return checkInNote;
    }

    public String getPlaceId() {
        return placeId;
    }

    public String getUserId() {
        return userId;
    }

    public int getType() {
        return type;
    }

    public long getId() {
        return id;
    }
}
