package service;

public class UserInput {
    public static boolean checkStuInfoFormat(String inputInfo) {
        return inputInfo.matches("^[\u4e00-\u9fa5]{2,4}，[0-9]{4}，([\u4e00-\u9fa5]{2}：[0-9]{1,2}[0]?，?)+$");
    }

    public static boolean checkStuIdFormat(String inputId) {
        return inputId.matches("^([0-9]{4}，?)+$");
    }
}
