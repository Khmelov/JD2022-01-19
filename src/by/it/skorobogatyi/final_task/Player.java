package by.it.skorobogatyi.final_task;

/*Создать класс потока(PlayerGeneratorTask), который генерирует
коллекцию из 10 объектов класса Player с полями name(String),
age(Integer), isActive(boolean) по условию: name – любое, age – от 20 до
40, isActive – true/false и записывает ее в файл. Поток возвращает имя
файла, в который он писал.

Создать класс потока(PlayerReaderTask), который читает файл и
возвращает коллекцию активных Player в возрастном диапазоне от 25
до 30 (условие отбора).

Создать пул потоков из 4 штук
Запустить 20 потоков класса PlayerGeneratorTask.
Запустить поток класса PlayerReaderTask на каждый выполненный
PlayerGeneratorTask.

Отсортировать по возрасту и вывести на экран имена перых 5 игроков в
UpperCase, удовлетворяющие условию с помощью Stream API.*/

import java.io.Serializable;

public class Player implements Serializable {

    public final String name;
    public final Integer age;
    public final boolean isActive;


    public Player(String name, Integer age, boolean isActive){
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Age: " + age + " Is active: " + isActive + "\n";
    }
}
