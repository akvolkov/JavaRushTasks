package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream(args[0]);
        Charset windows1251 = Charset.forName("Windows-1251");
        byte[] buffer = new byte[in.available()];
        while (in.available() > 0) {
            in.read(buffer);
        }
        Charset UTF8 = Charset.forName("UTF-8");
        String s = new String(buffer,UTF8);
        buffer = s.getBytes(windows1251);
        FileOutputStream  out = new FileOutputStream(args[1]);
        out.write(buffer);
    }
}
