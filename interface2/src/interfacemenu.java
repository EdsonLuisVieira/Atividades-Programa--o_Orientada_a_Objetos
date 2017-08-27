import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Component;
import javax.swing.JDesktopPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;

public class interfacemenu extends JFrame {
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfacemenu frame = new interfacemenu();
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
	public interfacemenu() {
		setTitle("menu\r\n");
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 504, 415);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("arquivo\r\nusuarios\r\n");
		setJMenuBar(menuBar);
		
		JMenu mnArquivos = new JMenu("arquivos");
		mnArquivos.setIcon(new ImageIcon(interfacemenu.class.getResource("/imagens/status_away.png")));
		mnArquivos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnArquivos.setBackground(UIManager.getColor("CheckBox.focus"));
		menuBar.add(mnArquivos);
		
		JMenuItem mntmCadastrar = new JMenuItem("cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				interno useradd =new interno();
				getContentPane().add(useradd,BorderLayout.CENTER);
				useradd.setVisible(true);   
				
				
			}
		});
		mntmCadastrar.setIcon(new ImageIcon(interfacemenu.class.getResource("/imagens/status_away.png")));
		mnArquivos.add(mntmCadastrar);
		
		JMenuItem mntmPesquisar = new JMenuItem("pesquisar");
		mntmPesquisar.setIcon(new ImageIcon(interfacemenu.class.getResource("/imagens/tab_add.png")));
		mnArquivos.add(mntmPesquisar);
		
		JMenuItem mntmRemover = new JMenuItem("remover");
		mntmRemover.setIcon(new ImageIcon(interfacemenu.class.getResource("/imagens/stop.png")));
		mnArquivos.add(mntmRemover);
		
		JMenu mnVusuarios = new JMenu("usuarios");
		mnVusuarios.setIcon(new ImageIcon(interfacemenu.class.getResource("/imagens/status_online.png")));
		mnVusuarios.setBackground(new Color(0, 0, 0));
		mnVusuarios.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.add(mnVusuarios);
		
		JMenuItem adcuser = new JMenuItem("inserir");
		adcuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				interframe useradd =new interframe();
				getContentPane().add(useradd);
				useradd.setVisible(true);  
				
			}
		});
		adcuser.setIcon(new ImageIcon(interfacemenu.class.getResource("/imagens/style_go.png")));
		mnVusuarios.add(adcuser);
		
		JMenuItem mntmNovo = new JMenuItem("novo");
		mntmNovo.setIcon(new ImageIcon(interfacemenu.class.getResource("/imagens/tab_delete.png")));
		mnVusuarios.add(mntmNovo);
		
		JDesktopPane Pane1 = new JDesktopPane();
		getContentPane().add(Pane1, BorderLayout.CENTER);
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(LONG_DESCRIPTION, "");
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
