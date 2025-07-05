import java.util.*;
public class excep{
    public static void main(String[] args) {
        int a,b;
        Scanner s=new Scanner(System.in);
        System.out.println("enter the numbers");
        a=s.nextInt();
        b=s.nextInt();
        try{
            if(b!=0){
                System.out.println(a/b);
            }
            else {
                throw new ArithmeticException();
            }
        }
        catch (ArithmeticException e){
            System.out.println("divide by zero error");
        }

    }
}
