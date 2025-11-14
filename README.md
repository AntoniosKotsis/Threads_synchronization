Management threads (at least 2) with mechanisms synchronization

     The project is constituted from two classes. The class CountNumbersIR behaves like a thread because it implements the interface Runnable. This class contains the method run which
is required from interface Runnable. In this method, every thread which we create it in class ReadFilesRunnable manages the content of a file and appears all integer numbers, it 
calculates and appears the sum of these numbers. This class appears all above using a synchronized lock, particularly the class contains as a attribute a static final object of class
Object. This attribute is static which means that it is not belong in anything instance of class but it is belong in class. This attribute is final because we want to be stable. 
This attribute constitutes a shared attribute for objects of this class. We use this lock because we want appear the content of every file together and not ruffled elemnts of every
file. For this target we use the keyword synchronized so that elements of every file to appeared together and not ruffled. This block of data constitutes the critical section by which only one thread at a time can have access.  
    The class ReadFilesRunnable manages objects of class CountNumberIR. These objects behave like threads. When we create these objects we traverse them in constructors of class Thread
so that every thread to manage every object of class CountNumberIR as a single process with its space address of main memory. With this way we can run many program concurrently which
is called parallelism. The parallelism helps to manage and share resources of main memory in processes. This way is flexible for programs which consume many resources.   
