package com.melvs.melvsboot.services;

import com.melvs.melvsboot.model.GetListBuilder;

public class BusinessServiceNew {

    public void test(){
        GetListBuilder a = GetListBuilder.builder()
                .id("100")
                .name("Mark")
                .description("Spectacle")
                .build();

        GetListBuilder b = GetListBuilder.builder()
                .id("101")
                .name("Marky")
                .description("Spectator")
                .build();

        GetListBuilder c = GetListBuilder.builder()
                .id("102")
                .name("Marklyn")
                .description("Spector")
                .build();
            }
}
