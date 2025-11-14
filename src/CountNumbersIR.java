import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

// We create a class that implements Runnable interface
// The class behave like a thread
public class CountNumbersIR implements Runnable 
{
    private String pathFile; // path of file
    private String nameThread; // name of Thread

    // We declare a static final object of class Object as attribute
    // This attribute constitutes a lock for a critical section (shared resource)
    private static final Object lock = new Object(); 

    public CountNumbersIR(String pathFile,String nameThread)
    {
        this.pathFile = pathFile;
        this.nameThread = nameThread;
    }

    // This mehod is non implemented from interface Runnable
    // Every thread executes its code in this method
    public void run()
    {
            // try-with resources
            // No need to use block finally because resources arec closed automatically
            try(FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) 
            {
                String line;
                int number;
                int sum = 0;
                // We use an ArrayList so as to appear elements of every file together
                ArrayList<Integer> totalNumbers = new ArrayList<Integer>();
                while( (line = bufferedReader.readLine()) != null )
                {
                    number = Integer.parseInt(line); // parse strings to integers
                    totalNumbers.add(number);
                    sum = sum + number; // calculation sum of integers
                }
                synchronized(lock) // synchronized block (critical section)
                {
                    // No ruffled output
                    // Every thread prints separately the output of its file
                    for(int num : totalNumbers)
                    {
                        System.out.println(num); 
                    }

                    System.out.println("Sum of " + nameThread + ": " + sum);
                    System.out.println();
                }
            } 
            catch (Exception e) // FileReader & BufferedReader throw IOException, FileNotFoundException
            {
                // Stack Trace is a list with methods which meet in exception throwing point
                e.printStackTrace();
            }
    }
}

