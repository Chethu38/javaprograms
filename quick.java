import java.util.*;
class qsort{
    int n,a[];
    qsort(int x){
        n=x;
        a=new int[n];
    }
    void genrate(){
        Random r=new Random();
        for(int i=0;i<n;i++){
            a[i]=r.nextInt(20);
            System.out.print(a[i]+" ");
        }
    }
    int partion (int a[],int lb,int ub){
        int temp,up,down,pi;
        pi=a[lb];
        down=lb;
        up=ub;
        while(down<up){
            while(a[down]<=pi&&down<up)
            down++;
            while(a[up]>pi)
            up--;
            if(down<up){
                temp=a[up];
                a[up]=a[down];
                a[down]=temp;
            } 
        }
        a[lb]=a[up];
            a[up]=pi;
            return up;

    }
    void qusort(int a[],int lb,int ub){
        if(lb<ub){
            int p=partion(a, lb, ub);
            qusort(a,lb,p-1);
            qusort(a,p+1,ub);
        }
    }
    void display(){
        for(int i=0;i<n;i++)
        System.out.print(a[i]+" ");
    }
}

public class quick {
    public static void main(String[] args) {
        int x;
        Scanner s=new Scanner(System.in);
        System.out.println("enter the number of elements");
        x=s.nextInt();
        qsort q=new qsort(x);
        q.genrate();
        long st=System.currentTimeMillis();
        q.qusort(q.a, 0, q.n-1);
        long end=System.currentTimeMillis();
        System.out.println("\nsorted elements are:");
        q.display();
        System.out.println("\ntime taken   "+(end-st)+"  milli seconds");

    }
    
}
