package SwingChallenge.src.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimilarityChecker {
    public static double compareFiles(File file1, File file2) throws IOException {
        List<String> content1 = Files.readAllLines(file1.toPath());
        List<String> content2 = Files.readAllLines(file2.toPath());

        Set<String> set1 = new HashSet<>(content1);
        Set<String> set2 = new HashSet<>(content2);

        // tìm phần chung giữa set1 and set2
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // chứa tất cả phần tử từ cả hai set1 and set2
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        return (double) intersection.size() / union.size();
    }

    public static void saveResult(Connection conn, String file1, String file2, double similarity) throws SQLException {
        String query = "INSERT INTO file_similarity (file1, file2, similarity) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, file1);
            stmt.setString(2, file2);
            stmt.setDouble(3, similarity * 100); // Store similarity as percentage
            stmt.executeUpdate();
        }
    }
}
