package com.practice.MelvsBoot.BootShop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyBike {
    private int ID;
    private String Brand;
    private String FrameSize;
    private String Wheel;
    private String Speed;

}
