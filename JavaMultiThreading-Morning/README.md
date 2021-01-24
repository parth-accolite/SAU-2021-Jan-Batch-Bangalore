# Spring-AU-21-Assignment Question
Java Multi Threading Assignment

Design a Library Management System

Requirements

--------------------

1) Multiple students can have access to multiple books
2) If a student is reviewing a book then no other student can have access to that particular book but they can have access to other books.
3) If a student is adding a book into this cart then that book is also not available to others but if the student is not doing checkout, the book will release after 5 minutes from his cart and available for others to review or order.
4) Multiple copies of the book can be available in store. Each book should have it’s own identity number to avoid conflict but the same copies have the same ISBN number. 
5) Books can be added to the library at any point of time without impacting the business logic.
6) The available number of books and it’s owner should be consistent at all time.
7) There should be an one to one relationship between student and book.
8) A student can add more than one book to his cart. If he is doing a partial checkout then the remaining books should be available to others for review or checkout. But it will be available to others based on priority.