/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 05/11/2023 - 13:18
 */
package Views;



import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuView extends JPanel {

    public JButton[] getButtons() {
        return buttons;
    }

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

    }

    public JButton getSearchBySlangWordButtons() {
        return buttons[0];
    }
    public JButton getSearchByDefButtons() {
        return buttons[1];
    }
    public JButton getAddNewSlangButtons() {
        return buttons[2];
    }
    public JButton getEditSlangButtons() {
        return buttons[3];
    }
    public JButton getDeleteSlangButtons() {
        return buttons[4];
    }
    public JButton getRandomSlangButtons() {
        return buttons[5];
    }
    public JButton getShowHistoryButtons() {
        return buttons[6];
    }
    public JButton getQuiz1Buttons() {
        return buttons[7];
    }

    public JButton getQuiz2Buttons() {
        return buttons[8];
    }
    public JButton getRestButtons() {
        return buttons[9];
    }

}