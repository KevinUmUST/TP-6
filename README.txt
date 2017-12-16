README
Team Project TP-6
Exploration and Beginning Implementation
SEIS 635 Software Analysis and Design
University of St. Thomas

December 16, 2017

Group: Kevin Um, Justin Hui, Sheng Lor
===============================================================================


SEIS 635 FINAL PROJECT SOURCE
===============================================================================
Location is at https://github.com/KevinUmUST/TP-6/.


GROUP MEMBER REPOSITORIES
===============================================================================
Group Members:
- Kevin Um
https://github.com/KevinUmUST

- Justin Siu-Ting Hui
https://github.com/huixx058

- Sheng Lor
https://github.com/Gnenie-shi


HOW TO INSTALL
===============================================================================
1.	Download the zip file “SEIS 635 Final Project Source - Um-Hui-Lor”. 
2.	Open Eclipse IDE.
3.	Select File -> Import…
4.	In the Import dialogue box, select Projects from File System or 
	Archive.
5.	Select the Archive… button and point to the zip file downloaded in 
	Step 1.
6.	Select Finish.


HOW TO RUN APPLICATION
===============================================================================
1.	Open TRLApp.java by double clicking it in the Package Manager under 
	TP_final -> main -> app -> TRLApp.java.
2.	From the menu, Select Run -> Run. 
3.	View the console for output. 

HOW TO RUN UNIT TEST SUITE
===============================================================================
1.	Open TRLApp.java by double clicking it in the Package Manager under 
	TP_final -> test -> test -> AllTests.java.
2.	From the menu, Select Run -> Run. 
3.	View the console for output. 

HOW TO RUN COVERAGE ANALYSIS
===============================================================================
0. 	Ensure ECLEmma addon is installed into Eclipse.
1.	Open TRLApp.java by double clicking it in the Package Manager under 
	TP_final -> test -> test -> AllTests.java.
2.	From the menu, Select Run -> Coverage. 
3.	View the console for output. 

ARTIFACTS
===============================================================================
Refer to repository and presentation for artifacts and further descriptions. 

Code Smells
-----------
View the commits for each code smell here: 
https://github.com/KevinUmUST/TP-6/search?q=code+smell&type=Commits&utf8=%E2%9C%93

1. Removed Extra and Dead Code
2. Commonized Redundant Code
3. Removed Magic Numbers and Added a Constants Class/Container

Documentation
-------------
- We documented the code, test, and gui source 
- We included a HELP option in the Application main menu
- We used Javadocs to generate documentation. See the docs:
https://htmlpreview.github.io/?https://github.com/KevinUmUST/TP-6/blob/master/doc/index.html

Class Diagram
-------------
We reverse engineered a class diagram using the ObjectAid Eclipse plugin. It
shows the classes we have implemented and the relationships between them. It
was automatically generated or reverse-engineered by looking at the existing 
code and generating the diagram from the code. 

Find the class diagram at
https://github.com/KevinUmUST/TP-6/blob/master/TRL%20Class%20Diagram.pdf

Testing and Coverage
--------------------
We used JUnit to perform unit tests and test suites on our source. Refer to
HOW TO RUN UNIT TEST SUITE.

We used ECLEmma Eclipse plugin to perform coverage analysis, which shows how 
much of the source is covered or tested by the unit test suite. Our coverage 
analysis includes the TRL logic and GUI source files.

Coverage Rate: 91.5%. 

Refer to HOW TO RUN COVERAGE ANALYSIS.

