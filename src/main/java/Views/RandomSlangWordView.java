/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 08/11/2023 - 14:08
 */
package Views;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RandomSlangWordView extends JPanel {
    private JButton randomButton;
    private JLabel showResult;

    public JButton getRandomButton() {
        return randomButton;
    }

    public void setRandomButton(JButton randomButton) {
        this.randomButton = randomButton;
    }

    public JLabel getShowResult() {
        return showResult;
    }

    public void setShowResult(JLabel showResult) {
        this.showResult = showResult;
    }

    public RandomSlangWordView(){
//        setBorder(new EmptyBorder(8, 8, 8, 8));
        setLayout(new BorderLayout());
        BorderLayout gbc = new BorderLayout();
        // Create a new Search object
        randomButton = new JButton("Random");
        add(randomButton,BorderLayout.NORTH);
       ;

        // Create a new Result object
        JPanel result = new JPanel();
        showResult = new JLabel("");
        result.setBorder(new CompoundBorder(new TitledBorder("Result"), new EmptyBorder(6, 12, 12, 12)));
        result.add(showResult,BorderLayout.CENTER);

        add(result,BorderLayout.CENTER);
    }
}
