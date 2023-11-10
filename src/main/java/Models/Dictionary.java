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


import java.io.*;
import java.util.*;

public class Dictionary {
    Map<String, List<String>> slangList;
    Map<String,String> history;
    public Map<String, String> getHistory() {
        return history;
    }
    public String showHistory() {
        String showHistory ="";
        for (Map.Entry<String, String> entry : history.entrySet()) {
            showHistory+= entry.getKey() + ": " + entry.getValue();
            showHistory+= "\n";
        }
        System.out.println(showHistory);
        return showHistory;
    }

    public void setHistory(Map<String, String> history) {
        this.history = history;
    }



    public Dictionary() {
        this.slangList = new HashMap<>();
        this.history = new HashMap<>();

        File outputfile = new File("slangHash.txt");
        loadHistoryFromFile("history.txt");

        if (!outputfile.exists()) {
            System.out.println("Helo");
            // Chỉ đọc file slang.txt nếu không có output.txt
            try {
                FileReader reader = new FileReader("slang.txt");
                Scanner scanner = new Scanner(reader);

                String line = scanner.nextLine();
                String lastKey = "";
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();

                    if (line.contains("`")) {
                        String[] parts = line.split("`");
                        String[] temp;
                        lastKey = parts[0];
                        if (parts[1].contains("|")) {
                            temp = parts[1].split("\\| ");
                            slangList.put(parts[0], Arrays.asList(temp));
                        } else {
                            slangList.put(parts[0], Arrays.asList(parts[1]));
                        }

                    } else {
                        List<String> tempEditElement = new ArrayList<>(slangList.get(lastKey));
                        tempEditElement.add(line);
                        slangList.put(lastKey, tempEditElement);
                    }
                }
                reader.close();
            } catch (FileNotFoundException e) {
                System.out.println("File không tồn tại");
            } catch (IOException e) {
                System.out.println("Lỗi đọc file");
            }
        } else {
            System.out.println("Helohhhhhh");
            loadSlangListFromFile("slangHash.txt");
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            saveSlangListToFile("slangHash.txt");
            saveHistoryToFile("history.txt");
        }));
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
            history = (Map<String, String>) ois.readObject();
            System.out.println("History has been loaded from the file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading History from the file: " + e.getMessage());
        }
    }

    private void saveSlangListOnExit() {
        saveSlangListToFile("slangHash.txt");
        saveHistoryToFile("history.txt");
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "slangList=" + slangList +
                '}';
    }

    public static void main(String[] args) {
        Dictionary t = new Dictionary();
        System.out.println(t.getSlangList());
        Runtime.getRuntime().addShutdownHook(new Thread(() -> t.saveSlangListOnExit()));

    }

}
