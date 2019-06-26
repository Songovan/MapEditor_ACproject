package org.academiadecodigo.bootcamp.FileManager;

import java.io.*;

public class FileManager {

    private String path = "./resources/Saver";
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String line;

    public void save(String line) {
        try {

            bufferedWriter = new BufferedWriter(new FileWriter(path));
            bufferedWriter.write("");
            bufferedWriter.write(line);
            bufferedWriter.flush();
        } catch (IOException e1) {
            System.out.println("IO Exception");
        }
    }

    public String load() {
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            line = bufferedReader.readLine();
            System.out.println(line);
        } catch (IOException ex) {
            System.out.println("IO exception");
        }
        return line;
    }
}
