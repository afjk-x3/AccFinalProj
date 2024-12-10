package finalProj;

public class OperatingExpenses {
    public static float computeOperatingExpense() {
        return Titles.salaryExpense + Titles.freightOut + Titles.advertisingExpense + Titles.badDebtExpense + Titles.depreciationExpense
            + Titles.suppliesExpense + Titles.commissionExpense + Titles.insuranceExpense + Titles.rentExpense
            + Titles.lightAndWaterExpense + Titles.taxesAndLicenses + Titles.repairsAndMaintenance
            + Titles.communicationExpense + Titles.miscellaneousExpense + Titles.interestExpense;
    }

}
