package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import listener.GlobalKeyboardListener;
import model.StratagemMap;
import utils.FileHelper;

public class MainWindow {

	public static final boolean TESTING = true;
	public static final int KEY_DELAY = 25;
	public static final int MIN_DELAY_BETWEEN_KEYSTROKE = 100;
	public static final int MAX_DELAY_BETWEEN_KEYSTROKE = 150;

	public static final int MIN_DELAY_PRESS_KEY = 50;
	public static final int MAX_DELAY_PRESS_KEY = 70;
	private JFrame mainFrame;
	private StratagemSelectionWindow stratagemSelectionWindow = new StratagemSelectionWindow();
	private static final int STRATAGEM_MAP_SIZE = 11;
	public static StratagemMap stratagemMap;
	private ArrayList<JButton> buttonsList = new ArrayList<JButton>();
	public static String FILE_NAME = "stratagemLauncher.ini";

	public static void main(String[] args) {

		// Set cross-platform Java L&F (also called "Metal")
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.mainFrame.setVisible(true);

					new GlobalKeyboardListener(stratagemMap);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		System.out.println("Testing mode: " + TESTING);
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initializeStratagemMap();
		initializeMainWindow();
		refreshButtons();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeMainWindow() {
		mainFrame = new JFrame();
		mainFrame.getContentPane().setBackground(Color.DARK_GRAY);
		mainFrame.setResizable(false);
		mainFrame.setTitle("Stratagem Launcher");
		mainFrame.setBounds(100, 100, 313, 444);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setIconImage(new ImageIcon(ClassLoader.getSystemResource("17_-_Commodore.png")).getImage());

		JLabel labelLogo = new JLabel("");
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setBounds(10, 0, 287, 68);
		labelLogo.setIcon(new ImageIcon(ClassLoader.getSystemResource("Logo-Helldivers-custom.png")));
		mainFrame.getContentPane().add(labelLogo);

		buttonsList.add(new JButton("0"));
		buttonsList.get(0).setBounds(10, 322, 188, 74);

		buttonsList.add(new JButton("1"));
		buttonsList.get(1).setBounds(10, 237, 89, 74);

		buttonsList.add(new JButton("2"));
		buttonsList.get(2).setBounds(109, 237, 89, 74);

		buttonsList.add(new JButton("3"));
		buttonsList.get(3).setBounds(208, 237, 89, 74);

		buttonsList.add(new JButton("4"));
		buttonsList.get(4).setBounds(10, 152, 89, 74);

		buttonsList.add(new JButton("5"));
		buttonsList.get(5).setBounds(109, 152, 89, 74);

		buttonsList.add(new JButton("6"));
		buttonsList.get(6).setBounds(208, 152, 89, 74);

		buttonsList.add(new JButton("7"));
		buttonsList.get(7).setBounds(10, 67, 89, 74);

		buttonsList.add(new JButton("8"));
		buttonsList.get(8).setBounds(109, 67, 89, 74);

		buttonsList.add(new JButton("9"));
		buttonsList.get(9).setBounds(208, 67, 89, 74);

		buttonsList.add(new JButton("."));
		buttonsList.get(10).setBounds(208, 322, 89, 74);

		for (int i = 0; i < buttonsList.size(); i++) {

			mainFrame.getContentPane().add(buttonsList.get(i));

			// action listeners for buttons
			final int ii = i;
			buttonsList.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPressedButton(ii);
				}
			});
		}

	}

	protected void actionPressedButton(int pressedButton) {
		// action when GUI button is pressed
		stratagemSelectionWindow.selectNewStratagemForButton(pressedButton, stratagemMap, this);

	}

	private void initializeStratagemMap() {

		// if there is .ini file, load from file
		stratagemMap = FileHelper.readIniFile(FILE_NAME);

		if (stratagemMap == null) {
			System.out.println("There is no .ini file");
			MainWindow.stratagemMap = new StratagemMap(STRATAGEM_MAP_SIZE);
			for (int i = 0; i < STRATAGEM_MAP_SIZE; i++) {
				stratagemMap.add(null);
			}
		}
	}

	public void refreshButtons() {

		for (int i = 0; i < buttonsList.size(); i++) {
			if (stratagemMap.get(i) != null) {
				buttonsList.get(i).setText(null);
				buttonsList.get(i)
						.setIcon(new ImageIcon(ClassLoader.getSystemResource(stratagemMap.get(i).getIconFileName())));
				buttonsList.get(i).setToolTipText(stratagemMap.get(i).getName());
			}
		}
		mainFrame.getContentPane().repaint();
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

}
