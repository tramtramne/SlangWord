/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 08/11/2023 - 22:04
 */
package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Models.*;
import Views.*;

import javax.swing.*;

public class SearchByDefinitionController  implements ActionListener {
    private Dictionary dictionary;
    private SearchByDefinitionView view;

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void setView(SearchByDefinitionView view) {
        this.view = view;
        view.getSearch().getSearchButton().addActionListener(e -> {
            String keyword = view.getSearch().getSearchField().getText();
//            List<String> slangWords = findSlangWordsByDefinition(keyword);
//            view.getResult().getResultSearch().append(String.join("\n", slangWords));
        });
        view.getSearch().getSearchButton().addActionListener(this);
    }

    public SearchByDefinitionController(){}


    public SearchByDefinitionView getView() {
        return view;
    }

    private List<String> findSlangWordsByDefinition(String keyword) {
        List<String> slangWords = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : dictionary.getSlangList().entrySet()) {
            for (String definition : entry.getValue()) {
                if (definition.contains(keyword)) {
                    slangWords.add(entry.getKey());
                    break;
                }
            }
        }
        return slangWords;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String slangWord = view.getSearch().getSearchField().getText();

        if (slangWord.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a slang word.", "Error", JOptionPane.ERROR_MESSAGE);

            return;
        }

        List<String> definitions = findSlangWordsByDefinition(slangWord);
        if (definitions.isEmpty()) {
            System.out.println("Slang word not found.");
            view.getResult().getResultSearch().setText("Slang word not found.");
        } else {
            System.out.println("Slang word found.");
            String historyString =  String.join(" | ", definitions);
            dictionary.getHistory().put(slangWord,historyString);
            System.out.println(definitions);
            String showResult =  String.join("\n", definitions);
            view.getResult().getResultSearch().setText(showResult);
        }
    }
    public void reset(){
        view.getResult().getResultSearch().setText("");
        view.getSearch().getSearchField().setText("");
        view.getSearch().getSearchButton().removeActionListener(this);
    }
}
