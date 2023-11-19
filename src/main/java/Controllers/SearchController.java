package Controllers;

import Models.Dictionary;
import Views.SearchView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static Controllers.DictionaryController.DICTONARY;

public class SearchController implements ActionListener {

    private SearchView searchBySlangView;

    public SearchController(){}

    public SearchView getSearchBySlangView() {
        return searchBySlangView;
    }
    public void setSearchBySlangView(SearchView searchBySlangView) {
        this.searchBySlangView = searchBySlangView;
        JButton searchButton = this.searchBySlangView.getSearch().getSearchButton();
        searchButton.addActionListener(this);
    }


    public SearchController(SearchView searchBySlangView, Dictionary dictionary) {
        this.searchBySlangView = searchBySlangView;

        JButton searchButton = this.searchBySlangView.getSearch().getSearchButton();
        searchButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String slangWord = searchBySlangView.getSearch().getSearchField().getText();
        String label = searchBySlangView.getSearchFunction();
        if (slangWord.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please input data", "Error", JOptionPane.ERROR_MESSAGE);

            return;
        }

        if (label == "Input slang word") {
            List<String> definitions = DICTONARY.getSlangList().get(slangWord);
            if (definitions == null) {
                searchBySlangView.getResult().getResultSearch().setText("Slang word not found.");
            } else {
                System.out.println("Slang word found.");
                StringBuilder definitionText = new StringBuilder();
                for (String definition : definitions) {
                    definitionText.append(definition).append("\n");
                }
                String str = String.join(" | ", definitions);
                DICTONARY.getHistory().put(slangWord, str);

                searchBySlangView.getResult().getResultSearch().setText(definitionText.toString());
            }
        } else if (label == "Input definition: ") {
            List<String> definitions = DICTONARY.findSlangWordsByDefinition(slangWord);
            if (definitions.isEmpty()) {
                searchBySlangView.getResult().getResultSearch().setText("Slang word not found.");
            } else {
                String historyString =  String.join(" | ", definitions);
                DICTONARY.getHistory().put(slangWord,historyString);

                String showResult =  String.join("\n", definitions);
                searchBySlangView.getResult().getResultSearch().setText(showResult);
            }

        }
    }




    public void reset(){
        searchBySlangView.getResult().getResultSearch().setText("");
        searchBySlangView.getSearch().getSearchField().setText("");
    }
}
