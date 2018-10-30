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
		//int[] novo = {};
		ArrayList<Integer> valoresLinha = new ArrayList<Integer>();
		ArrayList<Integer> valoresColuna = new ArrayList<Integer>();
// CRIAR MATRIZ PRE-DEFINIDA E COMPARAR		int[][] teste = {{0,0},{1,0},{2,0}};

		//VERIFICAR JOGADAS DO JOGADOR 1
		if(numj==1) {
			valoresLinha.add(lin);
			valoresColuna.add(col);
			
				for(int l: valoresLinha) {
					for(int c: valoresColuna) {
						System.out.printf("linha = %d",l);
						System.out.printf("coluna = %d\n",c);
							if(((l==0 && c==0)&&(l==1 && c==0)&&(l==2 && c==0))) {
								System.out.println("linha 1 ok");
						}
					}
				}
			

		}
		return 0;

	}

	public int getUltimaLinha(int lin) {
		System.out.println(lin);
		return 0;
	}

/*	public boolean verificaColuna(int col) {
		int[][] colunas1= {{0},{0},{0}};
		int[][] colunas2= {{1},{1},{1}};
		int[][] colunas3= {{2},{2},{2}};



		return true;
		
	}*/


	public int getResultado(int lin,int col) {
			

	}
}