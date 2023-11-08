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
    private JLabel resultSearch;

    public JLabel getResultSearch() {
        return resultSearch;
    }

    public void setResultSearch(JLabel result) {
        this.resultSearch = result;
    }

    public Result() {
        setBorder(new TitledBorder(new EmptyBorder(1, 1, 1, 1), "Result:"));
    }
    public Result(String text) {
        setBorder(new TitledBorder(new EmptyBorder(1, 1, 1, 1), "Result:"));
        resultSearch = new JLabel(text);
        add(resultSearch);
    }

}
