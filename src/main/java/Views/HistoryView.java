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
    public HistoryView(){

        setLayout(new BorderLayout());
        BorderLayout gbc = new BorderLayout();

        JPanel history = new JPanel();

        // Create a new Result object

        history.setBorder(new CompoundBorder(new TitledBorder("Result"), new EmptyBorder(6, 12, 12, 12)));

        add(history,BorderLayout.CENTER);
    }
}
