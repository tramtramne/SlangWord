package Views;///**
// * @author Ngoc Tram
// * @project SlangWord
// * @created 05/11/2023 - 10:39
// */
//package Views;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class DictionaryView {
//    private static JPanel cards;
//    public static final String SEARCH_SLANG_VIEW = "SearchView";
//    public static final String SEARCH_DEF_VIEW = "SearchDefView";
//    public static final String ADD_VIEW = "AddView";
//    public static final String EDIT_VIEW = "EditView";
//    public static final String DELETE_VIEW = "DeleteView";
//    public static final String RANDOM_VIEW = "RandomView";
//    public static final String HISTORY_VIEW = "HistoryView";
//    public static final String QUIZ1_VIEW = "Quiz1View";
//    public static final String QUIZ2_VIEW = "Quiz2View";
//    public static final String RESET_VIEW = "ResetView";
//    SearchBySlangView searchView;
//    SearchByDefinitionView searchDefView;
//    AddSlangView addView;
//    EditSlangWordView editView;
//    DeleteSlangWordView deleteSlangWordView;
//    HistoryView historyView;
//    QuizView quizView1;
//    QuizView quizView2;
//    RandomSlangWordView randomSlangWordView;
//    static MenuView menuView;
//
//    public DictionaryView(){
//        menuView = new MenuView();
//    }
//    private void addComponentToPane(Container pane) {
//        cards = new JPanel(new CardLayout());
//
//        searchView = new SearchBySlangView();
//        searchDefView = new SearchByDefinitionView();
//        addView = new AddSlangView();
//        editView = new EditSlangWordView();
//        deleteSlangWordView = new DeleteSlangWordView();
//        historyView = new HistoryView();
//        randomSlangWordView = new RandomSlangWordView();
//        quizView1 = new QuizView();
//        quizView2 = new QuizView();
//
//        cards.add(searchView, SEARCH_SLANG_VIEW);
//        cards.add(searchDefView, SEARCH_DEF_VIEW);
//        cards.add(addView, ADD_VIEW);
//        cards.add(editView, EDIT_VIEW);
//        cards.add(deleteSlangWordView,DELETE_VIEW);
//        cards.add(historyView,HISTORY_VIEW);
//        cards.add(randomSlangWordView,RANDOM_VIEW);
//        cards.add(quizView1,QUIZ1_VIEW);
//        cards.add(quizView2,QUIZ2_VIEW);
//
//        pane.add(cards, BorderLayout.CENTER);
//    }
//
//    public static MenuView getMenuView() {
//        return menuView;
//    }
//
//    public void createAndShowGUI() {
//        JFrame frame = new JFrame("Dictionary");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        DictionaryView demo = new DictionaryView();
//        demo.addComponentToPane(frame.getContentPane());
//
//        frame.add(menuView, BorderLayout.LINE_START);
////        frame.pack();
//        frame.setSize(1000, 450);
//        frame.setVisible(true);
//    }
//    public JPanel getCards() {
//        return cards;
//    }
//    public static void main(String[] args) {
//    new DictionaryView();
//    }
//}
import Controllers.ResetSlangWordsController;
import Views.MenuView;
import Views.SearchByDefinitionView;
import Views.SearchBySlangView;

import javax.swing.*;
import java.awt.*;

public class DictionaryView {
    private static JPanel cards;
    public static final String SEARCH_SLANG_VIEW = "SearchView";
    public static final String SEARCH_DEF_VIEW = "SearchDefView";
    public static final String ADD_VIEW = "AddView";
    public static final String EDIT_VIEW = "EditView";
    public static final String HISTORY_VIEW = "HistoryView";
    public static final String DELETE_VIEW = "DeleteView";
    public static final String QUIZ1_VIEW = "Quiz1View";
    public static final String QUIZ2_VIEW = "Quiz2View";
    public static final String RANDOM_VIEW = "RandomView";
    public static final String RESET_VIEW = "ResetView";


    SearchBySlangView searchView;

    SearchByDefinitionView searchDefView;
    AddSlangView addSlangView;
    EditSlangWordView editSlangWordView;
    HistoryView historyView;
    DeleteSlangWordView deleteSlangWordView;
    QuizView quiz1View;
    QuizView quiz2View;
    RandomSlangWordView randomSlangWordView;
//    RandomSlangWordView resetSlangWordsController;
    MenuView menuView;

    public MenuView getMenuView() {
        return menuView;
    }

    public DictionaryView() {
        JFrame frame = new JFrame("Dictionary");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cards = new JPanel(new CardLayout());

        searchView = new SearchBySlangView();
        searchDefView = new SearchByDefinitionView();
        addSlangView = new AddSlangView();
        editSlangWordView = new EditSlangWordView();
        historyView = new HistoryView();
        deleteSlangWordView = new DeleteSlangWordView();
        quiz1View = new QuizView();
        quiz2View = new QuizView();
        randomSlangWordView = new RandomSlangWordView();
//        resetSlangWordsController = new ResetSlangWordsController();

        cards.add(searchView, SEARCH_SLANG_VIEW);
        cards.add(searchDefView, SEARCH_DEF_VIEW);
        cards.add(addSlangView,ADD_VIEW);
        cards.add(editSlangWordView,EDIT_VIEW);
        cards.add(historyView,HISTORY_VIEW);
        cards.add(deleteSlangWordView,DELETE_VIEW);
        cards.add(quiz1View,QUIZ1_VIEW);
        cards.add(quiz2View,QUIZ2_VIEW);
        cards.add(randomSlangWordView,RANDOM_VIEW);
//        cards.add(resetSlangWordsController,RESET_VIEW)

        menuView = new MenuView();
        frame.add(menuView, BorderLayout.LINE_START);
        frame.add(cards, BorderLayout.CENTER);

        frame.setSize(1000, 450);
        frame.setVisible(true);
    }

    public JPanel getCards() {
        return cards;
    }


    public SearchBySlangView getSearchView() {
        return searchView;
    }

    public SearchByDefinitionView getSearchDefView() {
        return searchDefView;
    }

    public AddSlangView getAddSlangView() {
        return addSlangView;
    }

    public EditSlangWordView getEditSlangWordView() {
        return editSlangWordView;
    }

    public HistoryView getHistoryView() {
        return historyView;
    }

    public DeleteSlangWordView getDeleteSlangWordView() {
        return deleteSlangWordView;
    }

    public QuizView getQuiz1View() {
        return quiz1View;
    }

    public QuizView getQuiz2View() {
        return quiz2View;
    }

    public RandomSlangWordView getRandomSlangWordView() {
        return randomSlangWordView;
    }
    public void addCard(String name, JPanel card) {
        cards.add(card, name);
    }

}
