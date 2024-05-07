package listener;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.*;
import main.MainWindow;

import static utils.DelayHelper.delayKeypress;
import static utils.DelayHelper.delayKeystroke;

public class NativeKeySender {
    public static void pressNativeSequence(String sequence) {
        // Loop all windows
        User32.INSTANCE.EnumWindows((hWnd, data) -> {
            char[] name = new char[512];

            User32.INSTANCE.GetWindowText(hWnd, name, name.length);

            // Find window with title starting with downcase "keyb" string
            if (Native.toString(name).toLowerCase().startsWith("helldivers")) {
                // Bring the window to the front
                User32.INSTANCE.SetForegroundWindow(hWnd);

                // Prepare input reference
                WinUser.INPUT input = new WinUser.INPUT();

                input.type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
                input.input.setType("ki"); // Because setting INPUT_INPUT_KEYBOARD is not enough: https://groups.google.com/d/msg/jna-users/NDBGwC1VZbU/cjYCQ1CjBwAJ
                input.input.ki.wScan = new WinDef.WORD(0);
                input.input.ki.time = new WinDef.DWORD(0);
                input.input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);

                // Press CTRL key
                if (!MainWindow.TESTING) {
                    input.input.ki.wVk = new WinDef.WORD(Win32VK.VK_CONTROL.code);
                    input.input.ki.dwFlags = new WinDef.DWORD(0);  // keydown
                    User32.INSTANCE.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());
                    delayKeystroke();
                }

                for (int i = 0; i < sequence.length(); i++) {
                    int ch = sequence.charAt(i);
                    System.out.println("int char= " + ch);
                    switch (ch) {
                        case 119:
                            pressKey(input, Win32VK.VK_W.code);
                            System.out.println("Pressing W");
                            break;
                        case 97:
                            pressKey(input, Win32VK.VK_A.code);
                            System.out.println("Pressing A");
                            break;
                        case 115:
                            pressKey(input, Win32VK.VK_S.code);
                            System.out.println("Pressing S");
                            break;
                        case 100:
                            pressKey(input, Win32VK.VK_D.code);
                            System.out.println("Pressing D");
                            break;
                    }
                    delayKeystroke();
                }
                if (!MainWindow.TESTING) {
                    // Release CTRL
                    input.input.ki.wVk = new WinDef.WORD(Win32VK.VK_CONTROL.code);
                    input.input.ki.dwFlags = new WinDef.DWORD(2);  // keyup
                    User32.INSTANCE.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());
                }

                return false; // Found
            }

            return true; // Keep searching
        }, null);
    }

    private static void pressKey(WinUser.INPUT input, long key) {
        // Press "W"
        input.input.ki.wVk = new WinDef.WORD(key); // 0x41
        input.input.ki.dwFlags = new WinDef.DWORD(0);  // keydown
        User32.INSTANCE.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());

        delayKeypress();

        // Release "W"
        input.input.ki.wVk = new WinDef.WORD(key); // 0x41
        input.input.ki.dwFlags = new WinDef.DWORD(2);  // keyup
        User32.INSTANCE.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());
        return;
    }
}
