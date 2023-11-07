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

    public Dictionary() {
        this.slangList = new HashMap<>();
        File currentFile = new File(".");
        String currentDir = currentFile.getAbsolutePath();
        System.out.println((currentDir));
        try {
            FileReader reader = new FileReader("slang.txt");
            Scanner scanner = new Scanner(reader);

            String line = scanner.nextLine();
            String lastKey = "";
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();

                if (line.contains("`")){
                    String[] parts = line.split("`");
                    String[] temp;
                    lastKey = parts[0];
                    if (parts[1].contains("|")){
                        temp = parts[1].split("\\|");
                        slangList.put(parts[0], Arrays.asList(temp));
                    }
                    else {
                        slangList.put(parts[0], Arrays.asList(parts[1]));
                    }

                }
                else{
                    List<String> tempEditElement = new ArrayList<>(slangList.get(lastKey));
                    tempEditElement.add(line);
                    slangList.put(lastKey,tempEditElement);
                }

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
    }


    public static void main(String[] args) {
        Dictionary t = new Dictionary();
    }

    public Map<String, List<String>> getSlangList() {
        return slangList;
    }

    public void setSlangList(Map<String, List<String>> slangList) {
        this.slangList = slangList;
    }

    @Override
    public String toString() {
        for (Map.Entry<String, List<String>> entry : slangList.entrySet()){
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        return "SlangList{" +
                "slangList=" + slangList +
                '}';
    }
}
