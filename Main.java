import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String s = "";
        System.out.println("Enter the Syllabus separeted by comma and when Complete press Ctrl+d to exit.");
        while (sc.hasNextLine()) {
            s = "" + sc.nextLine();
        }
        System.out.println(s);
        sc.close();
	}
}
