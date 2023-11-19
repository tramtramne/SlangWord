/**
 * @author Ngoc Tram
 * @project SlangWord
 * @created 05/11/2023 - 08:45
 */
package Models;/*
 *@author user
 *@project SlangWord
 *@created 05/11/2023 - 08:45
 */

import Controllers.DictionaryController;

import java.io.*;
import java.util.*;

import static Controllers.DictionaryController.DICTONARY;

public class Dictionary {
    Map<String, List<String>> slangList;
    LinkedHashMap<String,String> history;
    public Map<String, String> getHistory() {
        return history;
    }
    public String showHistory() {
        String showHistory ="";
        for (String key : history.keySet()) {
            showHistory += key + " : " + history.get(key);
            showHistory+= "\n";
        }
        return showHistory;
    }

    public void setHistory(LinkedHashMap<String, String> history) {
        this.history = history;
    }



    public Dictionary() {
        this.slangList = new HashMap<>();
        this.history = new LinkedHashMap<>();

        File outputfile = new File("slangHash.txt");
        loadHistoryFromFile("history.txt");

        if (!outputfile.exists()) {
            this.slangList = saveDataFromFileText();
            System.out.println(slangList);
        } else {

            loadSlangListFromFile("slangHash.txt");
        }
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            saveSlangListToFile("slangHash.txt");
            saveHistoryToFile("history.txt");
        }));
    }

    public Map<String, List<String>> saveDataFromFileText() {
        Map<String, List<String>> slangListTemp = null;
        try {
            FileReader reader = new FileReader("slang.txt");
            Scanner scanner = new Scanner(reader);
            slangListTemp = new HashMap<>();

            String lastKey = "";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.contains("`")) {
                    String[] parts = line.split("`");
                    String[] temp;
                    lastKey = parts[0];
                    if (parts[1].contains("|")) {
                        temp = parts[1].split("\\| ");
                        slangListTemp.put(parts[0], Arrays.asList(temp));
                    } else {
                        slangListTemp.put(parts[0], Arrays.asList(parts[1]));
                    }

                } else {
                    List<String> tempEditElement = new ArrayList<>(slangListTemp.get(lastKey));
                    tempEditElement.add(line);
                    slangListTemp.put(lastKey, tempEditElement);
                }

            }
//            System.out.println(slangListTemp[0]);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return slangListTemp;
    }
    public Map<String, List<String>> getSlangList() {

        return slangList;
    }

    public void setSlangList(Map<String, List<String>> slangList) {
        this.slangList = slangList;
    }

    public void saveSlangListToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(slangList);

            System.out.println("SlangList has been saved to the file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving SlangList to the file: " + e.getMessage());
        }
    }
    public void saveHistoryToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(history);
            System.out.println("SlangList has been saved to the file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving SlangList to the file: " + e.getMessage());
        }
    }

    // Method to load the slangList from a file using deserialization
    @SuppressWarnings("unchecked")
    public void loadSlangListFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            slangList = (Map<String, List<String>>) ois.readObject();
            System.out.println("SlangList has been loaded from the file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading SlangList from the file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadHistoryFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            history = (LinkedHashMap<String, String>) ois.readObject();
            System.out.println("History has been loaded from the file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading History from the file: " + e.getMessage());
        }
    }

    private void saveSlangListOnExit() {
        saveSlangListToFile("slangHash.txt");
        saveHistoryToFile("history.txt");
    }

    public  List<String> findSlangWordsByDefinition(String keyword) {
        List<String> slangWords = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : DICTONARY.getSlangList().entrySet()) {
            for (String definition : entry.getValue()) {
                if (definition.contains(keyword)) {
                    slangWords.add(entry.getKey());
                    break;
                }
            }
        }
        return slangWords;
    }
    @Override
    public String toString() {
        return "Dictionary{" +
                "slangList=" + slangList +
                '}';
    }


}
