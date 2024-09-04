CREATE TABLE user (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(191) NOT NULL UNIQUE,
                      email VARCHAR(191),
                      password VARCHAR(191) NOT NULL,
                      role VARCHAR(50) NOT NULL
);
