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

import static Controllers.DictionaryController.DICTONARY;

public class ResetSlangWordsController{



    public Dictionary getDictionary() {
        return DICTONARY;
    }

    public ResetSlangWordsController() {}
}

