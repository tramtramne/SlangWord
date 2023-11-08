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
    public RandomSlangWordView(){
//        setBorder(new EmptyBorder(8, 8, 8, 8));
        setLayout(new BorderLayout());
        BorderLayout gbc = new BorderLayout();
        // Create a new Search object
        JButton randomButton = new JButton("Random");
        add(randomButton,BorderLayout.NORTH);
       ;

        // Create a new Result object
        JPanel result = new JPanel();
        result.setBorder(new CompoundBorder(new TitledBorder("Result"), new EmptyBorder(6, 12, 12, 12)));

        add(result,BorderLayout.CENTER);
    }
}
