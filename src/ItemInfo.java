import java.util.Objects;

/**
 * Дата-класс в котором хранятся данные об одной строке дохода или одной строке трат из месячного отчета
 */
public class ItemInfo {
    String itemName;
    Boolean isExpense;
    Integer quantity;
    Integer sumOfOne;

    public ItemInfo(String itemName, Boolean isExpense, Integer quantity, Integer sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemInfo itemInfo = (ItemInfo) o;
        return Objects.equals(itemName, itemInfo.itemName) && Objects.equals(isExpense, itemInfo.isExpense) &&
                Objects.equals(quantity, itemInfo.quantity) && Objects.equals(sumOfOne, itemInfo.sumOfOne);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, isExpense, quantity, sumOfOne);
    }
}
