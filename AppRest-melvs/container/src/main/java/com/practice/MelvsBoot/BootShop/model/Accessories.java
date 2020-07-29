package com.practice.MelvsBoot.BootShop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Accessories {

        private String ID;
        private String Name;
        private String Description;
        private String Quality;

}
