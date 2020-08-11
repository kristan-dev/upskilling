package com.practice.MelvsBoot.BootShop.repository;

import com.practice.MelvsBoot.BootShop.model.Accessories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MyAccessoriesService {

    Map<String, Accessories> myaccessories = new HashMap<>();

    private void myAS(){
        Accessories ac1 = Accessories.builder()
                .ID("001")
                .Name("Helmet")
                .Description("Specialized hard shell helmet")
                .Quality("Fair")
                .build();

        Accessories ac2 = Accessories.builder()
                .ID("002")
                .Name("Front Light")
                .Description("1800 Lumens")
                .Quality("Good")
                .build();

        myaccessories.put("ac1", ac1);
        myaccessories.put("ac2", ac2);
    }

    public Collection<Accessories> getAcc(){
    myAS();
    return this.myaccessories.values();
    }
}
