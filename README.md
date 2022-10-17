<H1>Development of a Library System (V1.0)</H1>
Our team’s project is focused on the creation of a library system that primarily focuses on the borrowing feature of a library. The library system will be created as an app as we believe the mobility of a mobile device is handy for librarians that want to check and see book. Furthermore, our application is centred around 5 main features. Our primary feature will be the ability to check in and check out, this system will function around our book database that tracks our stock of books. Aside from borrowing and returning books, we also want to implement a simple filtering tool. There is another feature we decided to implement, which is the idea of an individual account. Users and administrators will have their own accounts, each with different access levels. Administrators have access to the addition and removal of borrowable books in the database of books. To support the library in terms of its security, we have decided to implement a tracking system for books. If a person has borrowed 2 books or an overdue book (books borrowed for over 2 weeks) they are unable to borrow more. Our databases will use a file-based system for our first iteration of this project. <br/>
<H2>Class Organization</H2>

![alt text](https://github.com/310g17/librarySystem/blob/main/rscforReadme/Class%20Organization%20Structure.jpg)<br/>

Shown above is how our classes are organized in the library system. The methods used for each class is as follows: <br/>
mainMethod: <br/>
*add something here** <br/>

User abstract: <br/>
login(); <br/>
etc etc

Admin class: Subclass of User <br/>

User Class: Subclass of User <br/>


<H2>Our Work Breakdown Structure</H2>
Highlighting our team's distribution of responsibilities, we've created a work breakdown structure (WBS) to further help with the project management.<br/>
![alt text](https://github.com/310g17/librarySystem/blob/main/rscforReadme/WBS.png) <br/>

Our Work Breakdown Structure highlights the distribution of responsibilities and the general structure of how our code is going to function. The account classes and abstract was coded by Adrian and Kevin. They wrote the general structure of how accounts are used in the library system as well as the methods associated with it. Furthermore, Adrian and Kevin created the main method. Henry and Mete were in charge of the databases and the database connection we were going to have. The database classes for books and accounts were created to both read and write the csv file that acted as our on file database system. <br/>
<H2>Gantt Chart and Scheduling Our Project</H2>
For our project listed below is a rough estimation for the development of this project. This Gantt chart would hopefully help in estimating and guiding our development.
![alt text](https://github.com/310g17/librarySystem/blob/main/rscforReadme/GanntChart_Final.jpeg) <br/>

Following our development cycle phases, we’ve created an outline of what we are going to do using a Gantt chart. Project will be separated into 4 phases as initially described, however, here we can highlight the dependencies of the project. For one our database needs to be designed and finished before we move on to the development of individual classes/objects. Furthermore, our user interface is also highly dependent on the completion of our database and classes. However, as we have designed a Gantt chart this does not mean we have to follow the structure exactly. It exists as a guide, we are still under an agile development SDLC. We will still interleave our development but the Gantt chart exists to act as a rough visualization of our overall development. As for the timing, we believe our initial build of the software would not take too long. It can easily be accomplished within the time frame of about 2-3 weeks. Therefore, our development would take a short amount of time. However, we believe that future iterations would have to improve on our overall code. Since that is the case, we will spend the most amount of time in our software evolution phase as we want to further develop our software. <br/>
