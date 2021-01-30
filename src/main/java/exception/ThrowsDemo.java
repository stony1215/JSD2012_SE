package exception;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowsDemo {
    public void  dosome()throws IOException, AWTException{}
}
class Subclass extends ThrowsDemo{
//    public void dosome()throws IOException,AWTException{}
//    public void dosome(){}
//    public void dosome()throws IOException{}
    public void dosome()throws FileNotFoundException{
        System.out.println("刘威大SX");

    }
}
