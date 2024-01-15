import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserInterface extends WorkWithFile{
    protected String[] userData() {
        String data;
        String[] dataForCheck;
        String[] result = new String[6];
        int counter = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите в любом порядке, через пробел, в одну строку, следующие данные:" +
                    "1) Ф.И.О в формате -> Фамилия,Имя,Отчетсво" +
                    "2) Дата рождения в формате -> 12.12.1900" +
                    "3) Номер телефона в формате -> 89000010101" +
                    "4) Ваш пол в формате -> f(женский), m(мужской)");
            data = scanner.nextLine();
        }
        dataForCheck = data.split(" ");
        if (dataForCheck.length != 4) {
            System.out.println("Вы ввели не все данные " + dataForCheck.length);
        } else {
            for (String dataCheck : dataForCheck) {
                if (dataCheck.split(",").length == 3)
                {
                    String[] tempData = dataCheck.split(",");
                    for (int i = 0; i < tempData.length; i++) {
                        result[i] = tempData[i] + ",";
                    }
                    counter++;
                }

                if (dataCheck.length() == 10) {
                    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                    try {
                        Date date = format.parse(dataCheck);
                        result[3] = format.format(date) + ",";
                    } catch (ParseException e) {
                        System.out.println("Вы ошиблись с вводом даты");
                    }
                }
                if (dataCheck.length() == 11)
                    try {
                        Long.parseLong(dataCheck);
                        result[4] = dataCheck + ",";
                    } catch (NumberFormatException e) {
                        System.out.println("Вы ошиблись при вводе номера телефона");
                    }
                if (dataCheck.length() == 1) {
                    char sex = dataCheck.charAt(0);
                    if (sex == 'm' || sex == 'f') {
                        result[5] = dataCheck;
                    } else {
                        System.out.println("Вы ошиблись при вводе пола");
                    }
                }
            }
        }
        if (counter == 0) {
            System.out.println("Вы ошиблись с вводом Ф.И.О.");
        }
        return result;
    }
}
