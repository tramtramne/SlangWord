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

import static Controllers.DictionaryController.DICTONARY;

public class RandomSlangWordController implements ActionListener {
    private RandomSlangWordView randomSlangWordView;
    private Random random = new Random();
    private ArrayList<String> slangWord;
    public RandomSlangWordController(){
        if (DICTONARY.getSlangList().keySet() == null)
        {
            slangWord = null;
        }
        else slangWord = new ArrayList<String>(DICTONARY.getSlangList().keySet());

    }

    public RandomSlangWordView getRandomSlangWordView() {
        return randomSlangWordView;
    }
    public void setRandomSlangWordView(RandomSlangWordView randomSlangWordView) {
        this.randomSlangWordView = randomSlangWordView;
    }

    public Dictionary getDictionary() {
        return DICTONARY;
    }




    public void randomSlangWord(){
        slangWord = new ArrayList<String>(DICTONARY.getSlangList().keySet());
        String randomWord =  slangWord.get(random.nextInt(slangWord.size()));
        System.out.println(randomWord);
        List<String> definitions = DICTONARY.getSlangList().get(randomWord);
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
        randomSlangWordView.getShowResult().setText("");
    }
}
