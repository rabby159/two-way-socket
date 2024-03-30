//Client site Md Rabby 213902124
//Computer Networking, CSE, Green University of Bangladesh


package client;

import java.io.IOException;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket ("localhost", 5005);
        System.out.println("Client Connected at server Handshaking port " + s.getPort());
        System.out.println("Client’s communcation port " + s.getLocalPort());
        System.out.println("Client is Connected");
        System.out.println("Enter the messages that you want to send and send \"stop\" to close the connection:");
        
        DataInputStream input = new DataInputStream(s.getInputStream());
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));

        String strToSend = "", strFromServer = "";

        while (!strToSend.equals("stop")) {
            System.out.print("Enter your message: ");
            strToSend = clientInput.readLine();
            output.writeUTF(strToSend);
            output.flush();

            strFromServer = input.readUTF();
            System.out.println("Server Says: " + strFromServer);
        }

        input.close();
        output.close();
        s.close();
    }
}
