package SwingChallenge.src.control;

import SwingChallenge.src.view.JavaPlagiarismCheckerPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LoadFileListener implements ActionListener {
    private JavaPlagiarismCheckerPanel panel;

    public LoadFileListener(JavaPlagiarismCheckerPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles();
            List<File> javaFiles = new ArrayList<>();

            for (File file : selectedFiles) {
                if (file.getName().endsWith(".java")) {
                    javaFiles.add(file);
                } else {
                    panel.appendResultArea("Skipped non-Java file: " + file.getName() + "\n");
                }
            }

            if (!javaFiles.isEmpty()) {
                panel.setJavaFiles(javaFiles);
                panel.appendResultArea("Loaded " + javaFiles.size() + " files.\n");
            } else {
                panel.appendResultArea("No .java files were selected.\n");
            }


        }
    }
}
