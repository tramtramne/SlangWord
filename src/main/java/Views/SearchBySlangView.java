/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 07/11/2023 - 23:13
 */
package Views;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SearchBySlangView extends JPanel{
    Search search;
    Result result;
    public SearchBySlangView() {
        setBorder(new EmptyBorder(8, 8, 8, 8));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;

        // Create a new Search object
        search = new Search("Input slang word");
        search.setBorder(new CompoundBorder(new TitledBorder("Search"), new EmptyBorder(4, 4, 4, 4)));
        add(search,gbc);
        gbc.gridy++;

        // Create a new Result object
        result = new Result();
        result.setBorder(new CompoundBorder(new TitledBorder("Result"), new EmptyBorder(6, 6, 6, 6)));


        add(result,gbc);
    }

    public Result getResult() {
        return this.result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }
}

