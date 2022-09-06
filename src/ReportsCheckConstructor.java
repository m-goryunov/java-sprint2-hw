public class ReportsCheckConstructor {
    int month;
    int itemValueSumExp;
    int itemValueSumInc;

    public ReportsCheckConstructor(int month, int itemValueSumExp, int itemValueSumInc) {
        this.month = month;
        this.itemValueSumExp = itemValueSumExp;
        this.itemValueSumInc = itemValueSumInc;
    }

    @Override
    public String toString() {
        return "{" +
                "month=" + month +
                ", itemValueSumExp=" + itemValueSumExp +
                ", itemValueSumInc=" + itemValueSumInc +
                '}';
    }
}