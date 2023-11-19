/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 08/11/2023 - 13:26
 */
package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddandEditSlangView extends JPanel {
    private JButton addButton;
    private JButton editButton;
    private JTextField addSlangWord;
    private JTextArea addDef;

    public JButton getEditButton() {
        return editButton;
    }

    public AddandEditSlangView(String AddorEdit){
        setBorder(new EmptyBorder(8, 8, 8, 8));
        setLayout(new BorderLayout());

        JPanel addSlangWordContainer = new JPanel();
        addSlangWordContainer.setLayout(new FlowLayout());
        addSlangWordContainer.add(new JLabel("Slang word: "));
        addSlangWord = new JTextField(40);
        addSlangWordContainer.add(addSlangWord);
        add(addSlangWordContainer,BorderLayout.NORTH);

        JPanel addDefContainer = new JPanel();
        addDefContainer.setLayout(new FlowLayout());
        addDefContainer.add(new JLabel("Definition: "));
        addDef = new JTextArea(5,40);
        addDefContainer.add(addDef);
        add(addDefContainer,BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(80, 25));
        editButton = new JButton("Edit");
        editButton.setPreferredSize(new Dimension(80, 25));
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        if (AddorEdit == "add") {
//            editButton.removeActionListener(e);
            addButton.setVisible(true);
            editButton.setVisible(false);
        }
        else{ addButton.setVisible(false);
            editButton.setVisible(true);}

        add(buttonPanel, BorderLayout.SOUTH);
    }
    public String getSlangWordText() {
        return addSlangWord.getText();
    }
    public String getDefinition() {
        return addDef.getText();
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getAddButton() {
        return addButton;
    }
    public void setSlangWordText(String text) {
        addSlangWord.setText(text);
    }
    public void setDefinition(String text) {
        addDef.setText(text);
    }

}


