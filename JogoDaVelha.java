/**
 * IFPB - TSI
 * @author Mayara Gomes Pereira & Taysa Samara Mendes Pinheiro
 *
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class JogoDaVelha {
	private String nome1;
	private String nome2;
	private int[][] matriz = new int[3][3];
	private int contjogada;
	private String historico ="";
	private int resultado;
	private int linha;
	private int coluna;
	private int numJogador;


	public JogoDaVelha(String nome1, String nome2) {
		this.nome1 = nome1;
		this.nome2 = nome2;
		historico += "jogadores:" + nome1 + " contra " + nome2+"\n";
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				matriz[i][j] = 0;
	}

	public JogoDaVelha(String nome1) {
		this.nome1 = nome1;
		this.nome2 = "Maquina";
		historico += "jogadores:" + nome1 + " contra " + nome2;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				matriz[i][j] = 0;
	}

	public boolean jogarJogador(int numj, int lin, int col) {

		if (numj == 1) {
			historico+=">>>> O jogador: "+numj+" jogou na posicao linha: "+lin+" e na coluna: "+col+"\n";
			System.out.println(historico);

			numJogador = 1;
			if (matriz[lin][col] == 0) {
				matriz[lin][col] = 1;
				linha = lin;
				coluna = col;
				for(int i=0; i<3; i++){
					for(int j=0; j<3; j++){

						if(matriz[i][j]==-1){
							System.out.print(" O ");
						}
						if(matriz[i][j]==1){
							System.out.print(" X ");
						}
						if(matriz[i][j]==0){
							System.out.print("   ");
						}

						if(j==0 || j==1)
							System.out.print("|");
					}
					System.out.println();
				}

				System.out.println("\n");
				return true;
			}

		} 

		if (numj == 2) {
			historico+=">>>> O jogador: "+numj+" jogou na posicao linha: "+lin+" e na coluna: "+col+"\n";
			System.out.println(historico);

			numJogador = 2;
			if (matriz[lin][col] == 0) {
				matriz[lin][col] = -1;
				linha = lin;
				coluna = col;
				for(int i=0 ; i<3 ; i++){
					for(int j=0 ; j<3 ; j++){

						if(matriz[i][j]==-1){
							System.out.print(" O ");
						}
						if(matriz[i][j]==1){
							System.out.print(" X ");
						}
						if(matriz[i][j]==0){
							System.out.print("   ");
						}

						if(j==0 || j==1)
							System.out.print("|");
					}
					System.out.println(); 
				}

				System.out.println("\n");
				return true;
			}
		}
		return false;
	}


	public boolean terminou() {
		++contjogada;

//		if(contjogada == 9) {
//			resultado = 3;
//			gravarTxt(historico);
//			return true;
//		}
		for(int i=0; i<3; i++){
			if(matriz[i][0] + matriz[i][1] + matriz[i][2] == 3 ||
					matriz[0][i] + matriz[1][i] + matriz[2][i] == 3 ||
					matriz[0][0] + matriz[1][1] + matriz[2][2] == 3 ||
					matriz[0][2] + matriz[1][1] + matriz[2][0] == 3) {
				resultado = 1;
				gravarTxt(historico);
				return true;
			}

			if(matriz[i][0] + matriz[i][1] + matriz[i][2] == -3 ||
					matriz[0][i] + matriz[1][i] + matriz[2][i] == -3 ||
					matriz[0][0] + matriz[1][1] + matriz[2][2] == -3 ||
					matriz[0][2] + matriz[1][1] + matriz[2][0] == -3) {
				resultado = 2;
				gravarTxt(historico);
				return true;
			}
		}

		return false;
	}

	public int getResultado() { 
		return resultado;
	}


	public String getNomeJogador(int jogador) {
		if(jogador == 1) {
			return nome1 + " ";
		}
		if(jogador == 2) {
			return nome2 + " ";
		}
		return "";
	}

	public int getUltimaLinha() {
		return linha;
	}

	public  int  getUltimaColuna() {
		return coluna;
	}

	public  int  getUltimoJogador() {
		return numJogador;
	}

	public void jogarMaquina() {
		Random maquina = new Random();


		int linha;
		int coluna;

		do {
			linha = maquina.nextInt(3);
			coluna = maquina.nextInt(3);
		}while(!jogarJogador(2,linha+1,coluna+1));
	}

	public void gravarTxt(String historico) {
		try {
			FileWriter arq = new FileWriter( new File("jogodavelha.txt") ); 

			arq.write(historico);
			arq.close();

		}catch(IOException e){
			System.out.println("erro de gravação");
			System.exit(0);
		}
	}
}
