/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 08/11/2023 - 14:00
 */
package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DeleteSlangWordView extends JPanel{
    private JButton editButton;
    private JTextField editSlangWord;
    public JButton getEditButton() {
        return editButton;
    }

    public JTextField getEditSlangWord() {
        return editSlangWord;
    }

    public DeleteSlangWordView(){
        setBorder(new EmptyBorder(8, 8, 8, 8));
        setLayout(new BorderLayout());

        JPanel addSlangWordContainer = new JPanel();
        addSlangWordContainer.setLayout(new FlowLayout());
        addSlangWordContainer.add(new JLabel("Slang word: "));
        editSlangWord = new JTextField(40);
        addSlangWordContainer.add(editSlangWord);
        add(addSlangWordContainer,BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        editButton = new JButton("Delete");
        editButton.setPreferredSize(new Dimension(80, 25));
        buttonPanel.add(editButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
