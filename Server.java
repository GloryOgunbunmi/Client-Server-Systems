import java.net.*;
import java.io.*;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try
        {
            serverSocket = new ServerSocket(4444);
        }
        catch (IOException e)
        {
            System.err.println("Could not listen on port: 4444.");
            System.exit(-1);
        }

        while (listening)
            new Thread (new ClientHandler (serverSocket.accept())).start();

        serverSocket.close();
    }
}
class ClientHandler implements Runnable
{
  private Socket client;

  public ClientHandler (Socket c)
  {
    client = c;
  }

  public void run ()
  {
    BufferedReader clientIn = null;
    PrintWriter clientOut = null;
    String input = null;

    try
    {
      clientIn = new BufferedReader (new InputStreamReader (client.getInputStream ()));
      clientOut = new PrintWriter (client.getOutputStream (), true);
    }
    catch (Exception e)
    {
      e.printStackTrace ();
    }

    do
    {
      try
      {
        input = clientIn.readLine ();
       
		String test = toInfix(input);
		//System.out.println("" + test);
     clientOut.println (test);
      } 
      catch (Exception e)
      {
        e.printStackTrace ();
      }
    }
    while (! input.equals ("Bye"));

    try
    {
      clientIn.close ();
      clientOut.close ();
      client.close ();
    }
    catch (Exception e)
    {
      e.printStackTrace ();
    }
  }
//was here

public static String toInfix (String input) {
 
    String [] line =input.split(" ");
   
    double x =Double.parseDouble(line[1]);
    double y =Double.parseDouble(line[2]);
 
    switch (line[0]){
      case "+":
        return String.valueOf(x + y);
      case "-":
        return String.valueOf(x - y);
      case "/":
        return String.valueOf(x / y);
      case "*":
        return String.valueOf(x *y);
      default:
        return "Invalid Input!!!!!!!!!!";
    }
  }
}
