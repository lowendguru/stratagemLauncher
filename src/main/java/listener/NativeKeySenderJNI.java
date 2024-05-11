package listener;

import jnikeyboard.winkeyboard.Keyboard;
import jnikeyboard.winkeyboard.ScanCode;
import main.MainWindow;

import static utils.DelayHelper.delayKeypress;
import static utils.DelayHelper.delayKeystroke;

public class NativeKeySenderJNI implements Runnable{

    String sequence = "";

    public NativeKeySenderJNI(String sequence){
        this.sequence = sequence;
    }

    public void run() {

        Keyboard myKeyboard = new Keyboard();

        for (int i = 0; i < sequence.length(); i++) {
            int ch = sequence.charAt(i);
            System.out.println("int char= " + ch);
            switch (ch) {
                case 119:
                    System.out.println("Pressing W");
                    pressKey(myKeyboard, ScanCode.DIK_W);

                    break;
                case 97:
                    System.out.println("Pressing A");
                    pressKey(myKeyboard, ScanCode.DIK_A);

                    break;
                case 115:
                    System.out.println("Pressing S");
                    pressKey(myKeyboard, ScanCode.DIK_S);

                    break;
                case 100:
                    System.out.println("Pressing D");
                    pressKey(myKeyboard, ScanCode.DIK_D);

                    break;
            }
            delayKeystroke();
        }

    }

    private static void pressKey(Keyboard keyboard, int keyScanCode) {

        keyboard.winKeyPress(keyScanCode);
        delayKeypress();
        keyboard.winKeyRelease(keyScanCode);
    }


}
