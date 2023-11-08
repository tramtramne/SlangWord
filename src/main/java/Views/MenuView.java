/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 05/11/2023 - 13:18
 */
package Views;

//        searchByDef = new JButton("Search by Definition");
//        addNewSlang = new JButton("Add a new Slang Word");
//        editSlang = new JButton("Edit a Slang Word");
//        deleteSlang = new JButton("Delete a Slang Word");
//        randomSlang = new JButton("Random a Slang Word");
//        showHistory = new JButton("Show history");
//        quiz1 = new JButton("Quiz 1");
//        quiz2 = new JButton("Quiz 2");
//        reset = new JButton("Rest Dictionary");

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuView extends JPanel {

    private JPanel panelMenu;
    private JButton[] buttons;

    public MenuView() {
//        panelMenu = new JPanel();
        setBorder(new EmptyBorder(8, 8, 8, 8));
        setLayout(new GridLayout(10, 1));

        buttons = new JButton[]{
                new JButton("Search by Slang Word"),
                new JButton("Search by Definition"),
                new JButton("Add a new Slang Word"),
                new JButton("Edit a Slang Word"),
                new JButton("Delete a Slang Word"),
                new JButton("Random a Slang Word"),
                new JButton("Show history"),
                new JButton("Quiz 1"),
                new JButton("Quiz 2"),
                new JButton("Reset Dictionary")
        };

        for (JButton button : buttons) {
            button.setPreferredSize(new Dimension(300, 40));

            add(button);
        }

//        add(panelMenu);
    }
}