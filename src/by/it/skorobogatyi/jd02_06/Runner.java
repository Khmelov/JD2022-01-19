package by.it.skorobogatyi.jd02_06;

public class Runner {

    public static void main(String[] args) {

        Logger logger = Logger.getInstance();
        logger.info("Starting");
        logger.error("owo");
        logger.info("owowo");
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread("thread #" + i) {
                @Override
                public void run() {
                    Logger logger = Logger.getInstance();
                    logger.error(this.getName() + " ow");
                    logger.info(this.getName() + " owowo");
                }

            };
            thread.start();
        }
    }
}
