package by.it.kustova.jd02_06;

public class Runner {
    public static void main(String[] args) {
        Logger.getInstance().info("GO");
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread("Thread № " + i) {
                @Override
                public void run() {
                    Logger logger = Logger.getInstance();
                    logger.error(this.getName() + " error");
                    logger.info(this.getName() + " info");
                }
            };
            thread.start();

        }
    }
}
