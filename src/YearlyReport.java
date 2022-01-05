import java.io.IOException;
import java.util.ArrayList;

public class YearlyReport {
    static final Integer YEAR = 2021;
    static final String YEAR_REPORT_PATH = "resources/y." + YEAR + ".csv";
    private final ArrayList<YearLineInfo> yearReport;

    /**
     * чтение данных из годового отчета
     */
    public YearlyReport(FileReader fileReader) throws IOException {
        yearReport = fileReader.createYearReport(YEAR_REPORT_PATH);
    }

    public int getNumberOfLinesYearlyReport() {
        return yearReport.size();
    }

    public YearLineInfo getYearlyReportLine(int i) {
        return yearReport.get(i);
    }
}
