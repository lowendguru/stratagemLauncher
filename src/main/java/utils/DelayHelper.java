package utils;

import main.MainWindow;

import java.util.Random;

public class DelayHelper {

    public static void delayKeystroke() {
        Random rand = new Random();
        int random = rand.nextInt(MainWindow.MAX_DELAY_BETWEEN_KEYSTROKE - MainWindow.MIN_DELAY_BETWEEN_KEYSTROKE);

        try {
            Thread.sleep(MainWindow.MIN_DELAY_BETWEEN_KEYSTROKE + random);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delayKeypress() {
        Random rand = new Random();
        int random = rand.nextInt(MainWindow.MAX_DELAY_PRESS_KEY - MainWindow.MIN_DELAY_PRESS_KEY);

        try {
            Thread.sleep(MainWindow.MIN_DELAY_PRESS_KEY + random);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
