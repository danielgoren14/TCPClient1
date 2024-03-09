import java.io.*; 
import java.net.*; 
import java.util.Scanner;
class TCPClient { 

    public static void main(String argv[]) 
    { 
        String sentence; 
        String modifiedSentence; 

        try { 
        
        Scanner inFromUser =  new Scanner (System.in) ;
        
        Socket clientSocket = new Socket("localhost", 10000); 

      
       ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());

       BufferedReader inFromServer = 
          new BufferedReader(new
          InputStreamReader(clientSocket.getInputStream())); 
		
		while(true)
		{

			System.out.println("plz insert your choice :" +
					"1 - insert statement" +
					"2 - check if user exists "+
					"3 - delete statement" +
					"4 - update statement");
			String userChoice = inFromUser.nextLine();
			outToServer.writeObject(userChoice);
			switch (userChoice) {
				case "1" -> {
					System.out.println("plz insert id");
					String id = inFromUser.nextLine();

					System.out.println("plz insert name");
					String name  = inFromUser.nextLine();

					System.out.println("plz insert phone");
					String phone = inFromUser.nextLine();

					Student s = new Student ( id, name , phone);
					outToServer.writeObject(s); // send all the student object


				}
				case "2" -> {
					System.out.println("plz insert id");
					String id = inFromUser.nextLine();

					Student s = new Student ( id, null , null);
					outToServer.writeObject(s); // send all the student object





				}
				case "3" -> {
					System.out.println("plz insert id to delete a student");
					String id = inFromUser.nextLine();

					Student s = new Student ( id, null , null);
					outToServer.writeObject(s); // send all the student object




				}
				case "4" -> {
					System.out.println("plz insert id to update a student");
					String id = inFromUser.nextLine();

					System.out.println("plz insert name to update");
					String name  = inFromUser.nextLine();

					System.out.println("plz insert phone to update");
					String phone = inFromUser.nextLine();
					Student s = new Student ( id, name , phone);
					outToServer.writeObject(s); // send all the student object




				}
			}

			modifiedSentence = inFromServer.readLine();

			System.out.println("FROM SERVER: " + modifiedSentence);

      

			
		}
       
              
    }catch ( ConnectException e)
    {
    	System.out.println( " 404 C'ant connect to the Server");
    } catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
} 
}

