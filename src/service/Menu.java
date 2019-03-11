package service;

import model.TheClass;
import tools.Print;

import java.util.List;
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
                Print.showInfoFormat();
                String input = scanner.next();
                while (!UserInput.checkStuInfoFormat(input)) {
                    Print.showInfoFormatErrorHint();
                    input = scanner.next();
                }
                UserInput.processInfoInput(klass,input);
                Menu.showMenu();
                break;
            }
            case 2: {
                Print.showIdFormat();
                String input = scanner.next();
                while (!UserInput.checkStuIdFormat(input)) {
                    Print.showIdFormatErrorHint();
                    input = scanner.next();
                }
                String[] subjects = {"数学","语文","英语","编程"};
                Scoresheet scoresheet = new Scoresheet(subjects);
                List<String> ids = UserInput.processIdInput(klass,input);
                Print.printScoresheet(scoresheet.generateScoresheet(ids,klass));
                Menu.showMenu();
                break;
            }
            case 3:
                break;
        }
    }
}
