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
                        // numpad 0
                        pressNativeSequence(sequenceFromStratagemMap(0));
                        break;
                    case 48:
                        // alphabetic 0
                        pressNativeSequence(sequenceFromStratagemMap(0));
                        break;
                    case 97:
                        // numpad 1
                        pressNativeSequence(sequenceFromStratagemMap(1));
                        break;
                    case 98:
                        // numpad 2
                        pressNativeSequence(sequenceFromStratagemMap(2));
                        break;
                    case 99:
                        // numpad 3
                        pressNativeSequence(sequenceFromStratagemMap(3));
                        break;
                    case 100:
                        // numpad 4
                        pressNativeSequence(sequenceFromStratagemMap(4));
                        break;
                    case 52:
                        // alphabetic 4
                        pressNativeSequence(sequenceFromStratagemMap(4));
                        break;
                    case 101:
                        // numpad 5
                        pressNativeSequence(sequenceFromStratagemMap(5));
                        break;
                    case 53:
                        // alphabetic 5
                        pressNativeSequence(sequenceFromStratagemMap(5));
                        break;
                    case 102:
                        // numpad 6
                        pressNativeSequence(sequenceFromStratagemMap(6));
                        break;
                    case 54:
                        // alphabetic 6
                        pressNativeSequence(sequenceFromStratagemMap(6));
                        break;
                    case 103:
                        // numpad 7
                        pressNativeSequence(sequenceFromStratagemMap(7));
                        break;
                    case 55:
                        // alphabetic 7
                        pressNativeSequence(sequenceFromStratagemMap(7));
                        break;
                    case 104:
                        // numpad 8
                        pressNativeSequence(sequenceFromStratagemMap(8));
                        break;
                    case 56:
                        // alphabetic 8
                        pressNativeSequence(sequenceFromStratagemMap(8));
                        break;
                    case 105:
                    case 57:
                        // alphabetic 9
                        // numpad 9
                        pressNativeSequence(sequenceFromStratagemMap(9));
                        break;
                    case 110:
                        // numpad . (dot)
                        pressNativeSequence(sequenceFromStratagemMap(10));
                        break;
                    case 190:
                        // alphabetic . (dot)
                        pressNativeSequence(sequenceFromStratagemMap(10));
                        break;
                    case 109:
                        // numpad minus - (reinforce while mind controlled)
                        pressNativeSequence("swads");
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