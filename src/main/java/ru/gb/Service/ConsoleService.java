package ru.gb.Service;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleService implements InterfaceUser{

    /**
     * Выводит сообщения в консоль
     * @param message сообщение
     */
    public void writeMessage(String message){
        System.out.println(message);
    }

    /**
     * Запрашивает у пользователя строку
     * @return строка из консоли
     */
    public String getString() throws NoSuchElementException{
        String result=null;
        while (result==null) {
            try (Scanner scanner = new Scanner(System.in)) {
                result = scanner.nextLine();
            }
        }
        return result;
    }
}
