package com.airbnb.service;

import com.airbnb.model.Room;
import com.airbnb.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    private final RoomRepository roomRepository;


    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findByName(String name) {
        return roomRepository.findByName(name);
    }

    @Override
    public Room findCheapestRoom() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream().min(Comparator.comparingDouble(Room::getRate)).orElse(null);
    }

    @Override
    public Room findMostExpensiveRoom() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream().max(Comparator.comparingDouble(Room::getRate)).orElse(null);
    }

    @Override
    public Room findNewestRoom() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream().max(Comparator.comparingDouble(Room::getId)).orElse(null);
    }

    @Override
    public Room save(String name, double rate) {
        Room room = new Room();
        room.setName(name);
        room.setRate(rate);
        return roomRepository.save(room);
    }
}
