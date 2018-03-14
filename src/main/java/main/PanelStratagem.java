package main;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import model.Stratagem;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class PanelStratagem extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelStratagem(Stratagem stratagem) {
		setLayout(null);

		JLabel labelIcon = new JLabel("");
		labelIcon.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/" + stratagem.getIconFileName())));
		labelIcon.setBounds(10, 0, 62, 54);
		add(labelIcon);

		JLabel labelName = new JLabel(stratagem.getName());
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelName.setBounds(82, 11, 358, 32);
		add(labelName);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 53, 518, 53);
		add(separator);

		this.setVisible(true);
	}
}
