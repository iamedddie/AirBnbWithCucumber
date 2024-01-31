package com.airbnb.controller;

import com.airbnb.model.Room;
import com.airbnb.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    RoomService roomService;


    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return  roomService.findAll();
    }

    @GetMapping("/room")
    public Room findByName (@RequestParam String name){
        return  roomService.findByName(name);
    }

    @GetMapping("/cheapestRoom")
    public Room findCheapestRoom() {
        return roomService.findCheapestRoom();
    }

    @GetMapping("/mostExpensiveRoom")
    public Room findMostExpensiveRoom() {
        return roomService.findMostExpensiveRoom();
    }  @GetMapping("/newestRoom")
    public Room findNewestRoom() {
        return roomService.findNewestRoom();
    }

    @PostMapping("/createRoom/{name}/{rate}")
    public Room createRoom(@PathVariable String name,@PathVariable double rate ){
        return roomService.save(name,rate);

    }
}


//Things to do next:
//Rewrite the two new features to remove any hardcoded values
//Write all of the connecting glue for another endpoint, controller, service, repository, populator
//Write a feature that has a post AND a get in two separate steps that can test that something is being created correctly and then retrieved.
//Bonus: try one of the other more complex mapping scenarios One-to-many and write a feature test for it!
//Bonus: Have fun and try whatever else you want