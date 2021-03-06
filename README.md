# CS2820 Fall 2021 WARP Project Code
This code base will be used for the University of Iowa CS 2820 Introduction to Software
Development course. The code was developed by Steve Goddard for the WARP sensor network 
research project. It was first written in Swift and rewritten in Java. It was then rewritten again in an object-oriented programming style. It was a quick
hack, and it needs a lot of cleanup and refactoring. A perfect code base to teach
the value of software developement fundamentals!

Student Edit: This is a description to remind you that in order for your output files to be located in the directory OutputFiles you need to include
the -o flag option in the program arguments box, located in the run configurations tab. This is the basic structure for using any flag, but remember 
that certain flags might require arguments.


Student Edit (10/13/21): Generated some UML diagrams for Reliability*.java, WorkLoad.java, and SchedulableObject.java files. I also added a public method, 
with return type ReliabilityTable, to ReliabilityAnalysis.java through its class box diagram. 

Student Edit (10/27/21): Refactored nTxPerLinkAndTotalTxCost and getFixedTxPerLinkAndTotalTxCost methods into ReliabilityAnalysis.java. ReliabilityAnalysis
constructors were also made, JavaDocs generated, and UML diagrams updated. 

<br>
Sprint 1 Summary: 
This sprint we focused on getting a better understanding of the code. After meeting with Professor Goddard, we decided 
that the way to go was to produce as many artifacts as possible to represent our comprehension and give in idea to the 
direction we are headed for Sprint Two. Our goal for the next sprint is to implement ReliabilityVisualization.java, as 
as you can see from our Reliability UML diagram, we've began thinking on how we might achieve this by adding a couple 
of the methods we feel might be crucial.<br>

Some of the files we included/updated with this sprint are:<br>
-ReliabilityVisualization_Garcia.png<br>
-ReliabilityAnalysis_Sequence_Diagram.png<br>
-raFileGeneration_Morris.png<br>
-SequenceDiagram_Culkeen.png<br>
-raFileGenerationNotes_Morris.txt (Notes from our meeting w/ Professor Goddard)<br>
-Reliability.umlcd<br>
-ReliabilityVisualization.java<br>


Sprint 2 Summary:
This sprint we started by implementing ReliabilityVisualization.java; createHeader() and visualization() are working as of now,
which can be seen by some of test cases we have made. In ReliabilityAnalysis.java the getReliabilities() function was implemented
so that it now creates a dummy table filled with 0.0s We also added a ReliabilityTest.java file, with some unit tests to 
validate that the numTxPerLinkAndTotalCost() and getHeader() functions are returning proper values. We also added a test case for
visualization(), but as of now it does not pass because we've only implemented a dummy table, we expect that once we work out
algorithms it should pass as planned. JavaDocs were also generated to document the methods we have implemented. Our goal for 
the next sprint will probably include figuring out the algorithm to produce the correct values in our ReliabilityTable and 
implementing verifyReliabilities(). 

Some of the files we included/updated/added with this sprint are:<br>
-ReliabilityVisualization.java<br>
-ReliabilityAnalysis.java<br>
-ReliabilityTest.java<br>
-newly generated JavaDocs<br>
<br>

Sprint 3 Summary:<br>
For our final sprint, I think we can confidently say that we have completed the project. In Sprint3 our main focus was to build an
accurate reliabilityTable, coming into it we had a working file visualization implementation, so we just had to figure out the table
algorithms and how to build it correctly. While getReliabilities is the method that builds the resulting table, in order to produce 
cleaner code we created a number of helper functions that should be seen from both the .java file and our updated UML diagrams. Another
important function implemented was verifyReliabilties. The verifyReliabilities function makes sure the table created meets the given E2E criteria. Additional 
deliverables for this sprint include our javaDOC files, updated UML diagrams, and a .java file that houses all our tests. The way that
we approached testing was by taking a number of the graph .txt files we were given and testing the following for each (tested cases that did and didn't have numFaults):<br>
 -if the file header was created successfully <br>
 -the accuracy of our reliabilityTable<br>
 -whether our verifyReliabilities function returned the expected boolean values<br>
<br>
Some of the files we included/updated with this sprint are:<br>
-ReliabilityVisualization.java<br>
-ReliabilityAnalysis.java<br>
-ReliabilityTests.java<br>
-newly generated JavaDocs<br>
-updated UML Diagrams that include updated components of ReliabilityAnalysis and ReliabilityVisualization
