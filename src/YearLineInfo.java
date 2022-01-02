import java.util.Objects;

/**
 * Дата-класс в котором хранится информация об одной строке годового отчета
 */

public class YearLineInfo {
    Integer month;
    Integer amount;
    Boolean isExpense;

    public YearLineInfo(Integer month, Integer amount, Boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YearLineInfo that = (YearLineInfo) o;
        return Objects.equals(month, that.month) && Objects.equals(amount, that.amount) && Objects.equals(isExpense, that.isExpense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, amount, isExpense);
    }
}
