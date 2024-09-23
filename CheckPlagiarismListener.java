package SwingChallenge;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CheckPlagiarismListener implements ActionListener {

    JavaPlagiarismCheckerPanel panel;

    public CheckPlagiarismListener(JavaPlagiarismCheckerPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<File> javaFiles = panel.getJavaFiles();

        if (javaFiles == null || javaFiles.size() < 2) {
            JOptionPane.showMessageDialog(null, "Please load at least two files.");
            return;
        }

        panel.appendResultArea("Checking for plagiarism...\n");

        for (int i = 0; i < javaFiles.size(); i++) {
            for (int j = i + 1; j < javaFiles.size(); j++) {
                File file1 = javaFiles.get(i);
                File file2 = javaFiles.get(j);

                try {
                    double similarity = SimilarityChecker.compareFiles(file1, file2);
                    if (similarity > 0.75) {
                        panel.appendResultArea(
                                String.format("Plagiarism detected between %s and %s: %.2f%% similarity\n",
                                        file1.getName(), file2.getName(), similarity * 100));
                    } else {
                        panel.appendResultArea(
                                String.format("No plagiarism detected between %s and %s.\n",
                                        file1.getName(), file2.getName()));
                    }
                } catch (IOException exception) {
                    panel.appendResultArea("Error reading files: " + exception.getMessage() + "\n");
                }
            }
        }
    }
}
