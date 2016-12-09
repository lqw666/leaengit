package Exam_12689_20161209_1;

import java.util.Scanner;

/**
 * 编程实现工资个人所得税
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入工资：");
		double salar = scanner.nextDouble();
		run(salar);
	}

	public static void run(double salar) {
		double result = 0;
		double x = salar - 3500;
		if (x < 0) {
			System.out.println("不需要缴纳税费");
		} else {
			if ((x < 1500) || (x == 1500)) {
				result = x * 0.03;
			} else if ((x < 4500) || (x == 4500)) {
				result = 1500 * 0.03 + (x - 1500) * 0.1;
			} else if ((x < 9000) || (x == 9000)) {
				result = 1500 * 0.03 + 3000 * 0.1 + (x - 4500) * 0.2;
			} else if ((x < 35000) || (x == 35000)) {
				result = 1500 * 0.03 + 3000 * 0.1 + 4500 * 0.2 + (x - 9000) * 0.25;
			} else if ((x < 55000) || (x == 80000)) {
				result = 1500 * 0.03 + 3000 * 0.1 + 4500 * 0.2 + 26000 * 0.25 + (x - 55000) * 0.35;
			} else {
				result = 1500 * 0.03 + 3000 * 0.1 + 4500 * 0.2 + 26000 * 0.25 + 25000 * 0.35 + (x - 80000) * 0.45;
			}
			System.out.println("所需要缴纳的税费为：" + result);
		}
	}
}
