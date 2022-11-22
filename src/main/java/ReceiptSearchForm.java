import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceiptSearchForm {

    public ReceiptSearchForm() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(receiptSearch, "Not yet implemented");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ReceiptSearchFrame");
        frame.setContentPane(new ReceiptSearchForm().receiptSearch);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JButton searchButton;
    private JTextField enterKeywordsTextField;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JPanel receiptSearch;
}
