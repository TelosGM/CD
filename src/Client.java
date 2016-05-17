import java.net.UnknownHostException;

/**
 * Created by javi3 on 29/04/2016.
 */
public class Client {

    public  Client (int Clientes){

        hilo [] th = new hilo[Clientes] ;
        for (int i=0; i<Clientes;i++){
            try {
                th[i]  = new hilo (25000/*+i*/);

            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        for (int i=0; i<Clientes;i++){

                th[i].run();


        }


    }
}
