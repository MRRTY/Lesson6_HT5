import java.io.File;
import java.util.HashSet;

/**
 * Created by Greg on 05.02.2017.
 */
public class Observer implements Runnable {
    private File input;
    private HashSet<File> files = new HashSet<>();
    public Observer() {
    }

    public Observer(File input) {
        this.input = input;
        files = readFiles();
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while (true){
            try {
                thread.sleep(1000);
                status();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    private HashSet<File> readFiles(){
        HashSet<File> temp = new HashSet<>();
        for(File f: input.listFiles()){
            temp.add(f);
        }
        return temp;
    }
    private void status(){
        HashSet<File> current = readFiles();
        HashSet<File> newSet = new HashSet<>();
        newSet.addAll(current);
        newSet.removeAll(files);
        files.removeAll(current);
        if(!files.containsAll(current)){
            for(File f : newSet){
                System.out.println("File: "+ f.getName()+" was added");
            }
            for (File f: files) {
                System.out.println("File: "+ f.getName()+" was deleted");
            }
        }
        files = current;
    }
}
