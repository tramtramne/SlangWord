/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 08/11/2023 - 13:13
 */
package Views;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SearchByDefinitionView extends JPanel {
    private Search search;
    private Result result;

    public Result getResult() {
        return result;
    }

    public Search getSearch() {
        return search;
    }

    public SearchByDefinitionView() {
        setBorder(new EmptyBorder(8, 8, 8, 8));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;

        // Create a new Search object
        search = new Search("Input definition: ");
        search.setBorder(new CompoundBorder(new TitledBorder("Search"), new EmptyBorder(4, 4, 4, 4)));
        add(search,gbc);
        gbc.gridy++;

        // Create a new Result object
        result = new Result();
        result.setBorder(new CompoundBorder(new TitledBorder("Result"), new EmptyBorder(6, 6, 6, 6)));

        add(result,gbc);
    }
}
