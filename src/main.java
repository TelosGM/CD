import java.io.IOException;

/**
 * Created by javi3 on 29/04/2016.
 */
public class main {

    public static void main(String[] args) throws IOException {
    int clientes=1;
    String ip = "localhost";


    Server serv = new Server(clientes);


    Client client = new Client(clientes);



    }
}
