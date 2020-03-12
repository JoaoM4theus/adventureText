package adventureText;

import java.util.Scanner;
import java.util.Random;

public class Principal {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		String action;
		String nome;
		System.out.println("Digite seu nome: ");
		nome = in.nextLine();
		
		System.out.println("Olá, "+nome+"! Você é um aventureiro arrojado e está em busca de uma manopla que concede ao portador uma grande quantidade de energia, usando\na atmosfera ao seu redor como combustível mágico. ");
		
		int a = 0, b = 0, c = 1;
		int cont = 1;
		int vida = 100;
		
		int[][] mapa = new int[3][3];
		while(cont!=6) { //RANDOMIZANDO EVENTOS
			a = rand.nextInt(3);
			b = rand.nextInt(3);
				
			if(mapa[a][b] == 0) {
				mapa[a][b] = c;
				cont++;
				c+=1;
			}
		}
		
		for(int i = 0; i<3; i++) {//PEGANDO POSICAO INICIAL
			for(int j = 0; j<3; j++) {
				if(mapa[i][j] == 1) {
					a = i; b = j;
				}
			}
		}
		
		System.out.println("W - CIMA | A - ESQUERDA | D - DIREITA | S - BAIXO \n\n");
		System.out.println("Vida: "+vida);
		System.out.println("Digite W, A, S ou D para se locomover pela dungeon. Obs.: Enquanto não digitar as opções corretas, o jogo não irá prosseguir!\n");
		System.out.println("Enquanto andava pela dungeon você acabou caindo em um buraco e parando em uma espécie da labirinto. Segundo o seu mapa, o tesouro deve estar próximo. Procure-o.\nJogue!");
		
