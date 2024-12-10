package finalProj;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class GUI extends JFrame {

	public static float totalAssets;
	public static float totalLiabilities;
	public static float totalRevenues;
	public static float totalOperatingExpenses;
	public static float totalCapital;
	public static float totalCOGS;
	public static float netIncome;
	public static float equity;
    public GUI() {
        setTitle("Accounting System - Input Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setResizable(false);
        setLayout(null); // No layout manager, manual positioning

        // Tab for each accounting category
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(20, 20, 1150, 650); // Positioning the tabbed pane
        add(tabbedPane);

        // Add tabs
        tabbedPane.addTab("Assets", createAssetsPanel());
        tabbedPane.addTab("Liabilities", createLiabilitiesPanel());
        tabbedPane.addTab("Capital", createCapitalPanel());
        tabbedPane.addTab("Revenues", createRevenuePanel());
        tabbedPane.addTab("Cost of Goods Sold", createCOGPanel());
        tabbedPane.addTab("Operating Expenses", createExpensesPanel());

        // Navigation Buttons
        JButton nextButton = new JButton("Next");
        nextButton.setBounds(900, 700, 100, 30); // Position for Next button
     // In your nextButton ActionListener
        nextButton.addActionListener(e -> {
        	calculate();
        	prints();

        	new ResultsFrame(); // Open the results window
        });


        add(nextButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(1020, 700, 100, 30); // Position for Exit button
        exitButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        add(exitButton);

        setVisible(true);
    }

    // Helper method to create text fields with consistent size and event listeners to store values
    public JTextField createTextField(int x, int y, FloatFieldUpdater updater) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 200, 25);
        textField.addActionListener(e -> {
            try {
                float value = Float.parseFloat(textField.getText());
                updater.update(value);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid number.");
                textField.setText("");
            }
        });
        return textField;
    }


    // Functional interface to update the float value
    interface FloatFieldUpdater {
        void update(float value);
    }

    // Panel for Assets
    public JPanel createAssetsPanel() {
        JPanel panel = new JPanel(null); // No layout manager for manual positioning
        int xLabel = 20, y = 20, spacing = 40;

        panel.add(createLabel("Petty Cash:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value -> Titles.pettyCash = value));
        y += spacing;

        panel.add(createLabel("Cash on Hand:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.cashOnHand = value));
        y += spacing;

        panel.add(createLabel("Cash in Bank:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.cashInBank = value));
        y += spacing;

        panel.add(createLabel("Notes Receivable:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.notesReceivable = value));
        y += spacing;

        panel.add(createLabel("Accounts Receivable:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.accountsReceivable = value));
        y += spacing;

        panel.add(createLabel("Allowance for Doubtful Accounts:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.allowanceForDoubtfulAccounts = value));
        y += spacing;

        panel.add(createLabel("Interest Receivable:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.interestReceivable = value));
        y += spacing;

        panel.add(createLabel("Merchandise Inventory:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.merchandiseInventory = value));
        y += spacing;

        panel.add(createLabel("Prepaid Rent:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.prepaidRent = value));
        y += spacing;

        panel.add(createLabel("Prepaid Insurance:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.prepaidInsurance = value));
        y += spacing;

        panel.add(createLabel("Unused Supplies:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.unusedSupplies = value));
        y += spacing;

        panel.add(createLabel("Miscellaneous Prepaid Expenses:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.miscellaneousPrepaidExpenses = value)); 
        y += spacing;
        
        panel.add(createLabel("Investment in Stocks:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.investmentInStocks = value));
        y += spacing;

        panel.add(createLabel("Investment in Bonds:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.investmentInBonds = value));
        y += spacing;

        panel.add(createLabel("Land:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.land = value));
        y += spacing;

        panel.add(createLabel("Building:", y, xLabel));
        panel.add(createTextField(y + 250, xLabel, value ->  Titles.building = value));
        xLabel += spacing;

        panel.add(createLabel("Accumulated Depreciation-Building:",y, xLabel));
        panel.add(createTextField(y + 250, xLabel, value ->  Titles.accumulatedDepreciationBuilding = value));
        xLabel += spacing;

        panel.add(createLabel("Equipment:", y, xLabel));
        panel.add(createTextField(y + 250, xLabel, value ->  Titles.equipment = value));
        xLabel += spacing;

        panel.add(createLabel("Accumulated Depreciation-Equipment:",y, xLabel));
        panel.add(createTextField(y + 250, xLabel, value ->  Titles.accumulatedDepreciationEquipment = value));
        xLabel += spacing;

        panel.add(createLabel("Furniture and Fixtures:", y, xLabel));
        panel.add(createTextField(y + 250, xLabel, value ->  Titles.furnitureAndFixtures = value));
        xLabel += spacing;

        panel.add(createLabel("Accumulated Depreciation-F and F:", y, xLabel));
        panel.add(createTextField(y + 250, xLabel, value ->  Titles.accumulatedDepreciationFurnitureAndFixtures = value));
        xLabel += spacing;

        panel.add(createLabel("Tools:", y, xLabel));
        panel.add(createTextField(y + 250, xLabel, value ->  Titles.tools = value));
        xLabel += spacing;

        panel.add(createLabel("Franchise:", y, xLabel));
        panel.add(createTextField(y + 250, xLabel, value ->  Titles.franchise = value));
        xLabel += spacing;

        panel.add(createLabel("Trademark:", y, xLabel));
        panel.add(createTextField(y + 250, xLabel, value ->  Titles.trademark = value));
        xLabel += spacing;

        panel.add(createLabel("Patent:", y, xLabel));
        panel.add(createTextField(y + 250, xLabel, value ->  Titles.patent = value));
        xLabel += spacing;

        return panel;
    }

    // Panel for Liabilities
    public JPanel createLiabilitiesPanel() {
        JPanel panel = new JPanel(null);
        int xLabel = 20, y = 20, spacing = 40;

        panel.add(createLabel("Notes Payable:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.notesPayable = value));
        y += spacing;

        panel.add(createLabel("Accounts Payable:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.accountsPayable = value));
        y += spacing;

        panel.add(createLabel("Accrued Salaries and Wages:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.accruedSalariesAndWages = value));
        y += spacing;

        panel.add(createLabel("Accrued Interest Payable:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.accruedInterestPayable = value));
        y += spacing;

        panel.add(createLabel("Accrued Taxes Payable:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.accruedTaxesPayable = value));
        y += spacing;

        panel.add(createLabel("Other Accrued Liabilities:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.otherAccruedLiabilities = value));
        y += spacing;

        panel.add(createLabel("Unearned Rent Income:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.unearnedRentIncome = value));
        y += spacing;

        panel.add(createLabel("Unearned Commission Income:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.unearnedCommissionIncome = value));
        y += spacing;

        panel.add(createLabel("Unearned Interest Income:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.unearnedInterestIncome = value));
        y += spacing;

        panel.add(createLabel("Withholding Tax Payable:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.withholdingTaxPayable = value));
        y += spacing;

        panel.add(createLabel("Medicare Contributions Payable:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.medicareContributionsPayable = value));
        y += spacing;

        panel.add(createLabel("Pag-ibig Contributions Payable:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.pagIbigContributionsPayable = value));
        y += spacing;

        panel.add(createLabel("SSS Contributions Payable:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.sssContributionsPayable = value));
        y += spacing;

        panel.add(createLabel("Mortgage Payable:", y, xLabel));
        panel.add(createTextField(y + 250, xLabel, value ->  Titles.mortgagePayable = value));
        xLabel += spacing;

        panel.add(createLabel("Loans Payable:", y, xLabel));
        panel.add(createTextField(y + 250, xLabel, value ->  Titles.loansPayable = value));
        xLabel += spacing;

        panel.add(createLabel("Bonds Payable:", y, xLabel));
        panel.add(createTextField(y + 250, xLabel, value ->  Titles.bondsPayable = value));
        xLabel += spacing;
        return panel;
    }

    // Panel for Capital
    public JPanel createCapitalPanel() {
        JPanel panel = new JPanel(null);
        int xLabel = 20, y = 20, spacing = 40;

        panel.add(createLabel("Proprietor Capital:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.proprietorCapital = value));
        y += spacing;

        panel.add(createLabel("Proprietor Drawing:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.proprietorDrawing = value));
        y += spacing;

        return panel;
    }

    // Panel for Revenues
    public JPanel createRevenuePanel() {
        JPanel panel = new JPanel(null);
        int xLabel = 20, y = 20, spacing = 40;

        panel.add(createLabel("Sales:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value -> Titles.sales = value));
        y += spacing;

        panel.add(createLabel("Sales Returns and Allowances:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.salesReturnsAndAllowances = value));
        y += spacing;

        panel.add(createLabel("Sales Discount:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.salesDiscount = value));
        y += spacing;

        panel.add(createLabel("Interest Income:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.interestIncome = value));
        y += spacing;

        panel.add(createLabel("Rent Income:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.rentIncome = value));
        y += spacing;

        panel.add(createLabel("Commission Income:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.commissionIncome = value));
        y += spacing;
        
        panel.add(createLabel("service Income:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.serviceIncome = value));
        y += spacing;


        return panel;
    }

    // Panel for Cost of Goods Sold (COG)
    public JPanel createCOGPanel() {
        JPanel panel = new JPanel(null);
        int xLabel = 20, y = 20, spacing = 40;

        panel.add(createLabel("Purchases:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.purchases = value));
        y += spacing;

        panel.add(createLabel("Purchase Returns and Allowances:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.purchaseReturnsAndAllowances = value));
        y += spacing;

        panel.add(createLabel("Purchase Discount:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.purchaseDiscount = value));
        y += spacing;

        panel.add(createLabel("Merchandise Inventory (beginning):", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.merchandiseInventoryBegin = value));
        y += spacing;

        panel.add(createLabel("Merchandise Inventory (end):", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.merchandiseInventoryEnd = value));
        y += spacing;

        panel.add(createLabel("Freight In:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.freightIn = value));
        y += spacing;

        return panel;
    }

    // Panel for Operating Expenses
    public JPanel createExpensesPanel() {
        JPanel panel = new JPanel(null);
        int xLabel = 20, y = 20, spacing = 40;

        panel.add(createLabel("Salary Expense:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value -> Titles.salaryExpense = value));
        y += spacing;

        panel.add(createLabel("Freight Out:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.freightOut = value));
        y += spacing;

        panel.add(createLabel("Advertising Expense:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.advertisingExpense = value));
        y += spacing;

        panel.add(createLabel("Bad Debt Expense:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.badDebtExpense = value));
        y += spacing;

        panel.add(createLabel("Depreciation Expense:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.depreciationExpense = value));
        y += spacing;

        panel.add(createLabel("Supplies Expense:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.suppliesExpense = value));
        y += spacing;

        panel.add(createLabel("Commission Expense:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.commissionExpense = value));
        y += spacing;

        panel.add(createLabel("Insurance Expense:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.insuranceExpense = value));
        y += spacing;

        panel.add(createLabel("Rent Expense:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.rentExpense = value));
        y += spacing;

        panel.add(createLabel("Light and Water Expense:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.lightAndWaterExpense = value));
        y += spacing;

        panel.add(createLabel("Taxes and Licenses:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.taxesAndLicenses = value));
        y += spacing;

        panel.add(createLabel("Repairs and Maintenance:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.repairsAndMaintenance = value));
        y += spacing;

        panel.add(createLabel("Communication Expense:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.communicationExpense = value));
        y += spacing;

        panel.add(createLabel("Miscellaneous Expense:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.miscellaneousExpense = value));
        y += spacing;

        panel.add(createLabel("Interest Expense:", xLabel, y));
        panel.add(createTextField(xLabel + 200, y, value ->  Titles.interestExpense = value));
        y += spacing;

        return panel;
    }

    // Helper method to create labels
    public JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 250, 25); // Positioning labels
        return label;
    }
    
    public void calculate() {
     totalAssets = Assets.computeTotalAssets();
   	 totalLiabilities = Liabilities.computeTotalLiabilities();
     totalRevenues = Revenues.computeTotalRevenues();
     totalOperatingExpenses = OperatingExpenses.computeOperatingExpense();
     totalCapital = Capital.computeTotalCapital();
     totalCOGS = CostOfGoodsSold.computeCOGS();
     equity = totalAssets - totalLiabilities;
     netIncome = totalRevenues - totalOperatingExpenses;

    }
    public static void prints() {
    	 
    	System.out.println("Total Assets :₱" + totalAssets);

    	System.out.println("Total Liabilites :₱" + totalLiabilities);

        System.out.println("Total Revenues :₱" + totalRevenues);

        System.out.println("Total Operating Expenses :₱" + totalOperatingExpenses);

        System.out.println("Total Capital :₱" + totalCapital);

        System.out.println("Cost of Goods Sold :₱" + totalCOGS);
        
        System.out.println("\n--- Balance Sheet ---");
        System.out.println("Assets :₱" + totalAssets);
        System.out.println("Liabilities :₱" + totalLiabilities);
        System.out.println("Equity :₱" + equity);
        

        System.out.println("\n--- Income Statement ---");
        System.out.println("Total Revenues :₱" + totalRevenues);
        System.out.println("Total Operating Expenses :₱" + totalOperatingExpenses);
        System.out.println("Net Income :₱" + netIncome + "\n");
    }


    public static void main(String[] args) {

    	
        new GUI();
    }
}