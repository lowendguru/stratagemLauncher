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

	private static int timeDelay = 20;
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
					pressSequence(sequenceFromStratagemMap(0));
					break;
				case 48:
					// alphabetic 0
					pressSequence(sequenceFromStratagemMap(0));
					break;
				case 97:
					// numpad 1
					pressSequence(sequenceFromStratagemMap(1));
					break;
				case 98:
					// numpad 2
					pressSequence(sequenceFromStratagemMap(2));
					break;
				case 99:
					// numpad 3
					pressSequence(sequenceFromStratagemMap(3));
					break;
				case 100:
					// numpad 4
					pressSequence(sequenceFromStratagemMap(4));
					break;
				case 52:
					// alphabetic 4
					pressSequence(sequenceFromStratagemMap(4));
					break;
				case 101:
					// numpad 5
					pressSequence(sequenceFromStratagemMap(5));
					break;
				case 53:
					// alphabetic 5
					pressSequence(sequenceFromStratagemMap(5));
					break;
				case 102:
					// numpad 6
					pressSequence(sequenceFromStratagemMap(6));
					break;
				case 54:
					// alphabetic 6
					pressSequence(sequenceFromStratagemMap(6));
					break;
				case 103:
					// numpad 7
					pressSequence(sequenceFromStratagemMap(7));
					break;
				case 55:
					// alphabetic 7
					pressSequence(sequenceFromStratagemMap(7));
					break;
				case 104:
					// numpad 8
					pressSequence(sequenceFromStratagemMap(8));
					break;
				case 56:
					// alphabetic 8
					pressSequence(sequenceFromStratagemMap(8));
					break;
				case 105:
					// numpad 9
					pressSequence(sequenceFromStratagemMap(9));
					break;
				case 57:
					// alphabetic 9
					pressSequence(sequenceFromStratagemMap(9));
					break;
				case 110:
					// numpad . (dot)
					pressSequence(sequenceFromStratagemMap(10));
					break;
				case 190:
					// alphabetic . (dot)
					pressSequence(sequenceFromStratagemMap(10));
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