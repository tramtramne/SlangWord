/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 10/11/2023 - 12:36
 */
package Controllers;

import Views.HistoryView;

public class HistoryController {
    private HistoryView historyView;

    public HistoryView getHistoryView() {
        return historyView;
    }

    public void setHistoryView(HistoryView historyView, String content) {
        this.historyView = historyView;
        historyView.setHistoryText(content);
    }

    public HistoryController() {
    }
}
