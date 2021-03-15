package com.example.adminpage.controller;

import com.example.adminpage.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest(){
        return "Hi get method";
    }

    @RequestMapping(method=RequestMethod.GET, path="/number")
    public Integer getNumber(){
        return 100+100;
    }

    @GetMapping("/getParameter")
    public String getParam(@RequestParam String id, @RequestParam(name = "password") String pwd){
        System.out.println("id : " + id);
        System.out.println("pwd : " + pwd);

        return id + " " + pwd ;
    }

    @GetMapping("/getMultiParam")
    public SearchParam multiParam(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        return searchParam;
    }

    @PostMapping("/postmethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return searchParam;
    }
}
