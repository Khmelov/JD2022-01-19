package by.it.burov.jd02_06;

public class Runner {
    public static void main(String[] args) {
        Logger.getInstance().info("Start");
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread("Thread " + i) {
                @Override
                public void run() {
                    Logger logger = Logger.getInstance();
                    logger.error(this.getName() + " Something went wrong");
                    logger.info(this.getName() + " Good job");
                }
            };
            thread.start();
        }
    }
}

