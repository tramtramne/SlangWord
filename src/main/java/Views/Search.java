/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 08/11/2023 - 01:18
 */
package Views;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Search extends JPanel {

    private JTextField searchField;
    private JButton searchButton;

    public Search(String text) {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel formatPane = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel slangWordLabel = new JLabel(text);
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(300, 25));
        searchButton = new JButton("Search");
        formatPane.add(slangWordLabel);
        formatPane.add(searchField);
        formatPane.add(searchButton);

        add(formatPane);
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }
}
