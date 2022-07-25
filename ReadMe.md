** Trigram text Processing
This code solves the genration of mutated text on basis of trigram algorithm

** Overview and Guide
This program is able to read .txt input text and generate random, custom- length, text.

This Program is developed using java 1.8 and it is a maven project
This program can be loaded to IDE and operated through Console
This can also be packaged as jar and execute

**User Inputs:-
User are required to place the file for which mutated text is to be generated inside inputData Folder.
On console they need to select the file from  inputData Folder.

** Classes and Usage:-
ClientImplementaion.java contains main method and responsible for calling all the functionalitis within,
FileOperations.java handles I/O operations 
MutatedTextGenerator generated the text based on trigaram
TrigramGenerator is responsible for creating logic of trigram and putting the data in Map for text generation
Utils package contains common constant and helper methods for logging Working with User input and formatting input text


**Note- This program takes file as input and removes all the special chracters  from them and processes it.
In case of more than one value is possible for given key (two consecutive words from text) we are selecting randon value 

**
