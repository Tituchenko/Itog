package ru.gb.Service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
    private ConsoleService interfaceUser;
    private UserService userService;
    private Map<String,List<Integer>> testList;

    @BeforeEach
    void setUp() {
        interfaceUser=mock(ConsoleService.class);
        userService=new UserService(interfaceUser);

        testList=new HashMap<>();
        testList.put("1,2,3", Stream.of(1,2,3).toList());
        testList.put("0,0,0,0", Stream.of(0,0,0,0).toList());
        testList.put("-567,890", Stream.of(-567,890).toList());
    }


    @Test
    void getListTest() {
        for (Map.Entry<String,List<Integer>> entry:testList.entrySet()) {
            when(interfaceUser.getString()).thenReturn(entry.getKey());

            List<Integer> result=userService.getList();

            assertEquals(entry.getValue(),result);
        }
    }


}