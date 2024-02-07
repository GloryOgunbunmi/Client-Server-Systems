import java.io.*; //imports java methods
import java.net.*; 

class TCPServer{ 

    public static void main(String argv[]) throws Exception{ //must throw exception
        String clientSentence; 
        String capitalizedSentence; 

        ServerSocket welcomeSocket = new ServerSocket(6789); //need to create a Socket- port number can be assigned anywere from 1-65535
  
        while(true){  //infinate loop
  
           Socket connectionSocket = welcomeSocket.accept(); //indivisual reaponse for each request- each request will creat another socket

           BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); //"Reader" is how communicate with client

	   DataOutputStream  outToClient = new DataOutputStream(connectionSocket.getOutputStream()); 

           clientSentence = inFromClient.readLine(); //input from client is assigned to this variable

           capitalizedSentence = clientSentence.toUpperCase() + '\n'+'\n'; //make uppercase

           outToClient.writeBytes(capitalizedSentence); //sends to client
      } 
  } 
} 
