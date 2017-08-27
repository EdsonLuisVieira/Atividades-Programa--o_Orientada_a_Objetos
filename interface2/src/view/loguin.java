package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class loguin extends JFrame {

	private JPanel contentPane;
	private JTextField txtloguin;
	private JPasswordField txtsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loguin frame = new loguin();
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
	public loguin() {
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("interface");
		setFont(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("\r\n");
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblLoguin = new JLabel("LOGUIN");
		lblLoguin.setForeground(Color.BLACK);
		
		txtloguin = new JTextField();
		txtloguin.setColumns(10);
		
		JLabel lblSenha = new JLabel("SENHA");
		
		txtsenha = new JPasswordField();
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtloguin.getText().equals("Edson")&&(txtsenha.getText().equals("123"))){
					JOptionPane.showMessageDialog(null,"logado");
				}else{
					JOptionPane.showMessageDialog(null,"acesso negado");
				}
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(loguin.class.getResource("/imagens/1.jpg")));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnEntrar)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblSenha)
							.addComponent(txtloguin, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
							.addComponent(lblLoguin, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtsenha)))
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblLoguin, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtloguin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblSenha)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtsenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(38)
					.addComponent(btnEntrar)
					.addContainerGap(143, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnEntrar, lblSenha, txtloguin, lblLoguin, txtsenha, lblNewLabel}));
	}
}
