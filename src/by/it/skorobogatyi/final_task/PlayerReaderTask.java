package by.it.skorobogatyi.final_task;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class PlayerReaderTask extends Thread {

    /*

    Создать пул потоков из 4 штук
    Запустить 20 потоков класса PlayerGeneratorTask.
    Запустить поток класса PlayerReaderTask на каждый выполненный
    PlayerGeneratorTask.

    Отсортировать по возрасту и вывести на экран имена перых 5 игроков в
    UpperCase, удовлетворяющие условию с помощью Stream API.*/


    @Override
    public void run() {

        List<Player> rawCollection = new ArrayList<>();
        List<Player> finalCollection = new ArrayList<>();

        String filename = FilenameGetter.getFilename(PlayerReaderTask.class, "src", "file.txt");

        readFromFileRawCollection(rawCollection, filename);

        for (Player player : rawCollection) {
            if (player.isActive && player.age >= 25 && player.age <= 30) {
                finalCollection.add(player);
            }
        }

        Stream<String> limit = finalCollection.stream().map((s) -> s.name.toLowerCase(Locale.ROOT)).limit(5);

    }

    private void readFromFileRawCollection(List<Player> rawCollection, String filename) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(filename))
        ) {
            while (objectInputStream.available() > 0 ) {
                Object o = objectInputStream.readObject();
                rawCollection.add((Player)o);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
