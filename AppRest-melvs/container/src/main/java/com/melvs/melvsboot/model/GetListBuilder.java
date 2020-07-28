package com.melvs.melvsboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetListBuilder {

    private int id;
    private String name;
    private String description;

}
