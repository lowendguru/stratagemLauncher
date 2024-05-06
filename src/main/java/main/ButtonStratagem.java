package main;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import model.Stratagem;

@SuppressWarnings("serial")
public class ButtonStratagem extends JButton {

	/**
	 * Create the panel.
	 */
	public ButtonStratagem(Stratagem stratagem) {
		setLayout(null);

		JLabel labelIcon = new JLabel("");
		labelIcon.setIcon(new ImageIcon(ClassLoader.getSystemResource(stratagem.getIconFileName())));
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
