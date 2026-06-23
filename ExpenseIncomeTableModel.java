/* Expense Tracker System */
package tracker;


import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;

public class ExpenseIncomeTableModel extends AbstractTableModel {
    private final List<ExpenseIncomeEntry> entries;
    private final String[] columnNames = {"Date", "Description", "Amount", "Type"};

    public ExpenseIncomeTableModel() {
        entries = new ArrayList<>();
    }

    public void addEntry(ExpenseIncomeEntry entry) {
        entries.add(entry);
        fireTableRowsInserted(entries.size() - 1, entries.size() - 1);
    }

    public void clearEntries() {
        entries.clear();
        fireTableDataChanged(); 
    }

    @Override
    public int getRowCount() {
        return entries.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ExpenseIncomeEntry entry = entries.get(rowIndex);
        switch (columnIndex) {
            case 0: return entry.getDate();
            case 1: return entry.getDescription();
            case 2: return String.format("%.2f", entry.getAmount());
            case 3: return entry.getType();
            default: return null;
        }
    }
}
