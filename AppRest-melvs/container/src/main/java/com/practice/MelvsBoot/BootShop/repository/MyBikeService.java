package com.practice.MelvsBoot.BootShop.repository;

import com.practice.MelvsBoot.BootShop.model.MyBike;
import java.util.Arrays;
import java.util.List;

public class MyBikeService {

    private List<MyBike> bikeList = Arrays.asList(
            new MyBike(1,"Bianchi","27er","27","3x9"),
            new MyBike(2,"Giant","29er","29","1x9"),
            new MyBike(3,"Specialized","29er","29","1x11"),
            new MyBike(4,"Ghost","26er","26","3x9"),
            new MyBike(5,"Haro","29er","29","1x9")
    );

    public List<MyBike> getBikeList() {
        return bikeList;
    }

}
