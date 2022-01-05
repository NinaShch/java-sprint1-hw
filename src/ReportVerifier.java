public class ReportVerifier {

    /**
     * @param monthlyReports
     * @param yearlyReport
     * @return месяц, данные по которому не сходятся с годовым отчетом, или ноль если сверка данных
     * завершена успешно
     */
    public int getMonthWithError(MonthlyReport[] monthlyReports, YearlyReport yearlyReport) {
        for (int i = 0; i < yearlyReport.getNumberOfLinesYearlyReport(); i += 2) {
            boolean isExpense = yearlyReport.getYearlyReportLine(i).isExpense;
            int monthExpenses = monthIncomesAndExpenses(monthlyReports[i / 2])[1];
            int monthIncomes = monthIncomesAndExpenses(monthlyReports[i / 2])[0];

            if (isExpense &&
                    (yearlyReport.getYearlyReportLine(i).amount != monthExpenses ||
                            yearlyReport.getYearlyReportLine(i + 1).amount != monthIncomes)) {
                return i / 2 + 1;
            } else {
                if (!isExpense &&
                        (yearlyReport.getYearlyReportLine(i).amount != monthIncomes ||
                                yearlyReport.getYearlyReportLine(i + 1).amount != monthExpenses)) {
                    return i / 2 + 1;
                }
            }
        }
        return 0;
    }

    public int[] monthIncomesAndExpenses(MonthlyReport monthlyReport) {
        /*
         * создаем массив из двух чисел где первое это доходы за месяц, второе - расходы
         */
        int[] incomesAndExpenses = new int[2];

        for (int i = 0; i < monthlyReport.getNumberOfReports(); i++) {
            if (monthlyReport.getMonthlyReportLine(i).isExpense) {
                incomesAndExpenses[1] += monthlyReport.getMonthlyReportLine(i).sumOfOne
                        * monthlyReport.getMonthlyReportLine(i).quantity;
            } else {
                incomesAndExpenses[0] += monthlyReport.getMonthlyReportLine(i).sumOfOne
                        * monthlyReport.getMonthlyReportLine(i).quantity;
            }
        }
        return incomesAndExpenses;
    }
}