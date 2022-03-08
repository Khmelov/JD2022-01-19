package by.it.tarend.jd02_06;

public class Runner {
    public static void main(String[] args) {
        Logger.getInstance().info("Start logging");
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread("thread № " + i + " ") {
                @Override
                public void run() {
                    Logger logger = Logger.getInstance();
                    logger.error(this.getName() + "Wrong");
                    logger.info(this.getName() + "is OK");
                }

            };
            thread.start();
        }
    }
}
