/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 08/11/2023 - 22:49
 */
package Controllers;

import Models.Dictionary;
import Views.DeleteSlangWordView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Controllers.DictionaryController.DICTONARY;

public class DeleteSlangWordController implements ActionListener {
    private DeleteSlangWordView deleteSlangWordView;
//    private Dictionary dictionary;
    public DeleteSlangWordView getDeleteSlangWordView() {
        return this.deleteSlangWordView;
    }

    public void setDeleteSlangWordView(DeleteSlangWordView deleteSlangWordView) {
        this.deleteSlangWordView = deleteSlangWordView;

        deleteSlangWordView.getEditButton().addActionListener(this);
    }

    public Dictionary getDictionary() {
        return DICTONARY;
    }

    public DeleteSlangWordController(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        String slangWord = deleteSlangWordView.getEditSlangWord().getText();

        if (slangWord.isBlank()) {
            JOptionPane.showMessageDialog(deleteSlangWordView, "Please enter the slang word you want to delete.");
            return;
        }

        if (DICTONARY.getSlangList().containsKey(slangWord)) {
            int option = JOptionPane.showConfirmDialog(deleteSlangWordView, "Are you sure you want to delete the slang word " + slangWord + "?", "Delete Slang Word", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                DICTONARY.getSlangList().remove(slangWord);
                JOptionPane.showMessageDialog(deleteSlangWordView, "Slang word deleted successfully.");
                deleteSlangWordView.getEditSlangWord().setText("");
            }
        } else {
            JOptionPane.showMessageDialog(deleteSlangWordView, "Slang word not found.");
        }
    }
    public void reset(){
        deleteSlangWordView.getEditSlangWord().setText("");
    }
}
