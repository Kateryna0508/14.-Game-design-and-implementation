package me.katya;
import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame implements Game { //"Мозг" игры

	private int targetNumber;      // Загаданное число
	private int attempts;          // Счетчик попыток

	public GuessNumberGame() {
		this.targetNumber = RandomUtils.randInt(1, 100);
		this.attempts = 0;
	}

	@Override
	public void start() {
		System.out.println("Добро пожаловать в игру 'Угадай число'!");
		System.out.println("Компьютер загадал число от 1 до 100. Попробуйте его угадать!");

		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.print("Введите ваше число: ");
				int guess = scanner.nextInt();
				attempts++;

				if (guess > targetNumber) {
					System.out.println("Загаданное число меньше.");
					giveHint(targetNumber);
				} else if (guess < targetNumber) {
					System.out.println("Загаданное число больше.");
					giveHint(targetNumber);
				} else {
					System.out.println("Поздравляю! Вы угадали число " + targetNumber + " за " + attempts + " попыток.");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Ошибка ввода. Пожалуйста, введите целое число.");
		}
	}

	private void giveHint(int target) {
		Random random = new Random();
		int hintType = random.nextInt(10); // Случайный выбор типа подсказки

		switch (hintType) {
			case 0:
				System.out.println("Подсказка: загаданное число оставляет остаток " + (target % 7) + " при делении на 7.");
				break;
			case 1:
				System.out.println("Подсказка: сумма цифр загаданного числа больше " + ((target % 10) + random.nextInt(5)) + ".");
				break;
			case 2:
				System.out.println("Подсказка: загаданное число больше, чем " + (target - random.nextInt(10)) + ", но меньше, чем " + (target + random.nextInt(10)) + ".");
				break;
			case 3:
				System.out.println("Подсказка: квадрат загаданного числа делённый на 50 больше " + (target * target / 50 - random.nextInt(5)) + ".");
				break;
			case 4:
				System.out.println("Подсказка: удвоенная разность загаданного числа и 50 примерно равна " + ((target - 50) * 2 + random.nextInt(3) - 1) + ".");
				break;
			case 5:
				System.out.println("Подсказка: произведение загаданного числа и 3 больше " + (target * 3 - random.nextInt(15)) + ", но меньше " + (target * 3 + random.nextInt(15)) + ".");
				break;
			case 6:
				System.out.println("Подсказка: остаток от деления загаданного числа на 10 больше " + (target % 10 - random.nextInt(2)) + ", но меньше " + (target % 10 + random.nextInt(2)) + ".");
				break;
			case 7:
				System.out.println("Подсказка: загаданное число ближе к " + (target + random.nextInt(20) - 10) + ", чем к " + (target + random.nextInt(50) - 25) + ".");
				break;
			case 8:
				System.out.println("Подсказка: при умножении загаданного числа на 2 и вычитании 30 результат больше " + ((target * 2 - 30) - random.nextInt(10)) + ".");
				break;
			case 9:
				System.out.println("Подсказка: число в 3 раза больше загаданного ближе к " + (target * 3 + random.nextInt(20) - 10) + ", чем к " + (target * 3 + random.nextInt(50) - 25) + ".");
				break;
			default:
				System.out.println("Подсказка: загадка пока недоступна.");
				break;
		}
	}
}
