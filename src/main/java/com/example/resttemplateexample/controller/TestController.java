package com.example.resttemplateexample.controller;

import com.example.resttemplateexample.model.TestModel;
import com.example.resttemplateexample.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/create/user")
    public String user(){
        return "User is added";
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody TestModel testModel) {
        testService.createUser(testModel);
        return "User is created" + testModel;
    }

    @GetMapping("/user/{id}")
    public String getById(@PathVariable("id") int id) {
       /*
        TestModel testModel= testService.getStudentById(id);
         return testModel+"user id is:";
        TestModel(id=2, name=an, isPresent=false, age=43, rollNo=10)user id is:Pong */
        return "user id is: " + id;
    }

    @GetMapping("/user")
    public String getUserByParams(@RequestParam int id, @RequestParam String name, @RequestParam(required = false) boolean isPresent) {
        // testService.getStudentById(id);
        return "The user is: " + id+"---" +  name +"----"+ isPresent;
    }

    @GetMapping("/users/{isPresent}")
    public String getUserByRequestParamsAndPathVariables(@RequestParam(required = true) String name,@PathVariable("isPresent") boolean isPresent) {
        return "The Request Param and Path Variables are : " + name +"--" + isPresent;
    }
    @PostMapping ("/users/{id}")
    public String getUserByRequestParamsAndPathVariablesAndRequestBody(@RequestParam String name,@PathVariable("id") int id,@RequestBody TestModel testModel){
       testService.createUser(testModel);
        return "The RequestParams ,PathVariables And RequestBody"+""+id +"---"+""+ name +"----"+ ""+testModel;
    }
    @RequestMapping(value = "/child/{num}/{type}",method = RequestMethod.GET)
    // ---cannot give id as primitive datatype small int bcz it is consider as string and we are providing int
    public String getConnectedNodes(@RequestParam(value="id", required=false) Integer id, @RequestParam(value="name") String name, @PathVariable("num") String num, @PathVariable("type") String type) {
        return "----------"+num+"---"+type+"-------"+id+"-----------"+name;
    }

    //////////////-------------RequestHeader-------------------------

   @GetMapping("/users")
   public String checkRequestHeader(@RequestHeader int id, @RequestHeader String name) {
        return "RequestHeader is "+id+"---------"+name;
   }
   @GetMapping("/users1")
   public String test2(@RequestHeader Map<String,String> mapValues){
        return "Success"+mapValues;
   }

   //---------To Check Request Header
    @PostMapping("/check/{id}")
    public String checkAllTheParameters(@RequestHeader(name = "isPresent") String isPresent,@PathVariable(name = "id") int id ,@RequestParam(name="name") String name,@RequestBody TestModel testModel){
        return "IsPresent :"+isPresent+"----:Id is: "+id+"----:Name is: "+name+"---TestModel is: "+testModel;
    }
}