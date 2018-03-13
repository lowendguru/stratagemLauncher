package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Stratagem;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class StratagemSelectionWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StratagemSelectionWindow frame = new StratagemSelectionWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StratagemSelectionWindow() {
		setResizable(false);
		setTitle("Stratagem Selection");
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(5, 5, 439, 457);
		// contentPane.add(scrollPane);

		ArrayList<Stratagem> stratagemsList = new ArrayList<Stratagem>();

		stratagemsList.add(new Stratagem("nombre1", "wasd", 1, "48px-Strat_A_MG-II_Minigun_Turret_mk1.png"));

		for (Stratagem s : stratagemsList) {
			PanelStratagem ps = new PanelStratagem(s);
			scrollPane.setViewportView(ps);
			scrollPane.add(ps);
			scrollPane.repaint();
		}

		contentPane.add(scrollPane);
		contentPane.repaint();
	}

}
