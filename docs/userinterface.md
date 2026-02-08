`Michael Kent`
`cgd9th`
# Homework 2 - User Interface
## About
Your assignment is to create a command-line utility that will allow agents to view file contents.

Create the command line interface used by the user to run the program.

When the program runs with no arguments, it should list the numbered files available to display. E.g.:

01 filea.txt

02 fileb.txt

03 filec.txt

When the program runs with a number as an argument, the contents of the corresponding file is displayed on screen.

In the absence of a second parameter, the program uses the default key for deciphering. However, a second parameter can be supplied that specifies an alternate key to use when deciphering.

The program exits after showing the file list, the contents of an indicated file, or after displaying an error message. 

## Pseudocode:
Accept arguments
    test if arguments are valid, returning an appropriate error if encountered

If no arguments
    invoke filehandler function to print available files

If 1-2 arguments
    check if input files are valid
    pass both arguments to program control, even if arg2 is empty

Else return error

## Tests:
Test invalid inputs:
    garbage arguments
        one garbage
        one garbage, one legit, for both arguments
        two garbage
    too many arguments