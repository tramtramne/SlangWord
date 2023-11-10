/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 08/11/2023 - 22:54
 */
package Controllers;
import Models.Dictionary;
//import Views.ResetSlangWords;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetSlangWordsController{
    private Dictionary dictionary;


    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
    public ResetSlangWordsController() {}
}

