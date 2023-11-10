/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 08/11/2023 - 20:47
 */
package Controllers;

import Models.Dictionary;
import Views.AddSlangView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddSlangController implements ActionListener {
    private AddSlangView addSlangView;
    private Dictionary dictionary;
    public AddSlangController(){}

    public void setAddSlangView(AddSlangView addSlangView) {
        this.addSlangView = addSlangView;
        JButton addBtn = this.addSlangView.getAddButton();
        addBtn.addActionListener(this);
    }
    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }


    public AddSlangView getAddSlangView() {
        return addSlangView;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            String slangWord = addSlangView.getSlangWordText();
            String definition = addSlangView.getDefinition();
        if (addSlangView == null || dictionary == null) {
            JOptionPane.showMessageDialog(null, "Field is null");
            return;
        }

        if (dictionary.getSlangList().containsKey(slangWord)) {
                int option = JOptionPane.showConfirmDialog(null, "Slang word already exists. Do you want to overwrite?",
                        "Warning", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    dictionary.getSlangList().put(slangWord, List.of(definition));

                    JOptionPane.showMessageDialog(null, "Slang word overwritten successfully.");

                } else
                if ((option == JOptionPane.NO_OPTION)){
                    List<String> definitions = new ArrayList<>(dictionary.getSlangList().get(slangWord));
                    definitions.add(definition);
                    dictionary.getSlangList().put(slangWord, definitions);
                    JOptionPane.showMessageDialog(null, "New slang word added successfully: " + slangWord);
                }
        } else {
                dictionary.getSlangList().put(slangWord, List.of(definition));
                JOptionPane.showMessageDialog(null, "New slang word added successfully.");
        }

        addSlangView.setSlangWordText("");
        addSlangView.setDefinition("");
    }

    public void reset(){
        addSlangView.getAddButton().removeActionListener(this);
        addSlangView.setDefinition("");
        addSlangView.setSlangWordText("");
    }
}

