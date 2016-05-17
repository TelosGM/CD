import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 * Created by javi3 on 29/04/2016.
 */

public class hilo implements Runnable{
    private  Socket socket;
    private int port;
    private int [][] draw;
    private int i;
    private int j;
    private int max;
    DataInputStream input;
    DataOutputStream output;
    boolean end =false;
    BufferedReader in;


    public hilo (int puerto ) throws UnknownHostException {
        port=puerto;

    }

    public void setHilo (int [][] d,int in, int jn, int m){
          draw=d;
          i=in;
          j=jn;
          max=m;
    }

    public int [][] mandel (int [][] draw,int i, int j, int max){
        int aux [][]=draw;
        for (int row = 0; row < j; row++) {
            for (int col = 0; col < i; col++) {
                double c_re = (col - i/2.0)*4.0/i;
                double c_im = (row - j/2.0)*4.0/i;
                double x = 0, y = 0;
                int iteration = 0;
                while (x*x+y*y <= 4 && iteration < max) {
                    double x_new = x*x - y*y + c_re;
                    y = 2*x*y + c_im;
                    x = x_new;
                    iteration++;
                }
                if (iteration < max){
                    aux [row][col]=0;
                    }
                else {
                    aux [row][col]=1;
                }

            }
        }
        return aux;
    }



    public void run() {

        try {
            socket = new Socket(InetAddress.getLocalHost(),6000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (end!=true){




            int [][] arr;


        arr=mandel(  draw, i,  j,  max);


           /* try {
                output = new  DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }*/


            try {
                in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                System.out.print(in.read());
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }
}
