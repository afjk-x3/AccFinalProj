package finalProj;

public class Revenues {
    public static float computeTotalRevenues() {
        return (Titles.sales - Titles.salesReturnsAndAllowances - Titles.salesDiscount) 
            + Titles.interestIncome + Titles.rentIncome + Titles.serviceIncome + Titles.commissionIncome;
    }

}
