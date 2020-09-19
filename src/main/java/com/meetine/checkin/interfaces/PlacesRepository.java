package com.meetine.checkin.interfaces;

import com.meetine.checkin.models.Places;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacesRepository extends JpaRepository<Places, String> {

}
