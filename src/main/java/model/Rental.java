package model;

import lombok.Data;

@Data
public class Rental {

    private Room room;
    private SeasonType seasonType;
    private int days;
    private User user;

}
