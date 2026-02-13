`Michael Kent`
`cgd9th`
# Homework 2 - User Interface
## About
Your assignment is to create a command-line utility that will allow agents to view file contents.

Create the command line interface used by the user to run the program.

When the program runs with no arguments, it should list the numbered files available to display. E.g.:

01 fileA.txt

02 fileB.txt

03 fileC.txt

When the program runs with a number as an argument, the contents of the corresponding file is displayed on screen.

In the absence of a second parameter, the program uses the default key for deciphering. However, a second parameter can be supplied that specifies an alternate key to use when deciphering.

The program exits after showing the file list, the contents of an indicated file, or after displaying an error message. 

## Pseudocode:
CLI will be in the main function.

Accept arguments
    test if arguments are valid, returning an appropriate error if encountered

If no arguments
    invoke filehandler function to print available files

If 1-2 arguments
    check if input files are valid
    pass both arguments to program control, even if arg2 is empty

Else return error

## Tests:
Tests for when:
    - the first argument is not a number
    - no arguments given
    - too many arguments