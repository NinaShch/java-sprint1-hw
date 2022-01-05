import java.io.IOException;
import java.util.ArrayList;

public class MonthlyReport {
    final static String monthReportPath = "resources/m.20210%d.csv";
    private final ArrayList<ItemInfo> data;

    /**
     * чтение данных из отчетов по месяцам
     */
    public MonthlyReport(int monthNumber, FileReader fileReader) throws IOException {
        data = fileReader.createMonthReport(String.format(monthReportPath, monthNumber));
    }

    public int getNumberOfReports() {
        return data.size();
    }

    public ItemInfo getMonthlyReportLine(int i) {
        return data.get(i);
    }

}
