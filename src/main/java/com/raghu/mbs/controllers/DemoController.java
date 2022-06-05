package com.raghu.mbs.controllers;

import com.raghu.mbs.dtos.DemoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * I need to tell spring,this class is a controller class
 * Bean has to be ready
 *
 * 127.0.0.1:8081/mbs/v1/demos
 */
@RestController
@RequestMapping("/mbs/v1/demos")   /** routing **/
public class DemoController {
    /**
     * GET:127.0.0.1:8081/mbs/v1/demos
     *
     * return as response Hello World
     */
    @GetMapping
    public ResponseEntity getDemoResponse(){
        return new ResponseEntity("Hello World!", HttpStatus.OK);
    }

    /**
     * Get 127.0.0.1:8081/mbs/v1/demos/{demo_id}
     */
    @GetMapping("/{demo_id}")
    public ResponseEntity getResponseBasedOnId(@PathVariable("demo_id") int demoId){
        return new ResponseEntity("Demo for the ID: "+demoId,HttpStatus.OK);
    }
    /**
     * Create a new demo
     * POST 127.0.0.1:7777/mbs/v1/demo
     *
     * Request body
     * {
     *     "demo_name":"",
     *     "demo_id":"",
     *     "demo_desc":""
     * }
     */

    @PostMapping
    public ResponseEntity createDemo(@RequestBody DemoDTO demoDTO){
        System.out.println(demoDTO);
        return new ResponseEntity("Object created",HttpStatus.CREATED);
    }

    /**
     * Update body
     * @param demoDTO
     * @return
     */
    @PutMapping
    public ResponseEntity updateDemo(@RequestBody DemoDTO demoDTO){
        System.out.println(demoDTO);
        return new ResponseEntity("Object modified",HttpStatus.ACCEPTED);
    }
    /**
     * Delete call
     */
    @DeleteMapping("/{demo_id}")
    public ResponseEntity deleteDemo(@PathVariable("demo_id") int demoId){
        return new ResponseEntity("Demo deleted with id:"+ demoId, HttpStatus.OK);
    }
}
