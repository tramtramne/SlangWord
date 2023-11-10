/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 10/11/2023 - 04:29
 */
package Controllers;

import Models.Dictionary;
import Views.RandomSlangWordView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSlangWordController implements ActionListener {
    private RandomSlangWordView randomSlangWordView;
    private Dictionary dictionary;
    private Random random = new Random();
    private ArrayList<String> slangWord;
    public RandomSlangWordController(){

    }

    public RandomSlangWordView getRandomSlangWordView() {
        return randomSlangWordView;
    }
    public void setRandomSlangWordView(RandomSlangWordView randomSlangWordView) {
        this.randomSlangWordView = randomSlangWordView;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }


    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
        slangWord = new ArrayList<String>(dictionary.getSlangList().keySet());
    }

    public void randomSlangWord(){

        String randomWord =  slangWord.get(random.nextInt(slangWord.size()));

        List<String> definitions = dictionary.getSlangList().get(randomWord);
        String text = randomWord + ": ";
        String mergedString = String.join("|", definitions);
        text += mergedString;

        randomSlangWordView.getShowResult().setText(text);
    }
    public void setListenButton(){
        randomSlangWordView.getRandomButton().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        randomSlangWord();
    }
    public void reset(){
        randomSlangWordView.getRandomButton().removeActionListener(this);
        randomSlangWordView.getShowResult().setText("");
    }
}
