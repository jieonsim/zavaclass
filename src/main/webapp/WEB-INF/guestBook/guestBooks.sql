show tables;

desc guestBooks;
desc categories;
desc places;
desc users;

drop table guestBooks;

select * from guestBooks;

CREATE TABLE guestBooks (
    guestBookIdx INT AUTO_INCREMENT PRIMARY KEY,
    userIdx INT NOT NULL,
    placeIdx INT NOT NULL,
    visitDate DATE NOT NULL,
    content TEXT,
    companions VARCHAR(255) NOT NULL,
    visibility ENUM('public', 'private') NOT NULL DEFAULT 'public',
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    hostIp VARCHAR(45),
    FOREIGN KEY (userIdx) REFERENCES users2 (userIdx),
    FOREIGN KEY (placeIdx) REFERENCES places (placeIdx) ON DELETE CASCADE
);

