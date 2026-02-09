public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            ProgramControl.printFileList();
            return;
        }

        int fileNumber;
        try {
            fileNumber = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing file number.");
            System.exit(1);
            return;
        }

        if (args.length == 1) {
            ProgramControl.runProgram(fileNumber, null);
            return;
        }

        if (args.length == 2) {
            String cipherDir = args[1];
            ProgramControl.runProgram(fileNumber, cipherDir);
            return;
        }

        System.out.println("Error: Too many arguments.");
        System.exit(1);
    }
}