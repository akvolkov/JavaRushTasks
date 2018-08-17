package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {
    static int countFiles = 0;
    static int countDirectory = 0;
    static int sizeCounter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(reader.readLine());
        if (!Files.isDirectory(path)) {
            System.out.println(path.toAbsolutePath() + " - не папка");
        }
        else {
            Files.walkFileTree(path, new MySimpleFileVisitor());
            System.out.println("Всего папок - " + (countDirectory - 1));
            System.out.println("Всего файлов - " + countFiles);
            System.out.println("Общий размер - " + sizeCounter);
        }
    }

    public static class MySimpleFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            countDirectory++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            countFiles++;
            sizeCounter += attrs.size();
            return FileVisitResult.CONTINUE;
        }
    }

}
