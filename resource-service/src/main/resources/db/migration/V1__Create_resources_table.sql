CREATE TABLE resources (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           type VARCHAR(255) NOT NULL,
                           quantity INT NOT NULL,
                           task_id BIGINT
);
