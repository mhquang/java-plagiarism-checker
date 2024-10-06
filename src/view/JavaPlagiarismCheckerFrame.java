package SwingChallenge.src.view;

import javax.swing.*;

public class JavaPlagiarismCheckerFrame extends JFrame {
    public JavaPlagiarismCheckerFrame() {
        this.setTitle("Java Plagiarism Checker");
        this.setSize(600,400);
        this.setLocation(500,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JavaPlagiarismCheckerPanel panel = new JavaPlagiarismCheckerPanel();
        this.add(panel);
    }
}
