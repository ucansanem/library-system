library-system
==============
In the project, you will create a database with large volume of data using a DBMS of your choice, and write SQL programs to populate, manipulate and query the database.  

Project requirements

1.  Collect or generate a large amount of data.
	For your data, design a relational database schema that consists of a number of tables. Some tables should reference other tables. Minimize the redundancy of the data in your tables.
Note that you should design your own database schema.
2.	Setup a database using a DBMS.
3.	Create software that allows users to manipulate the data. The software should have a clear purpose and a user-friendly interface. Users do not need to know the details of the database or the SQL language to manipulate the data.  
a.	The software should support user actions to query, update, add, and remove data from the database. The user actions may be involved in data in multiple tables.
b.	You can choose any programming language for your interface programs.  
c.	A SQL program is linked to a database using a library called connector. You will need to install a connector specific to the programming language and the database system you choose. 
4.	Run SQL commands for creating tables including primary keys and foreign keys.  Run SQL command files that populate each table.  Each table is required to have a sufficient number of tuples.  One of them must have more than 100 tuples. You should be able to run these command files successfully with no errors and no integrity violations. 
5.	Perform and illustrate all required tasks. 
 
Project report

1.	An description of the application
2.	An analysis of the database system and a conceptual design (ER-diagram) that includes
•	entity types, relationship types, and attributes.
•	key attributes.
•	structural constraints (cardinality ratios and participation constraints). 
3.	A logical design of the database (resulting by the mapping of the ER schema to a Relational schema). You should:
•	Illustrate how they are translated the ER diagram to a relational schema.  This translation  should follow the ER to Relational model algorithm. 
•	Identify primary and foreign keys. 
•	Show constraints (in words) over and above referential integrity constraints for each table.   
4.	A description of the creation of the database schema and instance. Provide the SQL commands that create your tables and populate your tables.
5.	A description of the application programs and all tasks. Provide source code.
6.	User guide
7.	Window snapshots of the use of the program

Project presentation:  You will present and demo your project in the last class. (May 2, 2013) 

Consider the operations of a library system in the different neighborhoods of a city. The library has many readers who borrow books from one of its many branches. The following are descriptions for a simplified library system.

1.	The library records information about books that are available in its system. Each book is identified by a unique number (BookId.) It also has a title, author,  an ISBN, a publisher, and a publication date. 
2.	Each book has a single publisher and the publisher address is also recorded.
3.	Information about the authors of books is maintained. An author is identified by a number (AuthorId.) The name of each author is also recorded. 
4.	The library system contains several branches, which are identified by a number (LibId). We also need to store the name and the location of each branch. Each branch of the library holds a number of copies of a particular book. Each copy of the same book kept by the same library branch is numbered from 1 to n. The total number of copies of each book in the library is needed. We also need to record the position of every copy in a branch. It is encoded by a string of 6 alphanumeric characters (e.g. 001A03 means the third shelve of bookcase A03).
5.	The library system keeps track of all readers who are uniquely identified by ReaderId. Each reader has a name, an address, and a phone number. A reader has to be registered in the database before borrowing a document.
6.	Readers have access to the online catalogue of books and may reserve books by title if they are available. A reserved book has to be picked up before 6 pm; otherwise, the reservation is cancelled. A reader cannot borrow or reserve more than 10 books.
7.	Borrowing is defined as taking out a copy of a book on one date and time (BDateTime) and returning it a maximum of 20 days later. RDateTime is the date and time on which the copy of the borrowed book is actually returned. (RDateTime is NULL if the document has not yet been returned). Books have to be returned to the branch from which they are borrowed.
8.	The same copy of a book can be reserved and/or borrowed by the same reader several times.
9.	Books that are not returned on time are fined at a rate of 20 cents for each day after the due date.
10.	A copy of a book cannot be lent to more than one reader at a time, but a reader can borrow multiple copies of books.

Your task is to design the database and application programs that will help manage the book inventory and the day-to-day processing. You can make further assumptions but: (a) they should not be in contradiction with the assumptions described above, and (b) they have to be clearly stated in your report. Note that many functions are left out in order to reduce the size and the complexity of the project. 

You are to develop a menu driven application system for the public library system database. The following are the menus to be developed.  All applications described below must be implemented.  If you want, you may add more functions and menus.
 
1. Main menu:
Reader functions (ask for card number, and then show sub-menu).
Administrative Functions (ask for ID and password, and then show submenu).
Quit.

2. Reader Functions Menu:
	Search a book by ID, title, or publisher name.
Book checkout
	Book return.
Book reserve
Compute fine for a book copy borrowed by a reader based on the current date.
Print the list of book reserved by a reader and their status.
Print the book id and titles of books published by a publisher.
Quit.

3. Administrative Functions Menu:
Add a book copy.
Search book copy and check its status.
Add new reader.
Print branch information (name and location).
Print top 10 most frequent borrowers in a branch and the number of books each has borrowed.
Print top 10 most borrowed books in a branch.
Find the average fine paid per reader.
Quit
