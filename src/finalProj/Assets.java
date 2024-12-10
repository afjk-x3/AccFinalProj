package finalProj;

public class Assets {
    public static float computeTotalAssets() {
        return Titles.pettyCash + Titles.cashOnHand + Titles.cashInBank + Titles.notesReceivable 
            + (Titles.accountsReceivable - Titles.allowanceForDoubtfulAccounts)
            + Titles.interestReceivable + Titles.merchandiseInventory + Titles.prepaidRent + Titles.prepaidInsurance
            + Titles.unusedSupplies + Titles.miscellaneousPrepaidExpenses + Titles.investmentInStocks + Titles.investmentInBonds
            + Titles.land + (Titles.building - Titles.accumulatedDepreciationBuilding)
            + (Titles.equipment - Titles.accumulatedDepreciationEquipment) 
            + (Titles.furnitureAndFixtures - Titles.accumulatedDepreciationFurnitureAndFixtures) 
            + Titles.tools + Titles.franchise + Titles.trademark + Titles.patent;
    }
}
