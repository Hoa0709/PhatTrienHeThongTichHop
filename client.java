import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class client {

    private static Scanner scan;

    public static void main(String[] args) {
        try {
            Socket client = new Socket("LocalHost", 9999); //   Tao clinent socket de ket noi toi server
            
            System.out.println("Client tao thanh cong");
            
            Scanner in = new Scanner(client.getInputStream());
            
            PrintStream out = new PrintStream(client.getOutputStream());
            while (true) {
                System.out.print("message:"); // nhap tin nhan
                scan = new Scanner(System.in);
                String text = scan.nextLine();
                out.println(text);
                if (text.equals("het")) {       // gap chuoi het
                    String txt = in.nextLine();
                    System.out.println("server: " + txt);
                } else {
                    System.out.println("message:");
                    scan = new Scanner(System.in);
                    String txt = scan.nextLine();
                    out.println(txt);
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
