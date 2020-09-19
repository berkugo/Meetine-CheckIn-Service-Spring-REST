package com.meetine.checkin.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="places")
@Entity
public class Places {

    @Id
    @Column(name = "id")
    private String placeId;
    @Column(name = "data")
    private String data;



    protected Places(){};

    public String getData() {
        return data;
    }


    public String getPlaceId() {
        return placeId;
    }
}
