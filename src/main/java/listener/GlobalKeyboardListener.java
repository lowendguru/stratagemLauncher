package listener;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import main.MainWindow;
import model.Stratagem;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Map.Entry;

import static listener.NativeKeySender.pressNativeSequence;
import static listener.NativeKeySenderJNI.pressNativeSequenceJNI;

public class GlobalKeyboardListener {

    public ArrayList<Stratagem> stratagemMap;

    public GlobalKeyboardListener(final ArrayList<Stratagem> stratagemMap) {

        this.stratagemMap = stratagemMap;

        // might throw a UnsatisfiedLinkError if the native library fails to load or a
        // RuntimeException if hooking fails
        // use false here to switch to hook instead of raw input
        GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);

        System.out.println("Global keyboard hook successfully started. Connected keyboards:");
        for (Entry<Long, String> keyboard : GlobalKeyboardHook.listKeyboards().entrySet())
            System.out.format("%d: %s\n", keyboard.getKey(), keyboard.getValue());

        keyboardHook.addKeyListener(new GlobalKeyAdapter() {
            @Override
            public void keyPressed(GlobalKeyEvent event) {
                System.out.println(event);

                System.out.println("event:" + event.getVirtualKeyCode());

                int eventValue = event.getVirtualKeyCode();

                switch (eventValue) {
                    case 96:
                    case 48:
                        // alphabetic 0
                        // numpad 0
                        pressNativeSequenceJNI(sequenceFromStratagemMap(0));
                        break;
                    case 97:
                        // numpad 1
                        pressNativeSequenceJNI(sequenceFromStratagemMap(1));
                        break;
                    case 98:
                        // numpad 2
                        pressNativeSequenceJNI(sequenceFromStratagemMap(2));
                        break;
                    case 99:
                        // numpad 3
                        pressNativeSequenceJNI(sequenceFromStratagemMap(3));
                        break;
                    case 100:
                    case 52:
                        // alphabetic 4
                        // numpad 4
                        pressNativeSequenceJNI(sequenceFromStratagemMap(4));
                        break;
                    case 101:
                    case 53:
                        // alphabetic 5
                        // numpad 5
                        pressNativeSequenceJNI(sequenceFromStratagemMap(5));
                        break;
                    case 102:
                    case 54:
                        // alphabetic 6
                        // numpad 6
                        pressNativeSequenceJNI(sequenceFromStratagemMap(6));
                        break;
                    case 103:
                    case 55:
                        // alphabetic 7
                        // numpad 7
                        pressNativeSequenceJNI(sequenceFromStratagemMap(7));
                        break;
                    case 104:
                    case 56:
                        // alphabetic 8
                        // numpad 8
                        pressNativeSequenceJNI(sequenceFromStratagemMap(8));
                        break;
                    case 105:
                    case 57:
                        // alphabetic 9
                        // numpad 9
                        pressNativeSequenceJNI(sequenceFromStratagemMap(9));
                        break;
                    case 110:
                    case 190:
                        // alphabetic . (dot)
                        // numpad . (dot)
                        pressNativeSequenceJNI(sequenceFromStratagemMap(10));
                        break;
                    case 109:
                        // numpad minus - (reinforce while mind controlled)
                        pressNativeSequenceJNI("swads");
                        break;
                }

            }

            @Override
            public void keyReleased(GlobalKeyEvent event) {
                System.out.println(event);
            }
        });

    }

    private String sequenceFromStratagemMap(int stratagemMapIndex) {
        String sequence = "";

        if (stratagemMap.get(stratagemMapIndex) != null)
            return stratagemMap.get(stratagemMapIndex).getSequence();

        return sequence;
    }

    protected static void pressSequence(String s) {
        System.out.println("Press sequence: " + s);

        if (s != null && !s.equals(""))
            try {

                Robot r = new Robot();

                // Press CTRL key
                if (!MainWindow.TESTING)
                    r.keyPress(KeyEvent.VK_CONTROL);
                Thread.sleep(MainWindow.KEY_DELAY);

                for (int i = 0; i < s.length(); i++) {

                    int ch = s.charAt(i);
                    System.out.println("int char= " + ch);

                    switch (ch) {
                        case 119:
                            r.keyPress(KeyEvent.VK_W);
                            Thread.sleep(MainWindow.KEY_DELAY);
                            r.keyRelease(KeyEvent.VK_W);
                            break;
                        case 97:
                            r.keyPress(KeyEvent.VK_A);
                            Thread.sleep(MainWindow.KEY_DELAY);
                            r.keyRelease(KeyEvent.VK_A);
                            break;
                        case 115:
                            r.keyPress(KeyEvent.VK_S);
                            Thread.sleep(MainWindow.KEY_DELAY);
                            r.keyRelease(KeyEvent.VK_S);
                            break;
                        case 100:
                            r.keyPress(KeyEvent.VK_D);
                            Thread.sleep(MainWindow.KEY_DELAY);
                            r.keyRelease(KeyEvent.VK_D);
                            break;
                    }
                    Thread.sleep(MainWindow.KEY_DELAY);

                }

                if (!MainWindow.TESTING)
                    r.keyRelease(KeyEvent.VK_CONTROL);
                r = null;
            } catch (AWTException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}