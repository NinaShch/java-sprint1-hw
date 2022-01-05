import java.util.Map;

public class ReportAnalyzer {
    final static Map<Integer, String> monthName = Map.of(
            1, "Январь",
            2, "Февраль",
            3, "Март"
    );

    public void getMostSumItem (MonthlyReport monthlyReport, int monthNumber) {
        int maxIncome = 0;
        String itemNameIncome = "";
        int maxExpense = 0;
        String itemNameExpense = "";
        for (int i = 0; i < monthlyReport.getNumberOfReports(); i++) {
            if (monthlyReport.getMonthlyReportLine(i).isExpense) {
                if (monthlyReport.getMonthlyReportLine(i).quantity
                        * monthlyReport.getMonthlyReportLine(i).sumOfOne > maxExpense) {
                    maxExpense = monthlyReport.getMonthlyReportLine(i).quantity
                            * monthlyReport.getMonthlyReportLine(i).sumOfOne;
                    itemNameExpense = monthlyReport.getMonthlyReportLine(i).itemName;
                }

            } else {
                if (monthlyReport.getMonthlyReportLine(i).quantity
                        * monthlyReport.getMonthlyReportLine(i).sumOfOne > maxIncome) {
                    maxIncome = monthlyReport.getMonthlyReportLine(i).quantity
                            * monthlyReport.getMonthlyReportLine(i).sumOfOne;
                    itemNameIncome = monthlyReport.getMonthlyReportLine(i).itemName;
                }
            }
        }
        System.out.println("Отчет за " + monthName.get(monthNumber));
        System.out.println("Самый прибыльный товар: " + itemNameIncome + ". Сумма выручки составила " +
                maxIncome + ".");
        System.out.println("Самая большая трата: " + itemNameExpense + ". Сумма расходов " +
                maxExpense + ".");
        System.out.println();

    }

    public void yearAnalyzer(YearlyReport yearlyReport) {
        int monthQuantity = 0;
        int totalExpense = 0;
        int totalIncome = 0;
        int monthProfit;
        System.out.println(YearlyReport.YEAR + " год");
        for (int i = 0; i < yearlyReport.getNumberOfLinesYearlyReport() / 2; i++) {
            monthQuantity += 1;
            if (yearlyReport.getYearlyReportLine(i * 2).isExpense) {
                totalExpense += yearlyReport.getYearlyReportLine(i * 2).amount;
                totalIncome += yearlyReport.getYearlyReportLine(i * 2 + 1).amount;
                monthProfit = yearlyReport.getYearlyReportLine(i * 2 + 1).amount
                        - yearlyReport.getYearlyReportLine(i * 2).amount;
            } else {
                totalIncome += yearlyReport.getYearlyReportLine(i * 2).amount;
                totalExpense += yearlyReport.getYearlyReportLine(i * 2 + 1).amount;
                monthProfit = yearlyReport.getYearlyReportLine(i * 2).amount
                        - yearlyReport.getYearlyReportLine(i * 2 + 1).amount;
            }
            System.out.println("Прибыль за " + monthName.get(monthQuantity) + " - " + monthProfit);
        }
        double averageExpense = totalExpense / (double) monthQuantity;
        double averageIncome = totalIncome / (double) monthQuantity;
        System.out.printf("Средний расход за все месяцы %.2f%n", averageExpense);
        System.out.printf("Средний доход за все месяцы %.2f%n", averageIncome);
        System.out.println();
    }
}
