package me.katya;

public class GameController { // Мейн класс для запуска игры
	public static void main(String[] args) {
		Game game = new GuessNumberGame();
		game.start();
	}
}