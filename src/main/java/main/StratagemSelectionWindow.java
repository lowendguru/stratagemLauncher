package main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import model.Stratagem;
import model.StratagemList;

@SuppressWarnings("serial")
public class StratagemSelectionWindow extends JFrame {

	private JPanel contentPane;
	private JFrame mainWindow;
	private int pressedButton;
	private ArrayList<Stratagem> stratagemMap;
	StratagemList stratagemsList = new StratagemList().initialize("default");

	/**
	 * Create the frame.
	 */
	public StratagemSelectionWindow() {

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				closeWindow();
			}
		});

		setResizable(false);
		setTitle("Stratagem Selection");
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel containerPanel = new JPanel();
		containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(5, 5, 389, 457);
		scrollPane.add(containerPanel);
		scrollPane.setViewportView(containerPanel);

		for (int i = 0; i < stratagemsList.size(); i++) {
			containerPanel.setPreferredSize(new Dimension(390, (55 * stratagemsList.size())));
			ButtonStratagem buttonStratagem = new ButtonStratagem(stratagemsList.get(i));

			final int ii = i;
			buttonStratagem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPressedButtonStratagem(ii);
				}
			});

			containerPanel.add(buttonStratagem);

		}

		contentPane.add(scrollPane);
		contentPane.repaint();
	}

	public void actionPressedButtonStratagem(int stratagemIndex) {
		stratagemMap.set(pressedButton, stratagemsList.get(stratagemIndex));
		closeWindow();
	}

	public void selectNewStratagemForButton(int pressedButton, ArrayList<Stratagem> stratagemMap, JFrame mainWindow) {
		this.pressedButton = pressedButton;
		this.stratagemMap = stratagemMap;
		this.mainWindow = mainWindow;
		mainWindow.setVisible(false);
		this.setVisible(true);
	}

	private void closeWindow() {
		mainWindow.setVisible(true);
		mainWindow.repaint();
		this.setVisible(false);
	}
}
