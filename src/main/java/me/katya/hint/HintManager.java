package me.katya.hint;

import java.util.Random;

public class HintManager implements Hint{
	@Override
	public String getHintMessage(int target) {
		Random random = new Random();
		int hintType = random.nextInt(10); // Случайный выбор типа подсказки

		switch (hintType) {
			case 0:
				return "Подсказка: загаданное число оставляет остаток " + (target % 7) + " при делении на 7.";
			case 1:
				return "Подсказка: сумма цифр загаданного числа больше " + ((target % 10) + random.nextInt(5)) + ".";
			case 2:
				return "Подсказка: загаданное число больше, чем " + (target - random.nextInt(10)) + ", но меньше, чем " + (target + random.nextInt(10)) + ".";
			case 3:
				return "Подсказка: квадрат загаданного числа делённый на 50 больше " + (target * target / 50 - random.nextInt(5)) + ".";
			case 4:
				return "Подсказка: удвоенная разность загаданного числа и 50 примерно равна " + ((target - 50) * 2 + random.nextInt(3) - 1) + ".";
			case 5:
				return "Подсказка: произведение загаданного числа и 3 больше " + (target * 3 - random.nextInt(15)) + ", но меньше " + (target * 3 + random.nextInt(15)) + ".";
			case 6:
				return "Подсказка: остаток от деления на число π" + target % Math.PI;
			case 7:
				return "Подсказка: загаданное число ближе к " + (target + random.nextInt(20) - 10) + ", чем к " + (target + random.nextInt(50) - 25) + ".";
			case 8:
				return "Подсказка: при умножении загаданного числа на 2 и вычитании 30 результат больше " + ((target * 2 - 30) - random.nextInt(10)) + ".";
			case 9:
				return "Подсказка: число в 3 раза больше загаданного ближе к " + (target * 3 + random.nextInt(20) - 10) + ", чем к " + (target * 3 + random.nextInt(50) - 25) + ".";
			default:
				return "Подсказка: загадка пока недоступна.";
		}
	}
}
