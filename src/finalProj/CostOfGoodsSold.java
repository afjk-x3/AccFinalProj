package finalProj;

public class CostOfGoodsSold {
    // Method to calculate cost of goods sold
    public static float computeCOGS() {
        return Titles.merchandiseInventoryBegin
                + Titles.purchases
                - Titles.purchaseReturnsAndAllowances
                - Titles.purchaseDiscount
                + Titles.freightIn
                - Titles.merchandiseInventoryEnd;
    }

}