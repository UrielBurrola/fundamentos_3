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

        ArrayList<String> uniqueNames = countUniqueNames(nameList);
        printNames(uniqueNames);
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
    }

    private static ArrayList<String> countUniqueNames(ArrayList<String> nameList) {
        ArrayList<String> uniqueNames = new ArrayList<>();
        for (String name : nameList) {
            name = name.split(" ")[0];
            if (!uniqueNames.contains(name)) {
                uniqueNames.add(name);
            } else {
                
            }
        }
        return uniqueNames;
    }

}