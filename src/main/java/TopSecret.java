public class TopSecret {
    public static void main(String[] args) {

        String output;

        // If no arguments, print
        if (args.length == 0) {
            output = "No file selected.";
            System.out.println(output);
            ProgramControl.printFileList();
            return;
        }

        int fileNumber;
        try {
            fileNumber = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            output = "Error parsing file number.";
            System.out.println(output);
            return;
        }

        // Request chosen file with default key
        if (args.length == 1) {
            output = "Using default key.";
            System.out.println(output);
            try {
                System.out.println(ProgramControl.runProgram(fileNumber, null));
            } catch (Exception e) {
                System.out.println("Error calling Program Control.");
            }
            return;
        }

        // Request chosen file with given key
        if (args.length == 2) {
            output = "Using provided key.";
            System.out.println(output);
            String cipherDir = args[1];
            try {
                System.out.println(ProgramControl.runProgram(fileNumber, cipherDir));
            } catch (Exception e) {
                System.out.println("Error calling Program Control.");
            }
            return;
        }

        output = "Error: Too many arguments.";
        System.out.println(output);
    }
}
