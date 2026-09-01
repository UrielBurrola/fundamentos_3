package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class nombresArrayList {
    public static void main(String[] args) {
        Path filePath = Paths.get("C:\\Users\\uriel\\Documents\\Fundamentos_3\\fundamentos_3\\nombresarraylist\\listado.txt");
        ArrayList<String> nameList = readNamesFromFile(filePath.toString());
        printNames(nameList);
    }

    private static void printNames(ArrayList<String> nameList) {
        for (String name : nameList) {
            System.out.println(name);
        }
    }

    private static ArrayList<String> readNamesFromFile(String filePath) {
        ArrayList<String> names = new ArrayList<>();
        try{
            Stream<String> lines = Files.lines(Paths.get(filePath));
            for (String line : (Iterable<String>) lines::iterator) {
                names.add(line);
            }
            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    };
}