package me.katya;

import me.katya.generator.RandomGenerator;

public class GameController { // Мейн класс для запуска игры
	public static void main(String[] args) {
		Game game = new GuessNumberGame(new RandomGenerator());
		game.start();
	}
}