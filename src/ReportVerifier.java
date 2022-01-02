public class ReportVerifier {

    public int reportVerifier(MonthlyReport[] monthlyReport, YearlyReport yearlyReport) {
        for (int i = 0; i < yearlyReport.yearReport.size(); i += 2) {
            if ((yearlyReport.yearReport.get(i).isExpense) &&
                    (yearlyReport.yearReport.get(i).amount != monthIncomesAndExpenses(monthlyReport[i / 2])[1] ||
                    yearlyReport.yearReport.get(i+1).amount != monthIncomesAndExpenses(monthlyReport[i / 2])[0])) {
                return i / 2 + 1 ;
            } else {
                if (!yearlyReport.yearReport.get(i).isExpense &&
                        (yearlyReport.yearReport.get(i).amount != monthIncomesAndExpenses(monthlyReport[i / 2])[0] ||
                        yearlyReport.yearReport.get(i+1).amount != monthIncomesAndExpenses(monthlyReport[i / 2])[1])) {
                    return i / 2 + 1 ;
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

        for (int i = 0; i < monthlyReport.data.size(); i++) {
            if (monthlyReport.data.get(i).isExpense) {
                incomesAndExpenses[1] += monthlyReport.data.get(i).sumOfOne * monthlyReport.data.get(i).quantity;
            } else {
                incomesAndExpenses[0] += monthlyReport.data.get(i).sumOfOne * monthlyReport.data.get(i).quantity;
            }
        }
        return incomesAndExpenses;
    }
}