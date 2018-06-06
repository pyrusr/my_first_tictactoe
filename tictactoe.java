package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class tictactoe {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String[][] velha = { { "7", "8", "9" }, { "4", "5", "6" }, { "1", "2", "3" } };
		String[] jogadas = new String[10];
		String marca;
		String jogador;

		boolean player = false;
		boolean jogadaValida = false;
		boolean fim = false;

		int rodada = 0;
		int cursor = 0;

		// Start
		System.out.println("Player 1, type your name: ");
		String jogador1 = input.nextLine();
		System.out.println(jogador1 + " will be represented with X\n");
		System.out.println("Player 2, type your name: ");
		String jogador2 = input.nextLine();
		System.out.println(jogador2 + " will be represented with O\n");

		while (!fim) {

			// Round Countter
			rodada++;

			// Player selection
			if (!player) {
				marca = "x";
				jogador = jogador1;
			} else {
				marca = "o";
				jogador = jogador2;
			}

			// Tab view
			System.out.println("\n" + jogador + " make a move: \n");
			System.out.println(velha[0][0] + "|" + velha[0][1] + "|" + velha[0][2]);
			System.out.println("- " + "- " + "-");
			System.out.println(velha[1][0] + "|" + velha[1][1] + "|" + velha[1][2]);
			System.out.println("- " + "- " + "-");
			System.out.println(velha[2][0] + "|" + velha[2][1] + "|" + velha[2][2]);
			System.out.println(" ");

			// Spot played
			do {
				try {
				
					cursor = input.nextInt();
				} catch (InputMismatchException a) {
					input.next();
				}

				if (cursor >= 1 && cursor < 10 && jogadas[cursor] == null) {
					jogadas[cursor] = marca;
					jogadaValida = true;
				} else {
					System.out.println("You entered a bad input...please try again\n");
					System.out.println(velha[0][0] + "|" + velha[0][1] + "|" + velha[0][2]);
					System.out.println("- " + "- " + "-");
					System.out.println(velha[1][0] + "|" + velha[1][1] + "|" + velha[1][2]);
					System.out.println("- " + "- " + "-");
					System.out.println(velha[2][0] + "|" + velha[2][1] + "|" + velha[2][2]);
					System.out.println(" ");
				}

			} while (!jogadaValida);

			switch (cursor)

			{
			case 7:
				velha[0][0] = marca;
				break;
			case 8:
				velha[0][1] = marca;
				break;
			case 9:
				velha[0][2] = marca;
				break;
			case 4:
				velha[1][0] = marca;
				break;
			case 5:
				velha[1][1] = marca;
				break;
			case 6:
				velha[1][2] = marca;
				break;
			case 1:
				velha[2][0] = marca;
				break;
			case 2:
				velha[2][1] = marca;
				break;
			case 3:
				velha[2][2] = marca;
				break;
			}

			// Show who wins
			if (velha[0][0] == velha[0][1] && velha[0][1] == velha[0][2]) {
				System.out.println( jogador + " you win!");
				fim = true;
			} else if (velha[1][0] == velha[1][1] && velha[1][0] == velha[1][2]) {
				System.out.println( jogador + " you win!");
				fim = true;
			} else if (velha[2][0] == velha[2][1] && velha[2][0] == velha[2][2]) {
				System.out.println( jogador + " you win!");
				fim = true;
			} else if (velha[0][0] == velha[1][0] && velha[0][0] == velha[2][0]) {
				System.out.println( jogador + " you win! ");
				fim = true;
			} else if (velha[0][1] == velha[1][1] && velha[0][1] == velha[2][1]) {
				System.out.println( jogador + " you win! ");
				fim = true;
			} else if (velha[0][2] == velha[1][2] && velha[0][2] == velha[2][2]) {
				System.out.println( jogador + " you win! ");
				fim = true;
			} else if (velha[0][0] == velha[1][1] && velha[0][0] == velha[2][2]) {
				System.out.println(jogador + " you win! ");
				fim = true;
			} else if (velha[0][2] == velha[1][1] && velha[0][2] == velha[2][0]) {
				System.out.println(jogador + " you win! ");
				fim = true;
			} else if (rodada == 9) {
				System.out.println("Draw game!");
				fim = true;
			}

			// Change the player
			if (!player) {
				player = true;
			} else {
				player = false;
			}

			jogadaValida = false;

		}

		input.close();
	}

}
