import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JComboBox;

public class interno extends JInternalFrame {
	private JPasswordField pwdJj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interno frame = new interno();
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
	public interno() {
		getContentPane().setBackground(Color.RED);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBackground(Color.DARK_GRAY);
		setResizable(true);
		//setIcon(true);
		setClosable(true);
		setBounds(100, 100, 450, 355);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(23, 32, 46, 14);
		panel.add(lblNewLabel);
		
		JButton btnJh = new JButton("jh");
		btnJh.setBounds(33, 115, 89, 23);
		panel.add(btnJh);
		
		pwdJj = new JPasswordField();
		pwdJj.setText("jj");
		pwdJj.setBounds(298, 273, 89, 20);
		panel.add(pwdJj);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");
		lblNewJgoodiesLabel.setBounds(23, 162, 92, 14);
		panel.add(lblNewJgoodiesLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(200, 97, 28, 20);
		panel.add(comboBox);

	}
}
