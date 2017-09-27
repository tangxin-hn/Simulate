import java.util.regex.*;
import java.util.Scanner;

class TempTest{
    public static void main(String args[]){
        String content = "";
        String pattern1 = "^([-+]?\\d+(\\.\\d+)?)?([-+]?\\d+(\\.\\d+)?i)?$";
        String pattern2 = "^.*\\.[0-9]*\\..*$";
        while(true) {
            Scanner sc = new Scanner(System.in);
            content = sc.nextLine();
            boolean isMatch1 = Pattern.matches(pattern1, content);
            boolean isMatch2 = Pattern.matches(pattern2, content);
            if (isMatch1 && !isMatch2)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}