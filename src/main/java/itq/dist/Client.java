package itq.dist;
import itq.dist.Request;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client {
    private static  final Logger logger = LogManager.getLogger(Client.class);

    static  final String HOST = "localhost";

    static  final int PORT = 2000;

    public static  void main(String[] args) {
    	
    logger.info("Inicia la ejecucion del cliente");
            
    int i = 0;
    while(i < 10) {
    	Request clientRequest = new Request(1000,1);
    	Thread hilo = new ThreadCliente(clientRequest);
    	hilo.start();
    	i++;
    }
        /*
         * Socket clientSocket = new Socket(HOST, PORT);

          // Petición al servidor
            OutputStream outputStream = clientSocket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(clientRequest);

            logger.info("Se inicia la petición de " + clientRequest.liters + "L");
            
            InputStream inStream = clientSocket.getInputStream();
            DataInputStream dataIn = new DataInputStream(inStream);
            String serverResponse = dataIn.readUTF();

            logger.info(serverResponse);
            clientSocket.close();

        } catch (UnknownHostException e) {
            logger.error("Ocurrio un error al intentar conectarse al host: [" + HOST + "] y puerto: [" + PORT + "]");
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("Ocurrio un error al establecer el canal de datos: [" + HOST + "] y puerto: [" + PORT + "]");
            e.printStackTrace();
        }
        */
        
    }
}
