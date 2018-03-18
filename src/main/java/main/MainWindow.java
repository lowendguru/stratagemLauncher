package main;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.Stratagem;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame mainFrame;
	private StratagemSelectionWindow stratagemSelectionWindow = new StratagemSelectionWindow();
	private static Stratagem[] stratagemMap = new Stratagem[11];

	public static void main(String[] args) {
		
	
            // Set cross-platform Java L&F (also called "Metal")
        try {
			UIManager.setLookAndFeel(
			    UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.mainFrame.setVisible(true);
					
					GlobalKeyboardListener keyboardListener = new GlobalKeyboardListener(stratagemMap);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setResizable(false);
		mainFrame.setTitle("Stratagem Launcher");
		mainFrame.setBounds(100, 100, 313, 444);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/Logo-Helldivers (Custom).png")));
		labelLogo.setBounds(0, 0, 173, 68);
		mainFrame.getContentPane().add(labelLogo);
		
		JButton button7 = new JButton("7");
		button7.setBounds(10, 67, 89, 74);
		mainFrame.getContentPane().add(button7);
		
		JButton button8 = new JButton("8");
		button8.setBounds(109, 67, 89, 74);
		mainFrame.getContentPane().add(button8);
		
		JButton button9 = new JButton("9");
		button9.setBounds(208, 67, 89, 74);
		mainFrame.getContentPane().add(button9);
		
		JButton button4 = new JButton("4");
		button4.setBounds(10, 152, 89, 74);
		mainFrame.getContentPane().add(button4);
		
		JButton button5 = new JButton("5");
		button5.setBounds(109, 152, 89, 74);
		mainFrame.getContentPane().add(button5);
		
		JButton button6 = new JButton("6");
		button6.setBounds(208, 152, 89, 74);
		mainFrame.getContentPane().add(button6);
		
		JButton button1 = new JButton("1");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPressedButton(1);
			}
		});
		button1.setBounds(10, 237, 89, 74);
		mainFrame.getContentPane().add(button1);
		
		JButton button2 = new JButton("2");
		button2.setBounds(109, 237, 89, 74);
		mainFrame.getContentPane().add(button2);
		
		JButton button3 = new JButton("3");
		button3.setBounds(208, 237, 89, 74);
		mainFrame.getContentPane().add(button3);
		
		JButton buttonDot = new JButton(".");
		buttonDot.setBounds(208, 322, 89, 74);
		mainFrame.getContentPane().add(buttonDot);
		
		JButton button0 = new JButton("0");
		button0.setBounds(10, 322, 188, 74);
		mainFrame.getContentPane().add(button0);
		
		
	}

	protected void actionPressedButton(int pressedButton) {
		// action when GUI button is pressed
		stratagemSelectionWindow.selectNewStratagemForButton(pressedButton, stratagemMap);
		
	}
}
