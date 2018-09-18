package com.bps.sw.model.exception_handling;

import com.bps.sw.model.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLDataException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MOAZEN on 9/15/2018.
 */

@RestController
public class StudentResource {

    private static Map<String,Student> studentRepo = new HashMap<>();
    static {
        Student saeed = new Student("saeed", "moazen", "855131026", "1");
        Student roya = new Student("roya", "ramezani", "855131012", "2");

        studentRepo.put(saeed.getNationalCode(),saeed);
        studentRepo.put(roya.getNationalCode(),roya);
    }

    @RequestMapping(value = "/get_std/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable int id) {
        Student result = studentRepo.get("" + id);
        if (result == null)
            throw new RecordNotFoundException("student with id " + id);
        return new ResponseEntity<>(studentRepo.get("" + id), HttpStatus.OK);
    }

    @RequestMapping(value = "/get_std2/{id}")
    public ResponseEntity<Object> getStudentById2(@PathVariable int id) throws SQLDataException {
        Student result = studentRepo.get("" + id);
        if (result == null)
            throw new SQLDataException("not found");
        return new ResponseEntity<>(studentRepo.get("" + id), HttpStatus.OK);
    }

}