		while(vida!=0) {
			System.out.print("Digite: ");
			action = in.next();
			if(action.equals("W") || action.equals("w")) {
				a-=1;
			}
			if(action.equals("S") || action.equals("s")) {
				a+=1;
			}
			if(action.equals("A") || action.equals("a")) {
				b-=1;
			}
			if(action.equals("D") || action.equals("d")) {
				b+=1;
			}
			
			if(a == -1) {//CASO SAIA DA MATRIZ.
				a+=1; System.out.println("Você se deparou com um caminho sem saída e voltou para sala onde estava. Escolha outra direção.");
			} else if(a == 3) {
				a-=1; System.out.println("Você se deparou com um caminho sem saída e voltou para sala onde estava. Escolha outra direção.");
			} else if(b == -1) {
				b+=1; System.out.println("Você se deparou com um caminho sem saída e voltou para sala onde estava. Escolha outra direção.");
			} else if(b == 3) {
				b-=1; System.out.println("Você se deparou com um caminho sem saída e voltou para sala onde estava. Escolha outra direção.");
			} else {
				if(mapa[a][b] == 2) {
					System.out.println("Você se encontrou com um Minotauro. O que deseja fazer? (a) Enfrenta-lo ou (e) Escapar. Obs.: Enquanto não digitar as opções existentes, o jogo não irá prosseguir!");
					action = in.nextLine();
					
					while(!(action.equals("a") || action.equals("A") || action.equals("e") || action.equals("E"))) {
						action = in.next();
					}
					if(action.equals("a") || action.equals("A")) {
						if(rand.nextInt(100)<70) {
							System.out.println("Você derrotou o Minotauro! Continue a sua busca pelo tesouro.");
							mapa[a][b] = 1;
						} else {
							System.out.println("Você perdeu! Minotauro foi superior a você");
							vida = 0;
						}
					} else if(action.equals("e") || action.equals("E")) {
						if(rand.nextInt(100)<10) {
							System.out.println("Você conseguiu escapar. Porém durante a fuga o Minotauro lhe atingiu com o machado.\nVocê sofreu dano e voltou para sala onde estava."
									+ "Encare-o novamente ou escolha outro caminho.");
							vida -= 50; 
							System.out.println("Vida: "+vida); 
							mapa[a][b] = 0;
							if(action.equals("W") || action.equals("w")) {
								mapa[a+1][b] = 1;
							} else if(action.equals("S") || action.equals("s")) {
								mapa[a-1][b] = 1;
							} else if(action.equals("A") || action.equals("a")) {
								mapa[a][b+1] = 1;
							} else if(action.equals("D") || action.equals("d")) {
								mapa[a][b-1] = 1;
							}
								
							if(vida == 0 || vida < 0) {
								System.out.println("Voce morreu! Fim de jogo.");
								vida = 0;
							}
						} else {
							System.out.println("Você morreu! Sua fuga não foi um sucesso. Fim de jogo.");
							vida = 0;
						}
					}
				} else if(mapa[a][b] == 3) {
						System.out.println("Você se encontrou com um Troll. O que deseja fazer? (a) Enfrenta-lo ou (e) Escapar."
								+ "Obs.: Enquanto não digitar as opções existentes, o jogo não irá prosseguir!");
						action = in.next();
						while(!(action.equals("a") || action.equals("A") || action.equals("e") || action.equals("E"))) {
							action = in.next();
						}
						if(action.equals("a") || action.equals("A")) {
							if(rand.nextInt(100)<60) {
								System.out.println("Você derrotou o Troll! Continue a sua busca pelo tesouro.");
								mapa[a][b] = 0;
							} else {
								System.out.println("Você perdeu! Troll foi superior a você");
								vida = 0;
							}
						} else if(action.equals("e") || action.equals("E")) {
							if(rand.nextInt(100)<20) {
								System.out.println("Você conseguiu escapar. Porém durante a fuga o Troll lhe atingiu com um soco.\nVocê sofreu dano e voltou para sala onde estava."
										+ "Encare-o novamente ou escolha outro caminho.");
								vida -= 40; System.out.println("Vida: "+vida);
								mapa[a][b] = 0;
								if(action.equals("W") || action.equals("w")) {
									mapa[a+1][b] = 1;
								} else if(action.equals("S") || action.equals("s")) {
									mapa[a-1][b] = 1;
								} else if(action.equals("A") || action.equals("a")) {
									mapa[a][b+1] = 1;
								} else if(action.equals("D") || action.equals("d")) {
									mapa[a][b-1] = 1;
								}
								if(vida == 0 || vida < 0) {
									System.out.println("Voce morreu! Fim de jogo.");
									vida = 0;
								}
							} else {
								System.out.println("Você morreu! Sua fuga não foi um sucesso. Fim de jogo.");
								vida = 0;
							}
						}
					} else if(mapa[a][b] == 4) {
							System.out.println("Você entrou na sala e acionou uma armadilha de fogo. O que deseja fazer? (c) Confrotar a armadilha ou (e) Escapar."
									+ "Obs.: Enquanto não digitar as opções existentes, o jogo não irá prosseguir!");
							action = in.next();
							while(!(action.equals("c") || action.equals("C") || action.equals("e") || action.equals("E"))) {
								action = in.next();
							}
							if(action.equals("c") || action.equals("C")) {
								if(rand.nextInt(100)<15) {
									System.out.println("Você conseguiu sobreviver a armadilha, porém sofreu muito dano!"
											+ "Prossiga com sua busca ao tesouro.");
									mapa[a][b] = 1; 
									vida -= 80; 
									System.out.println("Vida: "+vida);
									if(vida == 0 || vida < 0) {
										System.out.println("Voce morreu! Fim de jogo.");
										vida = 0;
									}
								} else {
									System.out.println("Você foi reduzido as cinzas! Fim de jogo.");
									vida = 0;
								}
							} else {
								System.out.println("Você foi incinerado até a morte! Fim de jogo.");
								vida = 0;
							}
						} else if(mapa[a][b] == 5){
							System.out.println("Você encontrou a Manopla! Parabéns, você venceu!.");
							break;
						} else if(!(action.equals("w") || action.equals("W") || action.equals("s") || action.equals("S") || action.equals("a") || action.equals("A") || action.equals("d") || action.equals("D"))){
							System.out.println("Opcao invalida!");
							
						} else {
							if(rand.nextInt(100)<50) {
								System.out.println("Você se encontrou em uma sala vazia. Escolha outro caminho.");
							} else {
								System.out.println("A Manopla não se encontra nesta sala. Escolha outro caminho!");
							}
						}
			}
		}	
	}	
}