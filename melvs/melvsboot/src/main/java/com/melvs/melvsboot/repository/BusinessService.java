package com.melvs.melvsboot.repository;

import com.melvs.melvsboot.model.GetList;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

//service once spring boot started will load to memory
@Service
public class BusinessService {

    private List<GetList> list = Arrays.asList(
            new GetList("1","Melvin","This is test"),
            new GetList("2","John","This is test again"),
            new GetList("3","Bana-ag","This is another test")
            );

    public List<GetList> getAllList () {
        return list;
    }
}
