/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 08/11/2023 - 20:47
 */
package Controllers;

import Models.Dictionary;
import Views.AddandEditSlangView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static Controllers.DictionaryController.DICTONARY;

public class AddandEditSlangController {
    private AddandEditSlangView addSlangView;
    public AddandEditSlangController(){}

    public void setAddSlangView(AddandEditSlangView addSlangView) {
        this.addSlangView = addSlangView;
        JButton addBtn = this.addSlangView.getAddButton();
        addBtn.addActionListener(e -> {
            String slangWord = addSlangView.getSlangWordText();
            String definition = addSlangView.getDefinition();
            if ( addSlangView.getSlangWordText().isEmpty() ||  addSlangView.getDefinition().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Field is null");
                return;
            }

            if (DICTONARY.getSlangList().containsKey(slangWord)) {
                int option = JOptionPane.showConfirmDialog(null, "Slang word already exists. Do you want to overwrite?",
                        "Warning", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    DICTONARY.getSlangList().put(slangWord, List.of(definition));

                    JOptionPane.showMessageDialog(null, "Slang word overwritten successfully.");

                } else
                if ((option == JOptionPane.NO_OPTION)){
                    List<String> definitions = new ArrayList<>(DICTONARY.getSlangList().get(slangWord));
                    definitions.add(definition);
                    DICTONARY.getSlangList().put(slangWord, definitions);
                    JOptionPane.showMessageDialog(null, "New slang word added successfully: " + slangWord);
                }
            } else {
                DICTONARY.getSlangList().put(slangWord, List.of(definition));
                JOptionPane.showMessageDialog(null, "New slang word added successfully.");
            }

            addSlangView.setSlangWordText("");
            addSlangView.setDefinition("");
        });

        JButton editBtn = this.addSlangView.getEditButton();
        editBtn.addActionListener(e ->{
            String slangWord = addSlangView.getSlangWordText();
            String definition = addSlangView.getDefinition();
            if (slangWord.isBlank() || definition.isBlank()) {
                JOptionPane.showMessageDialog(addSlangView, "Please enter both slang word and definition.");
                return;
            }

            List<String> defList = DICTONARY.getSlangList().get(slangWord);
            if (defList == null) {
                JOptionPane.showMessageDialog(addSlangView, "Slang word not found.");
            }
            else if (defList.isEmpty()) {
                JOptionPane.showMessageDialog(addSlangView, "Slang word not found.");
            }
            else {
                defList = new ArrayList<>();
                defList.add(definition);
                DICTONARY.getSlangList().put(slangWord, defList);
                JOptionPane.showMessageDialog(addSlangView, "Slang word edited successfully.");
            }
            addSlangView.setSlangWordText("");
            addSlangView.setDefinition("");
        });


        addSlangView.setSlangWordText("");
        addSlangView.setDefinition("");
    }


    public AddandEditSlangView getAddSlangView() {
        return addSlangView;
    }

    public Dictionary getDictionary() {
        return DICTONARY;
    }

    public void reset(){
        addSlangView.setDefinition("");
        addSlangView.setSlangWordText("");
    }
}

