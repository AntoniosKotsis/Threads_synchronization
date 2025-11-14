import java.util.Scanner;

// We manage 2 threads from class CountNumbersIR
// Two threads read from its file and implement calculations
public class ReadFilesRunnable 
{
    public static void main(String[] args) 
    {
        // User types 2 paths for files
        System.out.println("Type 2 paths:");
        // System.in constitutes the standard input stream
        Scanner scanner = new Scanner(System.in); // read from keyboard
        String path1 = scanner.nextLine();
        String path2 = scanner.nextLine();

        // creation 2 objects of class CountNumberIR which behave like as threads
        CountNumbersIR countNumbersIR1 = new CountNumbersIR(path1, "sum1");
        CountNumbersIR countNumbersIR2 = new CountNumbersIR(path2, "sum2");

        // We incorporate 2 objects of class CountNumberIR in constructors of class Thread
        Thread p1 = new Thread(countNumbersIR1);
        Thread p2 = new Thread(countNumbersIR2);

        // Threads p1,p2 starts
        // Threads p1,p2 executes the method run() of class CountNumbersIR
        p1.start();
        p2.start();   

        scanner.close(); // close resources object of class Scanner
    }    
}
