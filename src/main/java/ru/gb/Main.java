package ru.gb;

import ru.gb.Service.ConsoleService;
import ru.gb.Service.InterfaceUser;
import ru.gb.Service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConsoleService consoleService=new ConsoleService();
        UserService userService=new UserService(consoleService);

        List<Integer> list1=userService.getList();
        List<Integer> list2=userService.getList();
        consoleService.writeMessage(Calc.checkLists(list1,list2));

    }
}