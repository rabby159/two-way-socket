//Server site Md Rabby 213902124
//Computer Networking, CSE, Green University of Bangladesh

package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket (5005);
        System.out.println("Server is connected at port no: " + ss.getLocalPort());
        System.out.println("Server is connecting\n");
        System.out.println("Waiting for the client\n");
        
        Socket s = ss.accept();
        System.out.println("Client request is accepted at port no: " + s.getPort());
        System.out.println("Server’s Communication Port: "+s.getLocalPort());
        
        DataInputStream input = new DataInputStream(s.getInputStream());
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        
        BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
        
        String strFromClient = "", strToClient = "";
        
        
         while (!strFromClient.equals("stop")) {
            strFromClient = input.readUTF();
            System.out.println("Client Says: " + strFromClient);

            System.out.print("Enter your response: ");
            strToClient = clientInput.readLine();
            output.writeUTF(strToClient);
            output.flush();
        }

        input.close();
        output.close();
        s.close();
        ss.close();
            
    }
}
