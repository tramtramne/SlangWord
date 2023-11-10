package Controllers;

import Models.Dictionary;
import Views.Search;
import Views.SearchBySlangView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchBySlangController implements ActionListener {

    private SearchBySlangView searchBySlangView;


    private Dictionary dictionary;
    public SearchBySlangController(){}

    public SearchBySlangView getSearchBySlangView() {
        return searchBySlangView;
    }
    public void setSearchBySlangView(SearchBySlangView searchBySlangView) {
        this.searchBySlangView = searchBySlangView;
        JButton searchButton = this.searchBySlangView.getSearch().getSearchButton();
        searchButton.addActionListener(this);
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public SearchBySlangController(SearchBySlangView searchBySlangView, Dictionary dictionary) {
        this.searchBySlangView = searchBySlangView;
        this.dictionary = dictionary;
        JButton searchButton = this.searchBySlangView.getSearch().getSearchButton();
        searchButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String slangWord = searchBySlangView.getSearch().getSearchField().getText();

        if (slangWord.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a slang word.", "Error", JOptionPane.ERROR_MESSAGE);

            return;
        }

        List<String> definitions = dictionary.getSlangList().get(slangWord);
        if (definitions == null) {
            searchBySlangView.getResult().getResultSearch().setText("Slang word not found.");
        } else {
            System.out.println("Slang word found.");
            StringBuilder definitionText = new StringBuilder();
            for (String definition : definitions) {
                definitionText.append(definition).append("\n");
            }
            String str =  String.join(" | ", definitions);
            dictionary.getHistory().put(slangWord,str);
            System.out.println(definitionText);
            searchBySlangView.getResult().getResultSearch().setText(definitionText.toString());
        }
    }

    public void reset(){
        searchBySlangView.getResult().getResultSearch().setText("");
        searchBySlangView.getSearch().getSearchField().setText("");
        searchBySlangView.getSearch().getSearchButton().removeActionListener(this);
    }
}
