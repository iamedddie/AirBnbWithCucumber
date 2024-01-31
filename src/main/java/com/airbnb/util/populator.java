package com.airbnb.util;

import com.airbnb.model.Room;
import com.airbnb.repository.RoomRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class populator {
    private final RoomRepository roomRepository;

    public populator(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @PostConstruct
    public void init(){
        Room room1 =new Room();
        room1.setName("Cliffhanger");
        room1.setRate(100);
        roomRepository.save(room1);

        Room room2 = new Room();
        room2.setName("Slickrock");
        room2.setRate(125);
        roomRepository.save(room2);

        Room room3 = new Room();
        room3.setName("Penthouse");
        room3.setRate(200);
        roomRepository.save(room3);

        Room room4 = new Room();
        room4.setName("Deluxe");
        room4.setRate(300);
        roomRepository.save(room4);

        Room room5 = new Room();
        room5.setName("Premium");
        room5.setRate(250);
        roomRepository.save(room5);
    }
}
