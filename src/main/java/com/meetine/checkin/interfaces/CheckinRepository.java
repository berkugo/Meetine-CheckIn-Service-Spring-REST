package com.meetine.checkin.interfaces;

import com.meetine.checkin.models.Checkin;
import org.springframework.data.repository.CrudRepository;

public interface CheckinRepository extends CrudRepository<Checkin, Long> {


}
