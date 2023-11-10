/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 05/11/2023 - 13:18
 */
package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class QuizView extends JPanel implements ActionListener{

    private JLabel questionLabel;
    private JButton[] answerButtons;
    private JPanel questionPanel;
    private JButton submitButton;



    public QuizView(){}
    public void display(String quizName, String question, List<String> answerOptions) {


        setBorder(new EmptyBorder(8, 8, 8, 8));
        setLayout(new BorderLayout());

        questionPanel = new JPanel();
        questionPanel.setLayout(new BorderLayout());
        questionPanel.setBorder(new EmptyBorder(8, 8, 8, 8));

        // Question Label
        JLabel quizLabel = new JLabel(quizName);

        questionPanel.add(quizLabel, BorderLayout.NORTH);

        // Question Text
        questionLabel = new JLabel("");
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        questionPanel.add(questionLabel, BorderLayout.CENTER);

        // Answer Options
        JPanel answerPanel = new JPanel(new GridLayout(2, 2));
        answerButtons = new JButton[4];
        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i] = new JButton("");
            answerPanel.add(answerButtons[i]);
        }
        questionPanel.add(answerPanel, BorderLayout.SOUTH);


        add(questionPanel, BorderLayout.NORTH);
    }

    public void setQuestionLabel(String text) {
        this.questionLabel.setText(text);
    }

    public void setAnswerTextButtons(List<String>  options) {
        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i].setText(options.get(i));
        }
    }

    public void setQuestionPanel(JPanel questionPanel) {
        this.questionPanel = questionPanel;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JButton[] getAnswerButtons() {
        return answerButtons;
    }

    public void setButtonListen(ActionListener i){
        for (JButton button: answerButtons){
            button.addActionListener(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
