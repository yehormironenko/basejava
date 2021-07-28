package ru.javawebinar.basejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        File file = new File("D:/OneDrive - Computaris/java/projects/basejava/.gitignore");
        try {
            System.out.println(file.getCanonicalFile());

        } catch (IOException e) {
            e.printStackTrace();
        }
        File dir = new File("./src/ru/javawebinar/basejava/");
        System.out.println(dir.isDirectory());

        /*for (String name : dir.list()) {
            System.out.println(name);
        }*/

        try (FileInputStream fis = new FileInputStream(file)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
