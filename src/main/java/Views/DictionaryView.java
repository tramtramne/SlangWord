package Views;
/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 05/11/2023 - 10:39
 */
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


    SearchView searchView;

    SearchView searchDefView;
    AddandEditSlangView addSlangView;
    AddandEditSlangView editSlangWordView;
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

        searchView = new SearchView("Input slang word");
        searchDefView = new SearchView("Input definition: ");
        addSlangView = new AddandEditSlangView("add");
        editSlangWordView = new AddandEditSlangView("edit");
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

        menuView = new MenuView();
        frame.add(menuView, BorderLayout.LINE_START);
        frame.add(cards, BorderLayout.CENTER);

        frame.setResizable(false);
        frame.setSize(1000, 450);
        frame.setVisible(true);
    }

    public JPanel getCards() {
        return cards;
    }


    public SearchView getSearchView() {
        return searchView;
    }

    public SearchView getSearchDefView() {
        return searchDefView;
    }

    public AddandEditSlangView getAddSlangView() {
        return addSlangView;
    }
    public AddandEditSlangView getEditSlangView() {
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
