package drug_search_frameworks_drivers;

import drug_search_entities.DrugRequestDBEntry;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.time.LocalDateTime;
import java.util.List;

public class DrugSearchResultScreen {
    public DrugSearchResultScreen(List<DrugRequestDBEntry> entries) {
        drugSearchResultTable.setModel(new DrugSearchResultTableModel(entries));
    }

    public JPanel getPanel() {
        return drugSearchResultPanel;
    }

    private String prettyPrintLocalDateTime(LocalDateTime dateTime) {
        return String.format("%s/%s/%s %s:%s:%s",
                dateTime.getDayOfMonth(),
                dateTime.getMonthValue(),
                dateTime.getYear(),
                dateTime.getHour(),
                dateTime.getMinute(),
                dateTime.getSecond());
    }

    private JPanel drugSearchResultPanel;
    private JTable drugSearchResultTable;
    private JScrollPane scroller;

    private class DrugSearchResultTableModel extends AbstractTableModel {
        public DrugSearchResultTableModel(List<DrugRequestDBEntry> entries) {
            data = new Object[entries.size()][6];

            int i = 0;

            for (DrugRequestDBEntry entry : entries) {
                data[i][0] = entry.getRequestId();
                data[i][1] = entry.getSiteId();
                data[i][2] = entry.getAccountId();
                data[i][3] = entry.getDrugName();
                data[i][4] = entry.getQuantity();
                data[i][5] = prettyPrintLocalDateTime(entry.getDate());

                i++;
            }
        }

        private String[] columnNames = {
                "Request ID",
                "Site ID",
                "Account ID",
                "Drug Name",
                "Quantity Requested",
                "Date Requested"
        };
        private Object[][] data;

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }
    }
}
