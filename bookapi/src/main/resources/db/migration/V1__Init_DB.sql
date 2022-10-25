    CREATE TABLE IF NOT EXISTS `author` (
        `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        `name` VARCHAR(100) NOT NULL,
        `day_of_birth` DATE NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 collate=utf8mb4_unicode_ci;

    CREATE TABLE IF NOT EXISTS `book` (
        `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        `author_id` BIGINT NOT NULL,
        `created_date` DATE NOT NULL,
        `description` TEXT NULL,
        `thumbnail` VARCHAR(255) NULL,
        `title` VARCHAR(255) NOT NULL,
        CONSTRAINT FK_BookAuthor FOREIGN KEY (`author_id`)
        REFERENCES author(`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 collate=utf8mb4_unicode_ci;