import java.io.FileWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {

    private static Scanner scan;

    public static String reverString(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        try {

            ServerSocket server = new ServerSocket(9999);  // mo cong ket noi
          
            System.out.println("Server tao thanh cong");
           
            Socket socket = server.accept();
           
            System.out.println("Client da ket noi den server");
           
            PrintStream out = new PrintStream(socket.getOutputStream());
            FileWriter fw = new FileWriter("E:\\tichhopgk\\client1.txt");   //ghi file
            while (true) {

                Scanner in = new Scanner(socket.getInputStream());

                String text = in.nextLine();
                System.out.println(reverString(text));   // dao nguoc chuoi
               
                fw.write(reverString(text)); 
                
                if (text.equals("het")) {
                    out.println("ghi file thanh cong");
                    fw.close();
                    break;
                } else {
                    String txt = in.nextLine();
                    System.out.println(reverString(txt));   // ghi chuoi dao nguoc vao file
                    fw.write(reverString(txt));
                    if (txt.equals("het")) {
                        break;
                    }
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
