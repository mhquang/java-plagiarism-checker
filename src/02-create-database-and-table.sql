DROP SCHEMA IF EXISTS `file_similarity`;

CREATE SCHEMA `file_similarity`;
USE `file_similarity` ;

CREATE TABLE IF NOT EXISTS file_similarity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    file1 VARCHAR(255),
    file2 VARCHAR(255),
    similarity DECIMAL(5, 2)
);
