import java.awt.Color;
import java.util.ArrayList;

public class JogoDaVelha {
	private String nome1;
	private String nome2;
	private String[][] matriz = new String[3][3];
	private boolean fim = false;
	private int contjogada;
	private String historico = "";
	private int resultado;

	// ....

	public JogoDaVelha(String nome1, String nome2) {
		this.nome1 = nome1;
		this.nome2 = nome2;
		historico += "jogadores:" + nome1 + " contra " + nome2;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				matriz[i][j] = "-";
	}

	public JogoDaVelha(String nome1) {
		this.nome1 = nome1;
		this.nome2 = "maquina";
		historico += "jogadores:" + nome1 + " contra " + nome2;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				matriz[i][j] = "-";
	}

	public boolean jogarJogador(int numj, int lin, int col) {
		return false;
	}

	public int terminou(int numj, int lin, int col) {
		// CRIAR MATRIZ PRE-DEFINIDA E COMPARAR int[][] teste = {{0,0},{1,0},{2,0}};

		// VERIFICAR JOGADAS DO JOGADOR 1
		System.out.println("Jogador: " + numj);
		getUltimaLinha(lin);
		getUltimaColuna(col);
		return 0;

	}

	public int getUltimaLinha(int lin) {
		ArrayList<Integer> valoresLinha = new ArrayList<Integer>();
		valoresLinha.add(lin);

		for (int l : valoresLinha) {
			System.out.printf("Linha: %d\n", l);
		}
		return 0;
	}

	public boolean getUltimaColuna(int col) {
		ArrayList<Integer> valoresColuna = new ArrayList<Integer>();
		valoresColuna.add(col);

		for (int c : valoresColuna) {
			System.out.printf("Coluna: %d\n", c);
			System.out.println("--------------------");
		}

		return true;
	}

//	public int getResultado(int lin,int col) {

	// }
}