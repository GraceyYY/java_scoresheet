package service;

import java.util.Scanner;

public class Menu {
    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：");
        int menu = scanner.nextInt();
        switch (menu) {
            case 1: {
                System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
                String input = scanner.next();
                while (!UserInput.checkStuInfoFormat(input)) {
                    System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
                    input = scanner.next();
                }
                //TODO:process the input
                Menu.showMenu();
                break;
            }
            case 2: {
                System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
                String input = scanner.next();
                while (!UserInput.checkStuIdFormat(input)) {
                    System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
                    input = scanner.next();
                }
                //TODO:print the scoresheet
                Menu.showMenu();
                break;
            }
            case 3:
                break;
        }
    }
}
