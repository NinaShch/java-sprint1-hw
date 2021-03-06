import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport[] monthlyReports = null;
        YearlyReport yearlyReport = null;
        ReportAnalyzer reportAnalyzer = new ReportAnalyzer();
        FileReader fileReader = new FileReader();
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            ReportVerifier reportVerifier;

            if (command == 1) {
                try {
                    monthlyReports = new MonthlyReport[3];
                    for (int i = 0; i < 3; i++) {
                        monthlyReports[i] = new MonthlyReport(i + 1, fileReader);
                    }
                    System.out.println("Месячные отчеты успешно считаны");
                } catch (IOException e) {
                    System.out.println("Невозможно прочитать файл с отчётом. " +
                            "Возможно, файл не находится в нужной директории.");
                    monthlyReports = null;
                }
            } else if (command == 2) {
                try {
                    yearlyReport = new YearlyReport(fileReader);
                    System.out.println("Годовой отчет успешно считан");
                } catch (IOException e) {
                    System.out.println("Невозможно прочитать файл с отчётом. " +
                            "Возможно, файл не находится в нужной директории.");
                    yearlyReport = null;
                }
            } else if (command == 3) {
                reportVerifier = new ReportVerifier();
                if (monthlyReports == null || yearlyReport == null) {
                    System.out.println("Отчеты не были считаны");
                    continue;
                }
                int result = reportVerifier.getMonthWithError(monthlyReports, yearlyReport);
                if (result == 0) {
                    System.out.println("Операция успешно завершена");
                } else {
                    System.out.println("Ошибка в отчете за " + ReportAnalyzer.monthName.get(result));
                }
            } else if (command == 4) {
                if (monthlyReports == null) {
                    System.out.println("Месячные отчеты не были считаны");
                    continue;
                }
                for (int i = 0; i < monthlyReports.length; i++) {
                    reportAnalyzer.getMostSumItem(monthlyReports[i], i + 1);
                }
            } else if (command == 5) {
                if (yearlyReport == null) {
                    System.out.println("Годовой отчет не был считан");
                    continue;
                }
                reportAnalyzer.yearAnalyzer(yearlyReport);
            } else if (command == 6) {
                break;
            } else {
                System.out.println("Извините, такой команды нет. Введите другую комманду.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Считать все месячные отчёты");
        System.out.println("2. Считать годовой отчёт");
        System.out.println("3. Сверить отчёты");
        System.out.println("4. Вывести информацию о всех месячных отчётах");
        System.out.println("5. Вывести информацию о годовом отчёте");
        System.out.println("6. Выход");
    }
}
