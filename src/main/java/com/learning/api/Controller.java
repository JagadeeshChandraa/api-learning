package com.learning.api;

import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller
{
    List<User> list=new ArrayList<>(List.of(new User(23,"sai","apple"),new User(34,"kopi","oppp")));




    @GetMapping("/users")
    public List<User> getUser()
    {
        return list;

    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user)
    {
        this.list.add(user);
    }

    @GetMapping("/users/{age}")
    public User getuserByAge(@PathVariable("age") int age)
    {
        List<User> collect = list.stream().filter((user) -> user.getAge() == age).collect(Collectors.toList());

        return collect.get(0);
    }
    @DeleteMapping("/users/{age}")
    public void dele(@PathVariable("age") int age)
    {
        List<User> collect = list.stream().filter((user) -> user.getAge() != age).collect(Collectors.toList());
        this.list=collect;

    }




}
