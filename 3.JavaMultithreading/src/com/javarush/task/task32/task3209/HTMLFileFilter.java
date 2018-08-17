package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Home PC Volkov on 24.02.2018.
 * Для открытия или сохранения файла мы будем использовать JFileChooser из библиотеки swing.
 * Объекты этого типа поддерживают фильтры, унаследованные от FileFilter. Сейчас мы напишем свой фильтр
 */
public class HTMLFileFilter extends FileFilter{
    @Override
    public boolean accept(File f) {
        if (f.isDirectory())
            return true;
        else  {
            String name = f. getName();
            int l = name.length();
            String name5 = name.substring(name.length()-5);
            String name4 = name.substring(name.length()-4);
            name4 = name4.toLowerCase();
            name5 = name5.toLowerCase();
            if ((name4.equals(".htm"))|| (name5.equals(".html")))
                return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
