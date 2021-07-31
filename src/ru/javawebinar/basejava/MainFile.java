package ru.javawebinar.basejava;

import java.io.File;
import java.util.Objects;

public class MainFile {
    public static void main(String[] args) {
        File file = new File("./src");
        File[] list = file.listFiles();

        StringBuilder delimiter = new StringBuilder("-");
        printTree(Objects.requireNonNull(list), delimiter);
    }

    public static void printTree(File[] list, StringBuilder delimiter) {
        for (File value : list) {
            System.out.println(delimiter + value.toString().replaceAll(".*\\\\", ""));
            if (value.isDirectory()) {
                delimiter.append("-");
                printTree(Objects.requireNonNull(value.listFiles()), delimiter);
            }
        }
    }
}
