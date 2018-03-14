package main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Map.Entry;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class GlobalKeyboardListener {

	private static int timeDelay = 50;
	private static boolean testing = true;

	public GlobalKeyboardListener() {
		// might throw a UnsatisfiedLinkError if the native library fails to load or a
		// RuntimeException if hooking fails
		GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true); // use false here to switch to hook instead of
																		// raw input

		System.out.println(
				"Global keyboard hook successfully started. Connected keyboards:");
		for (Entry<Long, String> keyboard : GlobalKeyboardHook.listKeyboards().entrySet())
			System.out.format("%d: %s\n", keyboard.getKey(), keyboard.getValue());

		keyboardHook.addKeyListener(new GlobalKeyAdapter() {
			@Override
			public void keyPressed(GlobalKeyEvent event) {
				System.out.println(event);

				System.out.println("event:" + event.getVirtualKeyCode());

				int eventValue = event.getVirtualKeyCode();
				String sequence = "";

				switch (eventValue) {
				case 96:
					// 0
					sequence = "";
					break;
				case 97:
					// 1 mines
					sequence = "adsw";
					break;
				case 98:
					// 2 turret
					sequence = "aswda";
					break;
				case 99:
					// 3
					sequence = "";
					break;
				case 100:
					// 4 sniffer
					sequence = "ssdw";
					break;
				case 101:
					// 5 reinforce
					sequence = "wsdaw";
					break;
				case 102:
					// 6 hellbomb
					sequence = "wadsws";
					break;
				case 103:
					// 7 railcannon
					sequence = "dswsa";
					break;
				case 104:
					// 8 eat
					sequence = "sadws";
					break;
				case 105:
					// 9 mech
					sequence = "sdwass";
					break;
				case 110:
					// . (dot)
					sequence = "sdwass";
					break;
				}
				if (!sequence.equals(""))
					try {
						pressSequence(sequence);
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}

			@Override
			public void keyReleased(GlobalKeyEvent event) {
				System.out.println(event);
			}
		});

	}

	protected static void pressSequence(String s) throws AWTException, InterruptedException {
		System.out.println("Press sequence: " + s);

		Robot r = new Robot();

		if (!testing)
			r.keyPress(KeyEvent.VK_CONTROL); // ctrl
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
			r.keyRelease(KeyEvent.VK_CONTROL);// ctrl
		r = null;

	}
}