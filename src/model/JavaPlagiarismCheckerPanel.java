package SwingChallenge.src.model;

import SwingChallenge.src.control.CheckPlagiarismListener;
import SwingChallenge.src.control.LoadFileListener;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class JavaPlagiarismCheckerPanel extends JPanel {
    private JTextArea resultArea;
    private List<File> javaFiles;

    private Connection connection;

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

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/file_similarity", "root", "12345678");
            resultArea.append("Database connection established.\n");
        } catch (SQLException e) {
            resultArea.append("Failed to connect to database: " + e.getMessage() + "\n");
        }
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

    public Connection getConnection() {
        return connection;
    }
}
