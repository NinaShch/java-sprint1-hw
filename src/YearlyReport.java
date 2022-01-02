import java.util.ArrayList;

public class YearlyReport {
    final static Integer year = 2021;
    final static String yearReportPath = "resources/y."+year+".csv";
    FileReader fileReader = new FileReader();
    ArrayList <YearLineInfo> yearReport;

    /**
     * чтение данных из годового отчета
     */
    public YearlyReport() {
        yearReport = fileReader.createYearReport(yearReportPath);
    }
}
