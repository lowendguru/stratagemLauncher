package main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

	/**
	 * Create the frame.
	 */
	public StratagemSelectionWindow() {

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				onExit();
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

		StratagemList stratagemsList = new StratagemList();
		stratagemsList.initialize("default");

		for (Stratagem s : stratagemsList) {
			containerPanel.setPreferredSize(new Dimension(390, (55 * stratagemsList.size())));
			PanelStratagem ps = new PanelStratagem(s);
			containerPanel.add(ps);

		}

		contentPane.add(scrollPane);
		contentPane.repaint();
	}

	public void selectNewStratagemForButton(int pressedButton, Stratagem[] stratagemMap, JFrame mainWindow) {
		this.mainWindow = mainWindow;
		mainWindow.setVisible(false);
		this.setVisible(true);
	}

	private void onExit() {
		mainWindow.setVisible(true);
		this.setVisible(false);
	}
}
