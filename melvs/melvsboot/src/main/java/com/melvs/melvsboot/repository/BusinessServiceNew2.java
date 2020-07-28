package com.melvs.melvsboot.repository;

import com.melvs.melvsboot.model.GetListBuilder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BusinessServiceNew2 {

    private List<GetListBuilder> list2 = Arrays.asList(
            new GetListBuilder(1,"John","I am the"),
            new GetListBuilder(2,"Dave","world"),
            new GetListBuilder(3,"Batista","champion"));

    public List<GetListBuilder> getAllList2 () {
        return list2;
    }

}