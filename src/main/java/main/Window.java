package main;


import java.awt.EventQueue;

import javax.swing.JFrame;

public class Window {

	private JFrame frmKeylistener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmKeylistener.setVisible(true);
					
					GlobalKeyboard keyboard = new GlobalKeyboard();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKeylistener = new JFrame();
		frmKeylistener.setTitle("KeyListener");
		frmKeylistener.setBounds(100, 100, 450, 300);
		frmKeylistener.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKeylistener.getContentPane().setLayout(null);
		
		
	}

}
