package ru.gb.Service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class UserService {
    private InterfaceUser interfaceUser;

    public UserService(InterfaceUser interfaceUser) {
        this.interfaceUser = interfaceUser;
    }

    /**
     * Метод запрашивает у пользователя список целых чисел и возвращает его
     * @return Список Integer
     */
    public List<Integer> getList(){
        List<Integer> result=null;
        interfaceUser.writeMessage("Введите список через запятую");
        while (true) {
            try {
                String inputString = interfaceUser.getString();
                result = Arrays.stream(inputString.split(",")).map(Integer::parseInt).toList();
                if (result.size()>1){
                    return result;
                } else {
                    interfaceUser.writeMessage("Введите более 1 числа");
                }
            } catch (NumberFormatException e){
                interfaceUser.writeMessage("Неверный формат чисел");
            }
//            catch (NoSuchElementException e){
//                interfaceUser.writeMessage("Строка не может быть пустой");
//            }
        }
    }


}
