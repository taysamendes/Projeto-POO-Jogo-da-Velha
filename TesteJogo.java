package jdv;

import java.util.Scanner;

public class TesteJogo {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		JogoDaVelha jogo = new JogoDaVelha("Mayara", "Taysa");
		int linha, coluna;
		boolean jogadavalida;
		int numeroJogador = 1;
		
		do {

			do {

				System.out.println("jogador:" + numeroJogador);
				System.out.println("digite a linha");
				linha = teclado.nextInt();
				System.out.println("digite a coluna");
				coluna = teclado.nextInt();
				jogadavalida = jogo.jogarJogador(numeroJogador, linha, coluna);
				if(jogadavalida){
					linha = jogo.getUltimaLinha();
					coluna = jogo.getUltimaColuna();
					
					System.out.println("****"+linha +"-"+ coluna +"****" );
					System.out.println(jogo.getNomeJogador(numeroJogador)+"jogou na posicao "+linha + "-" + coluna);
				}
				else
					System.out.println("jogada invalida");
			}while(!jogadavalida);
 
			if(numeroJogador==1) 
				numeroJogador=2; 
			else numeroJogador=1;

		}while( !jogo.terminou());

		switch(jogo.getResultado()) {
		case 1: System.out.println(jogo.getNomeJogador(1) + "venceu"); break;
		case 2: System.out.println(jogo.getNomeJogador(2) + "venceu"); break;
		case 3: System.out.println("ninguem venceu");
		}
		teclado.close();

		// gravar no arquivo jogo.txt  o hist�rico do jogo at� o resultado

	}
}

