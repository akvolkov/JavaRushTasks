package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<String>();
        ArrayDeque<File> arrayDeque = new ArrayDeque<File>();
        arrayDeque.offer(new File(root));

        while (arrayDeque.size() > 0) {
            File tempFile = arrayDeque.poll();
            if (tempFile.isFile()) {
                list.add(tempFile.getAbsolutePath());
            }
            else {
                if (tempFile.isDirectory()) {
                    for (File f: tempFile.listFiles()
                         ) {
                        arrayDeque.offer(f);
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
