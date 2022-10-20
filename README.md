<H1>Development of a Library System (V1.0)</H1>
Our team’s project is focused on the creation of a library system that primarily focuses on the borrowing feature of a library. The library system will be created as an app as we believe the mobility of a mobile device is handy for librarians that want to check and see book. Furthermore, our application is centred around 5 main features. Our primary feature will be the ability to check in and check out, this system will function around our book database that tracks our stock of books. Aside from borrowing and returning books, we also want to implement a simple filtering tool. There is another feature we decided to implement, which is the idea of an individual account. Users and administrators will have their own accounts, each with different access levels. Administrators have access to the addition and removal of borrowable books in the database of books. To support the library in terms of its security, we have decided to implement a tracking system for books. If a person has borrowed 2 books or an overdue book (books borrowed for over 2 weeks) they are unable to borrow more. Our databases will use a file-based system for our first iteration of this project. <br/>

<br/>

First iteration has backlogged filtering due to file based database system constraints and time constraints. Filtering will be implemented in future iterations of the project. <br/>

Upon loading code onto device, filepaths in the main and Account_abstract class must be changed to appropriate filepaths. More instructions are on the code as a comment.

<H2>Class Organization</H2>

![alt text](https://github.com/310g17/librarySystem/blob/main/rscforReadme/Class%20Organization%20Structure.jpg)<br/>

Shown above is how our classes are organized in the library system. The source code can be found under the librarySystem filed. The methods used for each class is as follows: <br/>
<H3>Main Method: main.java </H3><br/>
The main method is the method that users will interact with. IMPORTANT: FILEPATHS MUST BE REINPUTTED TO MATCH USER DIRECTORIES, THERE ARE TWO FILES: bookDB_new.csv and userDB - userDB w String.csv </br>

Login function is implemented in the main method. It checks both the username and password inputted by users directly with current database information. If successful allows the user to login, if incorrect it prompts users to try again.  <br/>

showOptions(int access). Method to show options (0 to terminate , 1 to borrow books, 2 to return, 3 check status, 4 add books, 5 remove books).

DoWhat(int choice, Account_abstract currentUser, library l1). Method to prompt users what to do. Asks users to input a given set of integers to choose from. Upon choosing a function and number it sends users into the specific function (0 to terminate , 1 to borrow books, 2 to return, 3 check status, 4 add books, 5 remove books). <br/>

bBook(Account_abstract currentUser, library l1). Method to borrow books. Shows all available books and prompts users to choose. <br/>

rBook(Account_abstract currentUser, library l1). Method to return books, upon returning a book calls the abstract's return book method to show all late fees associated. <br/>

setIndex(ArrayList<accountDatabase> DBData, String username). Method associated with the login. Checks username index in array of login information.<br/>

uMatching(ArrayList<accountDatabase> DBData, String username). Method associated with login. Checks username. <br/>
  
pMatching(ArrayList<accountDatabase> DBData, String password, int index). Method associated with login. Checks password. <br/>
  
<H3> User abstract: Account_abstract.java </H3><br/>
 The user abstract is the blue print for both our account types, the user account and library administrator account. <br/>
Account_abstract(int UID, String name, String password, String[] borrowedBooks, int access, LocalDate[] dateBor); A constructor that will be used by the Admin subclass and user subclass. <br/>

General getters and setters for the values. <br/>

borrowBook(String bookName). This method will show users the available books and lets users borrow any available books under the right conditions. Users that have 2 borrowed books or an overdue book cannot borrow another book. References a helper method (borrowDateTrack [to keep track of the days borrowed and overall fees], this method also references another method dateBookMatch that helps find the proper book index). <br/>

returnBook(String bookName). This method will allow users to return books based on the book title. It prevents false returns (when they want to return books that they don't have). Returning books will free up a space in their available book slots. It will also charge users who have overdue books by showing a fee that is calculated by multiplying the days overdue by 2. This method references two helper methods (payLateFees and bookReturn), resepctively calculating the late fees and tracking dates (which calls dateBookMatch and dateTracking). <br/>

addAccount(int uid, String uname, String pwd, int lvl). This method allows for the creation of new accounts by adding it to the database. <br/>

updateAccountDB(accountDatabase a). This method allows for the changing of specific aspects of the accounts in the database. <br/>

addBook(int ISBN, String name, String author, String date, String genre, int qty, boolean borrowed). This method allows for the addition of new books to the database. Currently only allowed by library admins. <br/>

removeBook(int ISBN). This method is used to remove books. <br/>

updateBookDB(book b). This method is used to update specific aspects of the book. <br/>

<H3>Admin class: Admin.java - Subclass of User</H3> <br/>
Admin(int UID, String name, String password, String[] borrowedBooks, LocalDate[] dateBor). Method to create an Admin object. Calls super of the account abstract. <br/>
addBook(String book). Method to add a book, accessible by the library admin class for now. <br/>
removeBook(String book). Method to remove books, accessible by the library admin class for now. </br>

 <H3>User Class: User.java - Subclass of User </H3><br/>
User(int UID, String name, String password, String[] borrowedBooks, LocalDate[] dateBor). Method to create a User boject. Calls super of the account abstract. <br/>
  
  <H3> Account Database:  accountDatabase.java</H3><br/>
   This code consist of 1 empty constructor that will initialize default value (0,-1 or null) to the appropriate attributes and a constructor that takes all attributes as it's parameter. <br/>
   <br/>readDB(String path) method will take path as it's parameter and will read csv file that contains dummy database and read it line by line. Each value will be split using (,) delimeter and store it in an arraylist which later on are used to create objects based on the value/attributes. <br/>
  <br/> setBook(int index, String newBook) will take an index of the user that are stored in the arraylist of objects and set either book1 or book2 attribute to the new value. **Note: Because our csv file is still small, we could still use an index to find the object. However, we will change the method in the future to get the index by itself (using getter)** <br/>
  <br/>removeBook(int index, String oldbook) same as the ssetBook(int index, String newBook) method, it will still take an index and string to remove book from user. This method will compare either book1 or book2 of the user and remove it. **Note: Because our csv file is still small, we could still use an index to find the object. However, we will change the method in the future to get the index by itself (using getter)** <br/>

 <br/><H3>library Class: library.java </H3><br/>
Library class is where the information of all the books stored.<br/>
<br/>addDB(String path) This method will take the file path as a string and stores the information in the file as book classes in an arraylist called books. It reads the file line by line and splits the values to the strings and changes their data types to create a book class. <br/>
<br/>addBook(int ISBN,String name, String author, int year, String genre, int qty, boolean borrowed,int originalAmt,String path) This method adds a book to the books arraylist<br/>
<br/>removeBook(int ISBN) This method finds the book by its ISBN number and removes it from the books arraylist.<br/>
<br/>returnBook(int ISBN) This method finds the book by its ISBN number and changes its borrowed value to false.<br/>
<br/>borrowBook(int ISBN) This method finds the book by its ISBN number and changes its borrowed value to true.<br/>
<br/>findIndex(int ISBN) This method finds the index of the book in the arraylist by its ISBN number.<br/>

<H3>book Class: book.java </H3><br/>
This class is the blueprint for the books that stored in the library. It has one empty constructer and one with all the parameters.<br/>
<br/> book(int ISBN,String name, String author, int year, String genre, int qty,boolean borrowed, int originalAmt) constructer with the parameters.<br/>

<H2>Our Work Breakdown Structure</H2>
Highlighting our team's distribution of responsibilities, we've created a work breakdown structure (WBS) to further help with the project management.<br/>

<br/>![alt text](https://github.com/310g17/librarySystem/blob/main/rscforReadme/WBS.png) <br/>

Our Work Breakdown Structure highlights the distribution of responsibilities and the general structure of how our code is going to function. The account classes and abstract was coded by Adrian and Kevin. They wrote the general structure of how accounts are used in the library system as well as the methods associated with it. Furthermore, Adrian and Kevin created the main method. Henry and Mete were in charge of the databases and the database connection we were going to have. The database classes for books and accounts were created to both read and write the csv file that acted as our on file database system. <br/>
<H2>Gantt Chart and Scheduling Our Project</H2>
For our project listed below is a rough estimation for the development of this project. This Gantt chart would hopefully help in estimating and guiding our development. <br/>

![alt text](https://github.com/310g17/librarySystem/blob/main/rscforReadme/GanntChart_Final.jpeg) <br/>

Following our development cycle phases, we’ve created an outline of what we are going to do using a Gantt chart. Project will be separated into 4 phases as initially described, however, here we can highlight the dependencies of the project. For one our database needs to be designed and finished before we move on to the development of individual classes/objects. Furthermore, our user interface is also highly dependent on the completion of our database and classes. However, as we have designed a Gantt chart this does not mean we have to follow the structure exactly. It exists as a guide, we are still under an agile development SDLC. We will still interleave our development but the Gantt chart exists to act as a rough visualization of our overall development. As for the timing, we believe our initial build of the software would not take too long. It can easily be accomplished within the time frame of about 2-3 weeks. Therefore, our development would take a short amount of time. However, we believe that future iterations would have to improve on our overall code. Since that is the case, we will spend the most amount of time in our software evolution phase as we want to further develop our software. <br/>
