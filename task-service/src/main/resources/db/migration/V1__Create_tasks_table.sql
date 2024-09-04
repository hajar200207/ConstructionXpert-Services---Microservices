CREATE TABLE tasks (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       description VARCHAR(255) NOT NULL,
                       start_date DATE,
                       end_date DATE,
                       status VARCHAR(50),
                       project_id BIGINT
);
