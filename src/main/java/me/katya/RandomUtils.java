package me.katya;

import java.util.Random;

public class RandomUtils { // Утилита для случайных чисел
	public static int randInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}
}