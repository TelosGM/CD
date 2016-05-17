import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by javi3 on 06/05/2016.
 */
public class MultiServerThread extends Thread {
    private Socket socket = null;
    private ServerSocket ssocket ;
    DataInputStream input;
    DataOutputStream output;
    data dat;
    int puerto;

    public MultiServerThread(int p)  {

       puerto=p;
    }


    public void run() {

        try {
            this.ssocket= new ServerSocket(6000);

        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true) {
            try {
                this.socket = ssocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            PrintWriter out = null;
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //input = new DataInputStream(socket.getInputStream());

            dat = new data(5, 5, 5);
            out.write(dat.getI());

        }




    }
}