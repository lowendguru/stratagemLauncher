package listener;

import jnikeyboard.winkeyboard.Keyboard;
import jnikeyboard.winkeyboard.ScanCode;

import static utils.DelayHelper.delayKeypress;
import static utils.DelayHelper.delayKeystroke;

public class NativeKeySenderJNI {


    public static void pressNativeSequenceJNI(String sequence) {

        Keyboard myKeyboard = new Keyboard();

        for (int i = 0; i < sequence.length(); i++) {
            int ch = sequence.charAt(i);
            System.out.println("int char= " + ch);
            switch (ch) {
                case 119:
                    pressKey(myKeyboard, ScanCode.DIK_W);
                    System.out.println("Pressing W");
                    break;
                case 97:
                    pressKey(myKeyboard, ScanCode.DIK_A);
                    System.out.println("Pressing A");
                    break;
                case 115:
                    pressKey(myKeyboard, ScanCode.DIK_S);
                    System.out.println("Pressing S");
                    break;
                case 100:
                    pressKey(myKeyboard, ScanCode.DIK_D);
                    System.out.println("Pressing D");
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
