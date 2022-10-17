<H1>Development of a Library System (V1.0)</H1>
Our team’s project is focused on the creation of a library system that primarily focuses on the borrowing feature of a library. The library system will be created as an app as we believe the mobility of a mobile device is handy for librarians that want to check and see book. Furthermore, our application is centred around 5 main features. Our primary feature will be the ability to check in and check out, this system will function around our book database that tracks our stock of books. Aside from borrowing and returning books, we also want to implement a simple filtering tool. There is another feature we decided to implement, which is the idea of an individual account. Users and administrators will have their own accounts, each with different access levels. Administrators have access to the addition and removal of borrowable books in the database of books. To support the library in terms of its security, we have decided to implement a tracking system for books. If a person has borrowed 2 books or an overdue book (books borrowed for over 2 weeks) they are unable to borrow more. Our databases will use a file-based system for our first iteration of this project. <br/>
<H2>Class Organization</H2>

![alt text](https://github.com/310g17/librarySystem/blob/main/rscforReadme/Class%20Organization%20Structure.jpg)<br/>

Shown above is how our classes are organized in the library system. The methods used for each class is as follows: <br/>
<H3>Main Method: main.java </H3><br/>
Login function is implemented in the main method. It checks both the username and password inputted by users directly with current database information. If successful allows the user to login, if incorrect it prompts users to try again.  <br/>

showOptions(int access). Method to show options (0 to terminate , 1 to borrow books, 2 to return, 3 check status, 4 add books, 5 remove books).

DoWhat(int choice, Account_abstract currentUser, library l1). Method to prompt users what to do. Asks users to input a given set of integers to choose from. Upon choosing a function and number it sends users into the specific function (0 to terminate , 1 to borrow books, 2 to return, 3 check status, 4 add books, 5 remove books). <br/>

bBook(Account_abstract currentUser, library l1). Method to borrow books. Shows all available books and prompts users to choose. <br/>

rBook(Account_abstract currentUser, library l1). Method to return books, upon returning a book calls the abstract's return book method to show all late fees associated. <br/>

setIndex(ArrayList<accountDatabase> DBData, String username). Method associated with the login. Checks username index in array of login information.<br/>

uMatching(ArrayList<accountDatabase> DBData, String username). Method associated with login. Checks username. <br/>
  
pMatching(ArrayList<accountDatabase> DBData, String password, int index). Method associated with login. Checks password. <br/>
  
<H3> User abstract: Account_abstract.java </H3><br/>
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

<H3>User Class: User.java - Subclass of User </H3><br/>


<H2>Our Work Breakdown Structure</H2>
Highlighting our team's distribution of responsibilities, we've created a work breakdown structure (WBS) to further help with the project management.<br/>

![alt text](https://github.com/310g17/librarySystem/blob/main/rscforReadme/WBS.png) <br/>

Our Work Breakdown Structure highlights the distribution of responsibilities and the general structure of how our code is going to function. The account classes and abstract was coded by Adrian and Kevin. They wrote the general structure of how accounts are used in the library system as well as the methods associated with it. Furthermore, Adrian and Kevin created the main method. Henry and Mete were in charge of the databases and the database connection we were going to have. The database classes for books and accounts were created to both read and write the csv file that acted as our on file database system. <br/>
<H2>Gantt Chart and Scheduling Our Project</H2>
For our project listed below is a rough estimation for the development of this project. This Gantt chart would hopefully help in estimating and guiding our development. <br/>

![alt text](https://github.com/310g17/librarySystem/blob/main/rscforReadme/GanntChart_Final.jpeg) <br/>

Following our development cycle phases, we’ve created an outline of what we are going to do using a Gantt chart. Project will be separated into 4 phases as initially described, however, here we can highlight the dependencies of the project. For one our database needs to be designed and finished before we move on to the development of individual classes/objects. Furthermore, our user interface is also highly dependent on the completion of our database and classes. However, as we have designed a Gantt chart this does not mean we have to follow the structure exactly. It exists as a guide, we are still under an agile development SDLC. We will still interleave our development but the Gantt chart exists to act as a rough visualization of our overall development. As for the timing, we believe our initial build of the software would not take too long. It can easily be accomplished within the time frame of about 2-3 weeks. Therefore, our development would take a short amount of time. However, we believe that future iterations would have to improve on our overall code. Since that is the case, we will spend the most amount of time in our software evolution phase as we want to further develop our software. <br/>
