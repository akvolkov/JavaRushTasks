package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by Home PC Volkov on 23.02.2018.
 */
public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public HTMLDocument getDocument() {
        return document;
    }

    public Controller(View view) {
        this.view = view;
    }

    public static void main (String[] args) {
        View view1 = new View();
        Controller controller = new Controller(view1);
        view1.setController(controller);
        view1.init();
        controller.init();
    }

    /**
     * метод инициализации init() контроллера
     * Он должен просто вызывать метод создания нового документа.
     */
    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public void resetDocument(){
        if (document != null)
            document.removeUndoableEditListener(view.getUndoListener());
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text) {
        resetDocument();
        StringReader stringReader = new StringReader(text);
        try {
            new HTMLEditorKit().read(stringReader, document,0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        StringWriter stringWriter = new StringWriter();
        try {
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public void createNewDocument() {
        view.selectHtmlTab(); //Выбирать html вкладку у представления.
        resetDocument();//Сбрасывать текущий документ.
        view.setTitle("HTML редактор");//Устанавливать новый заголовок окна
        view.resetUndo(); //Сбрасывать правки в Undo менеджере
        currentFile = null;
    }

    public void openDocument(){
        view.selectHtmlTab(); // Переключать представление на html вкладку.
        JFileChooser jFileChooser = new JFileChooser(); // Создавать новый объект для выбора файла JFileChooser.
        jFileChooser.setFileFilter(new HTMLFileFilter()); //Устанавливать ему в качестве фильтра объект HTMLFileFilter.
        int chose = jFileChooser.showOpenDialog(view);
        if (chose == JFileChooser. APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try {
                FileReader fileReader = new FileReader(currentFile);
                new HTMLEditorKit().read(fileReader, document, 0);
                view.resetUndo();

            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }

    }

    public void saveDocument(){
        if (currentFile == null) saveDocumentAs();
        else {
            view.selectHtmlTab();
            view.setTitle(currentFile.getName());

            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }

        }
    }

    public void saveDocumentAs(){
        view.selectHtmlTab(); // Переключать представление на html вкладку.
        JFileChooser jFileChooser = new JFileChooser(); // Создавать новый объект для выбора файла JFileChooser.
        jFileChooser.setFileFilter(new HTMLFileFilter()); //Устанавливать ему в качестве фильтра объект HTMLFileFilter.
        int chose = jFileChooser.showSaveDialog(view);
        if ( chose == JFileChooser. APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
                fileWriter.close();
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }

        }
    }




}
