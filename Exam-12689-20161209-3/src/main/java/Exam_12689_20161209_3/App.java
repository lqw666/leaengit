package Exam_12689_20161209_3;

import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 输入某年某月某日，判断这一天是这一年的第几天 平年2月28天，闰年2月29天。 年份数（末两位不是00）能被4整除的是闰年
 * 、年份数（末两位数是00的） 能被400整除是也是闰年
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("请输入日期：");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int days = 0;
		boolean flag = false;
		int year = Integer.parseInt(str.substring(0, 4));
		int month = Integer.parseInt(str.substring(5, 7));
		int day = Integer.parseInt(str.substring(8, 10));
		if ((year % 100) == 0) {
			if ((year % 400) == 0) {
				flag = true;
			}
		} else {
			if ((year % 4) == 0) {
				flag = true;
			}
		}

		for (int i = 1; i < month; i++) {
			switch (i) {
			case 1:
				days += 31;
				break;
			case 2:
				if (flag) {
					days += 29;
				} else {
					days += 28;
				}
				break;
			case 3:
				days += 31;
				break;
			case 4:
				days += 30;
			case 5:
				days += 31;
				break;
			case 6:
				days += 30;
				break;
			case 7:
				days += 31;
				break;
			case 8:
				days += 31;
				break;
			case 9:
				days += 30;
				break;
			case 10:
				days += 31;
				break;
			case 11:
				days += 30;
				break;
			}
		}
		days += day;
		System.out.println("你输入的日期为当年的第" + days + "天");
	}
}
