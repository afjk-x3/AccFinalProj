package finalProj;

import javax.swing.*;
import java.awt.*;

public class ResultsFrame extends JFrame {

    public ResultsFrame() {
        setTitle("Accounting System - Results");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(new GridLayout(0, 1, 10, 10));

        // Balance Sheet Section
        JPanel balanceSheetPanel = new JPanel();
        balanceSheetPanel.setLayout(new GridLayout(3, 2, 5, 5));
        balanceSheetPanel.setBorder(BorderFactory.createTitledBorder("Balance Sheet"));

        balanceSheetPanel.add(new JLabel("Assets:"));
        balanceSheetPanel.add(new JLabel("₱" + String.format("%.2f", GUI.totalAssets)));
        balanceSheetPanel.add(new JLabel("Liabilities:"));
        balanceSheetPanel.add(new JLabel("₱" + String.format("%.2f", GUI.totalLiabilities)));
        balanceSheetPanel.add(new JLabel("Equity:"));
        balanceSheetPanel.add(new JLabel("₱" + String.format("%.2f", GUI.equity)));

        // Income Statement Section
        JPanel incomeStatementPanel = new JPanel();
        incomeStatementPanel.setLayout(new GridLayout(3, 2, 5, 5));
        incomeStatementPanel.setBorder(BorderFactory.createTitledBorder("Income Statement"));

        incomeStatementPanel.add(new JLabel("Total Revenues:"));
        incomeStatementPanel.add(new JLabel("₱" + String.format("%.2f", GUI.totalRevenues)));
        incomeStatementPanel.add(new JLabel("Total Operating Expenses:"));
        incomeStatementPanel.add(new JLabel("₱" + String.format("%.2f", GUI.totalOperatingExpenses)));
        incomeStatementPanel.add(new JLabel("Net Income:"));
        incomeStatementPanel.add(new JLabel("₱" + String.format("%.2f", GUI.netIncome))); 

        resultsPanel.add(balanceSheetPanel);
        resultsPanel.add(incomeStatementPanel);

        JScrollPane scrollPane = new JScrollPane(resultsPanel);
        add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        add(closeButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}
