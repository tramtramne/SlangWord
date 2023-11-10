/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 10/11/2023 - 08:08
 */
package Controllers;

import Models.Dictionary;
import Views.QuizView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quiz2Controller implements ActionListener {

    private QuizView quizView;
    private Dictionary dictionary;
    private Random random = new Random();
    private ArrayList<String> slangWord;
    private String correctAnswer;
    public QuizView getQuizView() {
        return quizView;
    }

    public void setQuizView(QuizView quizView) {
        this.quizView = quizView;
    }

    public Quiz2Controller() {
    }
    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String getRandomSlangWord() {
        slangWord = new ArrayList<String>(dictionary.getSlangList().keySet());
        return slangWord.get(random.nextInt(slangWord.size()));
    }

    public List<String> createQuizOptions(String correctSlang) {
        List<String> options = new ArrayList<>();

//        String answer = getRandomSlangWord();
//        this.correctAnswer = answer;
        options.add(correctSlang);
        int count = 0;

        while(count < 3) {
            String word = slangWord.get(random.nextInt(slangWord.size()));
            if (!word.equals(correctSlang) && count < 3) {
                    options.add(word);
                    count++;
            }
        }


        Collections.shuffle(options);
        return options;
    }

    public void displayQuiz(boolean isFirst){
        correctAnswer = getRandomSlangWord();
        String question = "";
        List<String> definitions = dictionary.getSlangList().get(correctAnswer);
        if (definitions != null && !definitions.isEmpty()) {
             question = definitions.get(0);
        }

        List<String> options = createQuizOptions(correctAnswer);
        String quizQuestion = "What is the meaning of the slang word: " + question;

        if (isFirst){
            quizView.display("Quiz 2", quizQuestion, options);
            quizView.setQuestionLabel(quizQuestion);
            quizView.setAnswerTextButtons(options);
            quizView.setButtonListen(this);
        }
        else {
            quizView.setQuestionLabel(quizQuestion);
            quizView.setAnswerTextButtons(options);

        }




    }
    //    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String selectedOption = clickedButton.getText();
        if (selectedOption.equals(correctAnswer)) {
            JOptionPane.showMessageDialog(null, "Correct answer!");

        } else {
            JOptionPane.showMessageDialog(null, "Incorrect answer! The correct answer is: " + correctAnswer);
//            quizView.reset();
        }
        displayQuiz(false);
    }
    public void reset(){
//        List<String> temp = new ArrayList<>();
//        quizView.setQuestionLabel("");
//        quizView.setAnswerTextButtons(temp);
//        quizView.setButtonListen(null);
        JButton[] buttons = quizView.getAnswerButtons();
        for (JButton option: buttons){
            option.removeActionListener(this);
        }
    }
}
