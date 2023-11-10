/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 08/11/2023 - 22:19
 */
package Controllers;

import Models.Dictionary;
import Views.EditSlangWordView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EditSlangWordController implements ActionListener {

    private EditSlangWordView editSlangWordView;
    private Dictionary dictionary;

    public EditSlangWordController(){}

    public EditSlangWordView getEditSlangWordView() {
        return editSlangWordView;
    }

    public void setEditSlangWordView(EditSlangWordView editSlangWordView) {
        this.editSlangWordView = editSlangWordView;
        JButton editBtn = this.editSlangWordView.getEditButton();
        editBtn.addActionListener(this);

    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public EditSlangWordController(EditSlangWordView editSlangWordView, Dictionary dictionary) {
        this.editSlangWordView = editSlangWordView;
        this.dictionary = dictionary;

        editSlangWordView.getEditButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String slangWord = editSlangWordView.getEditSlangWord().getText();
        String def = editSlangWordView.getEditDef().getText();

        if (slangWord.isBlank() || def.isBlank()) {
            JOptionPane.showMessageDialog(editSlangWordView, "Please enter both slang word and definition.");
            return;
        }

        List<String> defList = dictionary.getSlangList().get(slangWord);
        if (defList == null) {
            JOptionPane.showMessageDialog(editSlangWordView, "Slang word not found.");
        }
        else if (defList.isEmpty()) {
            JOptionPane.showMessageDialog(editSlangWordView, "Slang word not found.");
        }
        else {
            defList = new ArrayList<>();
            defList.add(def);
            dictionary.getSlangList().put(slangWord, defList);

            JOptionPane.showMessageDialog(editSlangWordView, "Slang word edited successfully.");
        }
        editSlangWordView.getEditSlangWord().setText("");
        editSlangWordView.getEditDef().setText("");
    }
    public void reset(){
        editSlangWordView.getEditDef().setText("");
        editSlangWordView.getEditSlangWord().setText("");
        editSlangWordView.getEditButton().removeActionListener(this);
    }
}

