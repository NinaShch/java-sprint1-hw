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
        String itemNameExpense ="";
        for (int i = 0; i < monthlyReport.data.size(); i++) {
            if (monthlyReport.data.get(i).isExpense) {
                if (monthlyReport.data.get(i).quantity*monthlyReport.data.get(i).sumOfOne > maxExpense) {
                    maxExpense = monthlyReport.data.get(i).quantity*monthlyReport.data.get(i).sumOfOne;
                    itemNameExpense = monthlyReport.data.get(i).itemName;
                }

            } else {
                if (monthlyReport.data.get(i).quantity*monthlyReport.data.get(i).sumOfOne > maxIncome) {
                    maxIncome = monthlyReport.data.get(i).quantity*monthlyReport.data.get(i).sumOfOne;
                    itemNameIncome = monthlyReport.data.get(i).itemName;
                }
            }
        }
        System.out.println("Отчет за "+monthName.get(monthNumber));
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
        System.out.println(YearlyReport.year+" год");
        for (int i = 0; i < yearlyReport.yearReport.size()/2; i++) {
            monthQuantity += 1;
            if (yearlyReport.yearReport.get(i * 2).isExpense) {
                totalExpense += yearlyReport.yearReport.get(i * 2).amount;
                totalIncome += yearlyReport.yearReport.get(i * 2 + 1).amount;
                monthProfit = yearlyReport.yearReport.get(i * 2 + 1).amount - yearlyReport.yearReport.get(i * 2).amount;
            } else {
                totalIncome += yearlyReport.yearReport.get(i * 2).amount;
                totalExpense += yearlyReport.yearReport.get(i * 2 + 1).amount;
                monthProfit = yearlyReport.yearReport.get(i * 2).amount - yearlyReport.yearReport.get(i * 2 + 1).amount;
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
