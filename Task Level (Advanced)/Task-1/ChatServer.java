import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9999);
            Socket client = server.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintStream ps = new PrintStream(client.getOutputStream());

            String receivedMessage;
            while (true) {
                receivedMessage = clientReader.readLine();
                if (receivedMessage == null || receivedMessage.equalsIgnoreCase("end")) {
                    break;
                }
                System.out.println("From client: " + receivedMessage);
                System.out.print("To client: ");
                String response = br.readLine();
                ps.println(response);
                if (response.equalsIgnoreCase("end")) {
                    break;
                }
            }

            ps.close();
            clientReader.close();
            br.close();
            client.close();
            server.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}