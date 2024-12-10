package finalProj;

public class Liabilities {
	public static float computeTotalLiabilities() {

	    return Titles.notesPayable + Titles.accountsPayable + Titles.accruedSalariesAndWages + Titles.accruedInterestPayable
	        + Titles.accruedTaxesPayable + Titles.otherAccruedLiabilities + Titles.unearnedRentIncome
	        + Titles.unearnedCommissionIncome + Titles.unearnedInterestIncome + Titles.withholdingTaxPayable
	        + Titles.medicareContributionsPayable + Titles.pagIbigContributionsPayable + Titles.sssContributionsPayable
	        + Titles.mortgagePayable + Titles.loansPayable + Titles.bondsPayable;
	}

}
