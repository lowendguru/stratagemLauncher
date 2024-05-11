package temp;

import listener.NativeKeySenderJNI;
import main.MainWindow;

public class Test {

    public static void main(String[] args){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        NativeKeySenderJNI senderJNI = new NativeKeySenderJNI("wasdawasd");
        senderJNI.run();
    }

}
