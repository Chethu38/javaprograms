import java.util.*;
class floydemo{
    int n;
    int a[][]=new int[10][10];
    int d[][][]=new int[10][10][10];
    void read(){
        int i,j;
        System.out.println("enter the number of vertices");
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        System.out.println("enter the adjacency matrix");
        for(i=1;i<=n;i++){
            for(j=1;j<=n;j++){
                a[i][j]=s.nextInt();
            }
        }
    }
    void floyd(){
        int i,j;
        for(i=1;i<=n;i++){
            for(j=1;j<=n;j++){
                d[0][i][j]=a[i][j];
            }
        }
        for(int k=1;k<=n;k++){
            for(i=1;i<=n;i++){
                for(j=1;j<=n;j++){
                    d[k][i][j]=min(d[k-1][i][j],(d[k-1][i][k]+d[k-1][k][j]));
                }
            }
        }
    }
    int min(int a,int b){
       return a<b?a:b;
    }
    void write(){
        int i,j,k;
        System.out.println("\ncomputing all pair shortest paths");
        for(k=0;k<=n;k++){
            System.out.println("d["+k+"]<<=<<\n");
            for(i=1;i<=n;i++){
                for(j=1;j<=n;j++){
                    System.out.print(d[k][i][j]+"\t");
                }
                System.out.println();
            }
        }
    }

}
public class floyds {
    public static void main(String[] args) {
        floydemo f=new floydemo();
        f.read();
        f.floyd();
        f.write();
    }
    

}
