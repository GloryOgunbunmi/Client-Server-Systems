import java.io.*; 
import java.net.*; 

class TCPClient{ 

    public static void main(String argv[]) throws Exception{ //must have a throws exception
        String sentence; 
        String modifiedSentence; 

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 

        //Socket clientSocket = new Socket("10.35.4.143", 6789); 
        Socket clientSocket = new Socket("127.0.0.1", 6789); //muct provide IP and port number- this IP represent local host/ same machine
          //if running on different machine must find the IP if them

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); //send output

	BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //reading in from server

        sentence = inFromUser.readLine(); //from standard import and stored

        outToServer.writeBytes(sentence + '\n'); //send to server

        modifiedSentence = inFromServer.readLine(); //read line from server- the modified sentence

        System.out.println("FROM SERVER: " + modifiedSentence); //displayes modified sentence

        clientSocket.close();  //terminates 
   } 
} 

