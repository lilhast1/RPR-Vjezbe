import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s;
        Niz niz = new Niz();
        do {
            System.out.print("Input: ");
            s = scn.nextLine();
            if (s.equals("stop"))
                break;
            if ( s.charAt(0) >= '0' && s.charAt(0) <= '9') {
                var n = Integer.parseInt(s);
                niz.add(n).print();
            }
        } while(true);
    }
}
