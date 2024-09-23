package SwingChallenge;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class JavaPlagiarismCheckerPanel extends JPanel {
    private JTextArea resultArea;
    private List<File> javaFiles;

    public JavaPlagiarismCheckerPanel() {
        FlowLayout flowLayout = new FlowLayout();
        this.setLayout(flowLayout);

        JButton loadFileButton = new JButton("Load File");
        JButton checkButton = new JButton("Check");
        resultArea = new JTextArea(15, 50);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        this.add(loadFileButton);
        this.add(checkButton);
        this.add(scrollPane);

        loadFileButton.addActionListener(new LoadFileListener(this));
        checkButton.addActionListener(new CheckPlagiarismListener(this));
    }

    public List<File> getJavaFiles() {
        return javaFiles;
    }

    public void setJavaFiles(List<File> javaFiles) {
        this.javaFiles = javaFiles;
    }

    public void appendResultArea(String result) {
        resultArea.append(result);
    }
}
