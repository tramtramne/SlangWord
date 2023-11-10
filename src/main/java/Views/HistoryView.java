/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 08/11/2023 - 14:41
 */
package Views;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class HistoryView extends JPanel{
    JTextArea historyText;

    public void setHistoryText(String historyText) {
        this.historyText.setText(historyText);
    }

    public JTextArea getHistoryText() {
        return historyText;
    }

    public HistoryView() {
        setLayout(new BorderLayout());

        JPanel history = new JPanel();

        history.setBorder(new CompoundBorder(new TitledBorder("History"), new EmptyBorder(6, 12, 12, 12)));
        historyText = new JTextArea(20, 50);
        historyText.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historyText);
        history.add(scrollPane, BorderLayout.CENTER);

        add(history, BorderLayout.CENTER);
    }


}
