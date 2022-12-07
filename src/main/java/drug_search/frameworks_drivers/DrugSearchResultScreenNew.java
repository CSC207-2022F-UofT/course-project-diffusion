package drug_search.frameworks_drivers;

import drug_search.use_case.DrugRequestDBEntry;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.time.LocalDateTime;
import java.util.List;

public class DrugSearchResultScreenNew extends JPanel {
    public DrugSearchResultScreenNew(List<DrugRequestDBEntry> entries) {
        drugSearchResultTable = new JTable(new DrugSearchResultTableModel(entries));
        JScrollPane scroller = new JScrollPane(drugSearchResultTable);

        add(scroller);
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

        public int getRowCount() {
            return data.length;
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
    }
}
