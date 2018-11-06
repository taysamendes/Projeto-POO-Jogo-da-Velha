import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * IFPB - TSI - POO
 * 
 * @author Prof. Fausto Ayres
 *
 */
public class TabuleiroTrabalho {

	private JFrame frame;
	private JLabel[][] labels = new JLabel[3][3];
	private JogoDaVelha jogo;
	private int numeroJogador = 1;
	private JLabel label;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabuleiroTrabalho window = new TabuleiroTrabalho();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TabuleiroTrabalho() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jogo = new JogoDaVelha("joao", "maria");
		frame = new JFrame();
		frame.setTitle("Matriz de Labels");
		frame.setBounds(100, 100, 417, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		label = new JLabel("Jogador:");
		label.setBounds(113, 326, 160, 14);
		frame.getContentPane().add(label);
		label.setText("Aguardando jogada...");

		button = new JButton("reiniciar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jogo = new JogoDaVelha("xx", "xxx");
				TabuleiroTrabalho t1 = new TabuleiroTrabalho();
				t1.frame.setVisible(true);
				
				numeroJogador = 1;
				System.out.println("Limpar jogadas");

			}

		});
		button.setBounds(149, 352, 129, 25);
		frame.getContentPane().add(button);

		// inicializar a matriz de labels
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				labels[i][j] = new JLabel("");
				frame.getContentPane().add(labels[i][j]);
				labels[i][j].setBounds(i * 40, j * 40, 40, 40); // x,y, width, height - 40x40
				labels[i][j].setBackground(Color.PINK);
				labels[i][j].setBorder(new LineBorder(new Color(0, 0, 0)));
				labels[i][j].setOpaque(true);
				labels[i][j].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) { // click
						JLabel b = (JLabel) e.getSource();
						int indicex = b.getX() / 40;
						int indicey = b.getY() / 40;

						if (numeroJogador == 1) {
							if (labels[indicex][indicey].isEnabled()) {
								labels[indicex][indicey].setBackground(Color.WHITE);
								labels[indicex][indicey].setText("X");
								labels[indicex][indicey].removeMouseListener(this);
								labels[indicex][indicey].disable();
								label.setText("Vez:jogador 2");

							}
						} else if (numeroJogador == 2) {
							if (labels[indicex][indicey].isEnabled()) {
								labels[indicex][indicey].setBackground(Color.GREEN);
								labels[indicex][indicey].setText("O");
								labels[indicex][indicey].removeMouseListener(this);
								labels[indicex][indicey].disable();
								label.setText("Vez: jogador 1");

							}
						}

						jogo.terminou(numeroJogador, indicex, indicey);

						// if(jogo.terminou(numeroJogador,indicex,indicey))
						// label.setText(jogo.getResultado("O jogador '' venceu."));

						// System.out.println("clicou na celula:"+ indicex + "-" + indicey);

						// label.setText("jogador(a):"+numeroJogador);
						boolean jogadavalida = jogo.jogarJogador(numeroJogador, indicex, indicey);

						if (numeroJogador == 1)

							numeroJogador = 2;
						else
							numeroJogador = 1;
					}
				});
			}
		}

	}
}