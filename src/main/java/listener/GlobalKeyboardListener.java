package listener;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Map.Entry;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import model.Stratagem;

public class GlobalKeyboardListener {

	private static int timeDelay = 50;
	private static boolean testing;

	public ArrayList<Stratagem> stratagemMap;

	public GlobalKeyboardListener(final ArrayList<Stratagem> stratagemMap, boolean testing) {
		GlobalKeyboardListener.testing = testing;
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
					pressSequence(stratagemMap.get(0).getSequence());
					break;
				case 48:
					// alphabetic 0
					pressSequence(stratagemMap.get(0).getSequence());
					break;
				case 97:
					// numpad 1
					pressSequence(stratagemMap.get(1).getSequence());
					break;
				case 98:
					// numpad 2
					pressSequence(stratagemMap.get(2).getSequence());
					break;
				case 99:
					// numpad 3
					pressSequence(stratagemMap.get(3).getSequence());
					break;
				case 100:
					// numpad 4
					pressSequence(stratagemMap.get(4).getSequence());
					break;
				case 52:
					// alphabetic 4
					pressSequence(stratagemMap.get(4).getSequence());
					break;
				case 101:
					// numpad 5
					pressSequence(stratagemMap.get(5).getSequence());
					break;
				case 53:
					// alphabetic 5
					pressSequence(stratagemMap.get(5).getSequence());
					break;
				case 102:
					// numpad 6
					pressSequence(stratagemMap.get(6).getSequence());
					break;
				case 54:
					// alphabetic 6
					pressSequence(stratagemMap.get(6).getSequence());
					break;
				case 103:
					// numpad 7
					pressSequence(stratagemMap.get(7).getSequence());
					break;
				case 55:
					// alphabetic 7
					pressSequence(stratagemMap.get(7).getSequence());
					break;
				case 104:
					// numpad 8
					pressSequence(stratagemMap.get(8).getSequence());
					break;
				case 56:
					// alphabetic 8
					pressSequence(stratagemMap.get(8).getSequence());
					break;
				case 105:
					// numpad 9
					pressSequence(stratagemMap.get(9).getSequence());
					break;
				case 57:
					// alphabetic 9
					pressSequence(stratagemMap.get(9).getSequence());
					break;
				case 110:
					// numpad . (dot)
					pressSequence(stratagemMap.get(10).getSequence());
					break;
				case 190:
					// alphabetic . (dot)
					pressSequence(stratagemMap.get(10).getSequence());
					break;
				}

			}

			@Override
			public void keyReleased(GlobalKeyEvent event) {
				System.out.println(event);
			}
		});

	}

	protected static void pressSequence(String s) {
		System.out.println("Press sequence: " + s);

		try {

			Robot r = new Robot();

			// Press CTRL key
			if (!testing)
				r.keyPress(KeyEvent.VK_CONTROL); 
			Thread.sleep(timeDelay);

			for (int i = 0; i < s.length(); i++) {

				int ch = s.charAt(i);
				System.out.println("int char= " + ch);

				switch (ch) {
				case 119:
					// w
					r.keyPress(KeyEvent.VK_W); // w
					Thread.sleep(timeDelay);
					r.keyRelease(KeyEvent.VK_W);
					break;
				case 97:
					// w
					r.keyPress(KeyEvent.VK_A); // w
					Thread.sleep(timeDelay);
					r.keyRelease(KeyEvent.VK_A);
					break;
				case 115:
					// w
					r.keyPress(KeyEvent.VK_S); // w
					Thread.sleep(timeDelay);
					r.keyRelease(KeyEvent.VK_S);
					break;
				case 100:
					// w
					r.keyPress(KeyEvent.VK_D); // w
					Thread.sleep(timeDelay);
					r.keyRelease(KeyEvent.VK_D);
					break;
				}
				Thread.sleep(timeDelay);

			}

			if (!testing)
				r.keyRelease(KeyEvent.VK_CONTROL);
			r = null;
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}