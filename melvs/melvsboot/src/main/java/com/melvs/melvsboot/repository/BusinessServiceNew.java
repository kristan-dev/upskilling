package com.melvs.melvsboot.repository;

import com.melvs.melvsboot.model.GetListBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BusinessServiceNew {

    Map<String, GetListBuilder> gl = new HashMap<>();

    private void test() {
        GetListBuilder a = GetListBuilder.builder()
                .id(1)
                .name("Melvin")
                .description("This is test")
                .build();

        GetListBuilder b = GetListBuilder.builder()
                .id(2)
                .name("John")
                .description("This is test again")
                .build();

        GetListBuilder c = GetListBuilder.builder()
                .id(3)
                .name("Bana-ag")
                .description("This is another test")
                .build();

        gl.put("a", a);
        gl.put("b", b);
        gl.put("c", c);
    }

    public String getlb() {
        return this.gl.values().toString();
    }
}