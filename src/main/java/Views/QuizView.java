/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 08/11/2023 - 14:46
 */
package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizView extends JPanel {
    private JLabel questionLabel;
    private JButton[] optionButton;
    private JPanel questionPanel;
    private JButton option1;
    private JButton option2;
    private JButton option3;
    private JButton option4;
    private JButton submitButton;
    private String correctAnswer = "Paris";


    public QuizView(String quiz, String question, String[] option){

        setBorder(new EmptyBorder(8, 8, 8, 8));
        setLayout(new BorderLayout());
        questionPanel = new JPanel();
        questionPanel.setLayout(new BorderLayout());
        questionPanel.setBorder(new EmptyBorder(8, 8, 8, 8));
        // Create the question label and place it in the center
        JLabel quizLabel = new JLabel(quiz);
        questionLabel = new JLabel(question);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));

        questionPanel.add(quizLabel,BorderLayout.NORTH);
        questionPanel.add(questionLabel,BorderLayout.CENTER);

        //OPTION
        JPanel optionPanel = new JPanel(new GridBagLayout());
        GridBagConstraints optionConstraints = new GridBagConstraints();
        optionConstraints.fill = GridBagConstraints.HORIZONTAL;
        optionConstraints.insets = new Insets(10, 10, 10, 10);

        optionButton = new JButton[4];
        for (int i = 0; i < optionButton.length; i++) {
//            optionButton[i].setLineWrap(true);
            JLabel label = new JLabel("<html>Nội dung button quá dài và cần xuống dòng</html>");
            label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
//            button.add(label);

            optionButton[i] = new JButton(option[i]);

            optionButton[i].setPreferredSize(new Dimension(250, 50));
//            optionPanel.add(optionButton[i], optionConstraints);
        }
//        optionButton[0] = new JButton(option[0]);
        optionConstraints.gridx = 1;
        optionConstraints.gridy = 1;
        optionPanel.add(optionButton[0],optionConstraints);

//        optionButton[1] = new JButton(option[1]);
        optionConstraints.gridx = 2;
        optionConstraints.gridy = 1;
        optionPanel.add(optionButton[1],optionConstraints );

//        optionButton[2] = new JButton(option[2]);
        optionConstraints.gridx = 1;
        optionConstraints.gridy = 2;
        optionPanel.add(optionButton[2],optionConstraints);

//        optionButton[3] = new JButton(option[3]);
        optionConstraints.gridx = 2;
        optionConstraints.gridy = 2;
        optionPanel.add(optionButton[3],optionConstraints);

        add(questionPanel,BorderLayout.NORTH);
        add(optionPanel,BorderLayout.CENTER);
    }

}
