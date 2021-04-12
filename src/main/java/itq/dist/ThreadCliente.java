package itq.dist;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadCliente extends Thread{
	
	private static  final Logger logger = LogManager.getLogger(Client.class);

    static  final String HOST = "localhost";

    static  final int PORT = 2000;
    
    Request usuario;
	
	public ThreadCliente(Request usuario) {
		this.usuario = usuario;
	}
	
	public void run() {
		Socket clientSocket;
		logger.info("Inicia la ejecucion del cliente");
		try {
            clientSocket = new Socket(HOST, PORT);

          // Petición al servidor
            OutputStream outputStream = clientSocket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(usuario);

            logger.info("Se inicia la petición de " + usuario.liters + "L");
            
            InputStream inStream = clientSocket.getInputStream();
            DataInputStream dataIn = new DataInputStream(inStream);
            String serverResponse = dataIn.readUTF();

            logger.info(serverResponse);
            clientSocket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
