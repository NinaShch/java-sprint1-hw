import java.util.ArrayList;

public class MonthlyReport {

    final static String monthReportPath = "resources/m.20210%d.csv";
    ArrayList <ItemInfo> data;
    FileReader fileReader = new FileReader();

    /**
     * чтение данных из отчетов по месяцам
     */
    public MonthlyReport (int monthNumber) {
        data = fileReader.createMonthReport(String.format(monthReportPath, monthNumber));
    }

}
