/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 08/11/2023 - 13:59
 */
package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EditSlangWordView extends JPanel{


    private JButton editButton;
    private JTextField editSlangWord;
    private JTextArea editDef;

    public JButton getEditButton() {
        return editButton;
    }

    public JTextField getEditSlangWord() {
        return editSlangWord;
    }

    public JTextArea getEditDef() {
        return editDef;
    }

    public EditSlangWordView(){
        setBorder(new EmptyBorder(8, 8, 8, 8));
        setLayout(new BorderLayout());

        JPanel addSlangWordContainer = new JPanel();
        addSlangWordContainer.setLayout(new FlowLayout());
        addSlangWordContainer.add(new JLabel("Slang word: "));
        editSlangWord = new JTextField(40);
        addSlangWordContainer.add(editSlangWord);
        add(addSlangWordContainer,BorderLayout.NORTH);

        JPanel addDefContainer = new JPanel();
        addDefContainer.setLayout(new FlowLayout());
        addDefContainer.add(new JLabel("Definition: "));
        editDef = new JTextArea(5,40);
        addDefContainer.add(editDef);
        add(addDefContainer,BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        editButton = new JButton("Edit");
        editButton.setPreferredSize(new Dimension(80, 25));
        buttonPanel.add(editButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

    public void setEditSlangWord(JTextField editSlangWord) {
        this.editSlangWord = editSlangWord;
    }

    public void setEditDef(JTextArea editDef) {
        this.editDef = editDef;
    }
}
