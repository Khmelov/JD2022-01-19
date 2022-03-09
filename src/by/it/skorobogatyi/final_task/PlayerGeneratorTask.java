package by.it.skorobogatyi.final_task;

/*

Отсортировать по возрасту и вывести на экран имена перых 5 игроков в
UpperCase, удовлетворяющие условию с помощью Stream API.*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.*;

public class PlayerGeneratorTask implements Runnable {

    public volatile String fileName;

    public static void main(String[] args) {

        ExecutorService threadsPool = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 20; i++) {

            Callable<String> playerGeneratorTask = () -> {
                PlayerGeneratorTask playerGeneratorTask1 = new PlayerGeneratorTask();
                playerGeneratorTask1.run();
                return playerGeneratorTask1.fileName;
            };

            FutureTask<String> task = new FutureTask<>(playerGeneratorTask);
            task.run();
            try {
                if (! Objects.isNull(task.get())) {
                    PlayerReaderTask playerReaderTask = new PlayerReaderTask();
                    playerReaderTask.start();
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {

        List<Player> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            fillListWithPlayers(list, random);
        }

        String fileName = writePlayersInFile(list);
        this.fileName = fileName;

    }

    private void fillListWithPlayers(List<Player> list, Random random) {

        Integer age = random.nextInt(20, 41);

        int index = random.nextInt(0, 5);
        String name = String.valueOf(Names.values()[index]);

        boolean isActive = random.nextBoolean();

        Player player = new Player(name, age, isActive);
        list.add(player);
    }

    private String writePlayersInFile(List<Player> list) {
        String filename = FilenameGetter.getFilename(PlayerGeneratorTask.class, "src", "file.txt");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filename))
        ) {
            for (Player player : list) {
                objectOutputStream.writeObject(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filename;
    }
}
