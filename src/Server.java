import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by javi3 on 29/04/2016.
 */
public class Server extends Thread{
    private int section=0;
    MultiServerThread [] srvArr;
    ServerSocket [] ssocket ;
    int max=0;
    int width=0;
    int cntrl;

    public Server (int num) throws IOException {
            cntrl=num;
            MultiServerThread [] srvArr= new MultiServerThread[num];


        for (int i=0; i<num;i++){
            srvArr[i]=new MultiServerThread(25000/*+i*/);

        }
    }
    public synchronized  data giveData (){
        data dat = new data(section,width, max);
        section++;

        return dat;
    }

    @Override
    public void run() {
        for (int i=0; i<cntrl;i++){
            srvArr[i].run();

        }
    }
}
