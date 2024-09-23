CREATE USER 'javaswing'@'localhost' IDENTIFIED BY 'javaswing';

GRANT ALL PRIVILEGES ON file_similarity.* TO 'javaswing'@'localhost';

ALTER USER 'javaswing'@'localhost' IDENTIFIED WITH mysql_native_password BY 'javaswing';
