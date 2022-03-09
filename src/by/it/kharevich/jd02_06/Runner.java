package by.it.kharevich.jd02_06;

public class Runner {

    public static void main(String[] args) {
        Logger.getInstance().info("-----Start-----");
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread("number " + i) {
                @Override
                public void run() {
                    Logger logger = Logger.getInstance();
                    logger.error(this.getName() + " NO");
                    logger.info(this.getName() + " OK");
                }
            };
            thread.start();
        }
    }
}
