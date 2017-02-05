import java.io.File;

/**
 * Created by Greg on 05.02.2017.
 */
public class Main {
    public static void main(String[] args){
        Thread t = new Thread(new Observer(new File("C:/Users/Greg/Desktop/input")));
        t.start();
    }
}
