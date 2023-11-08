/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 05/11/2023 - 10:39
 */
package Views;


import javax.swing.*;
import java.awt.*;

public class DictionaryView {
    private static JFrame frame;

    private static JPanel menu;
    private static JPanel content;

    public static void main(String[] args) {
        frame = new JFrame("Button Frame");
        frame.setLayout(new BorderLayout());

        menu = new JPanel();
        MenuView menuPanel = new MenuView();
        menu.add(menuPanel);

        content = new JPanel();
//        SearchBySlang searchBySlang = new SearchBySlang();
//        content.add(searchBySlang);

//        SearchByDefinitionView searchByDefinition = new SearchByDefinitionView();
//        content.add(searchByDefinition);

//        AddSlangView addSlangView = new AddSlangView();
//        content.add(addSlangView);

//        RandomSlangWordView randomSlangWordView = new RandomSlangWordView();
//        content.add(randomSlangWordView);
        QuizView quiz = new QuizView("Quiz 1", "What???????", new String[]{"javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar", "b", "c", "d"});
        content.add(quiz);
        frame.add(menu, BorderLayout.LINE_START);
        frame.add(content, BorderLayout.CENTER);
        frame.setSize(1000, 450);
        frame.setVisible(true);
    }
}