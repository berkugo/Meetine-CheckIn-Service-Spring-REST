package com.meetine.checkin.rest;


import com.meetine.checkin.interfaces.CheckinRepository;
import com.meetine.checkin.interfaces.PlacesRepository;
import com.meetine.checkin.models.Checkin;
import org.apache.coyote.Response;
import org.apache.tomcat.util.json.JSONParser;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
public class Controller {


    @Autowired
    public PlacesRepository jpaController;

    @Autowired
    public CheckinRepository crudController;

    @RequestMapping(path = "/checkin/{userid}", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    ResponseEntity<String> checkIn(@PathVariable String userid)
    {
        crudController.save(new Checkin("gelin belki bi kahve ısmarlarım adşlkf", 1, "563b9ba6cd10d338a4ac0a0a", userid));
        return ResponseEntity.ok(jpaController.getOne("563b9ba6cd10d338a4ac0a0a").getData());
    }

    @RequestMapping(path = "/getcheckin", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<Checkin> getCheckIn(@RequestParam Long id) throws NoSuchFieldException {
        ResponseEntity<Checkin> result = ResponseEntity.of(crudController.findById(id));
        crudController.findAll().forEach(this::callback);
        if(result.getBody() != null)
            return result;
        else throw new NoSuchFieldException();
    }

    public void callback(Checkin checkin)
    {
        System.out.println(checkin.getCheckInNote());
    }

    @ExceptionHandler(NoSuchFieldException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        return "Not found.";
    }




}
