/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 08/11/2023 - 13:26
 */
package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Result extends JPanel {
    private JTextArea resultSearch;

    public JTextArea getResultSearch() {
        return resultSearch;
    }

    public void setResultSearcsh(JTextArea result) {
        this.resultSearch = result;
    }

    public Result() {
        setBorder(new TitledBorder(new EmptyBorder(1, 1, 1, 1), "Result:"));
        resultSearch = new JTextArea(10,50);
        resultSearch.setEditable(false);
        resultSearch.setLineWrap(true);
        resultSearch.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(resultSearch);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane);
    }

}
