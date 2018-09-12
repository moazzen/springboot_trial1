package com.bps.sw.model.rest;

import com.bps.sw.model.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Moazen on 9/11/2018.
 */
@RestController
public class Rest1 {
    private static Map<String, Student> productRepo = new HashMap<>();

    static {
        Student honey = new Student();
        honey.setFirstName("honey");
        honey.setLastName("sad");
        honey.setNationalCode("3");
        productRepo.put(honey.getNationalCode(), honey);

        Student david = new Student();
        david.setFirstName("david");
        david.setLastName("happy");
        david.setNationalCode("4");
        productRepo.put(david.getNationalCode(), honey);
    }


    /*ersale pasokhe JSON dar javabe webservice rest.
      az ResponseEntity estefade mikonim. parametre aval response ast ke be JSON tabdil migardad
    parametre dovom ham httpResponse ast.  */

    @RequestMapping(value = "/rest1")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    /*The HTTP POST request is used to create a resource. This method contains the Request Body.
    We can send request parameters and path variables to define the custom or dynamic URL.*/

    @RequestMapping(value = "/rest2", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Student student) {
        productRepo.put(student.getNationalCode(), student);
        return new ResponseEntity<>(productRepo.values(), HttpStatus.CREATED);
    }



    /*baraye update kardane yek resource mojood mamulan az http put estefade mikonand.in noe darkhast ham mitavanad daraye
    * url e dynamic bashad ham static. dar zemn mitavan az requestBody ham estefade kard. pas masalan mitavan ID e objecti ke bayad
    * update shavad ra az tarighe url ferestad va mavaredi ke bayad update shavad ra az tarighe requestBody. */

    @RequestMapping(value = "/rest3/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Student student) {
        productRepo.remove(id);
        student.setNationalCode(id);
        productRepo.put(id, student);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }



    @RequestMapping(value = "/rest4/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }
}
