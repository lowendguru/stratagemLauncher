package listener;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.*;
import main.MainWindow;

public class NativeKeySender {
    public static void pressNativeSequence(String sequence) {
        // Loop all windows
        User32.INSTANCE.EnumWindows((hWnd, data) -> {
            char[] name = new char[512];

            User32.INSTANCE.GetWindowText(hWnd, name, name.length);

            // Find window with title starting with downcase "keyb" string
            if (Native.toString(name).toLowerCase().startsWith("new")) {
                // Bring the window to the front
                User32.INSTANCE.SetForegroundWindow(hWnd);

                // Prepare input reference
                WinUser.INPUT input = new WinUser.INPUT();

                input.type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
                input.input.setType("ki"); // Because setting INPUT_INPUT_KEYBOARD is not enough: https://groups.google.com/d/msg/jna-users/NDBGwC1VZbU/cjYCQ1CjBwAJ
                input.input.ki.wScan = new WinDef.WORD(0);
                input.input.ki.time = new WinDef.DWORD(0);
                input.input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);

                try {
                    // Press CTRL key
                    if (!MainWindow.TESTING) {
                        // VK_CONTROL(0x11),
                        // Press "CTRL"
                        input.input.ki.wVk = new WinDef.WORD(Win32VK.VK_CONTROL.code);
                        input.input.ki.dwFlags = new WinDef.DWORD(0);  // keydown
                        User32.INSTANCE.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());
                        Thread.sleep(MainWindow.KEY_DELAY);
                    }

                    for (int i = 0; i < sequence.length(); i++) {
                        int ch = sequence.charAt(i);
                        System.out.println("int char= " + ch);
                        switch (ch) {
                            case 119:
                                pressKey(input, 'W');
                                break;
                            case 97:
                                pressKey(input, Win32VK.VK_A.code);
                                break;
                            case 115:
                                pressKey(input, 'S');
                                break;
                            case 100:
                                pressKey(input, 'D');
                                break;
                        }
                        Thread.sleep(MainWindow.KEY_DELAY);
                    }
                    if (!MainWindow.TESTING) {
                        // Release CTRL
                        input.input.ki.wVk = new WinDef.WORD(Win32VK.VK_CONTROL.code);
                        input.input.ki.dwFlags = new WinDef.DWORD(2);  // keyup
                        User32.INSTANCE.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return false; // Found
            }

            return true; // Keep searching
        }, null);
    }

    private static void pressKey(WinUser.INPUT input, long key) throws InterruptedException {
        // Press "W"
        input.input.ki.wVk = new WinDef.WORD(key); // 0x41
        input.input.ki.dwFlags = new WinDef.DWORD(0);  // keydown
        User32.INSTANCE.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());

        Thread.sleep(MainWindow.KEY_DELAY);

        // Release "W"
        input.input.ki.wVk = new WinDef.WORD(key); // 0x41
        input.input.ki.dwFlags = new WinDef.DWORD(2);  // keyup
        User32.INSTANCE.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());
        return;
    }
}
