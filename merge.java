import java.util.*;
class msort{
    int n,a[];
    msort(int x){
        n=x;
        a=new int[n+1];
    }
    void generate(){
        System.out.println("generating random numbers");
        Random r=new Random();
        for (int i=0;i<n;i++){
            a[i]=r.nextInt(100);
            System.out.print(a[i]+" ");
        }
    }
    void merge (int low,int mid,int high){
        int i,j,h,k;
        int b[]=new int[n+1];
        i=low;j=mid+1;h=low;
        while((h<=mid)&&(j<=high)){
            if(a[h]<=a[j]){
                b[i]=a[h];
                h=h+1;
            }
            else{
                b[i]=a[j];
                j=j+1;
            }
            i=i+1;
        }
        if(h>mid){
            for(k=j;k<=high;k++){
                b[i]=a[k];
                i=i+1;
            }
        }
        else{
            for(k=h;k<=mid;k++){
                b[i]=a[k];
                i=i+1;
            }
        }
        for(k=low;k<=h;k++){
            a[k]=b[k];
        }
    }
    void mergesort(int low,int high){
        if(low<high){
          int mid=(low+high)/2;
          mergesort(low,mid);
          mergesort(mid+1,high);
          merge(low,mid,high);
        }
    }
    void display(){
        System.out.println("sorted elements are");
        for(int i=0;i<n;i++)
        System.out.print(a[i]+" ");
    }
}

public class merge{
    public static void main(String[] args){
        int n;
        Scanner s=new Scanner(System.in);
        System.out.println("enter the number of elemnts");
        n=s.nextInt();
        msort mob=new msort(n);
        mob.generate();
        long st=System.currentTimeMillis();
        mob.mergesort(0,mob.n-1);
        long end=System.currentTimeMillis();
        mob.display();
        System.out.println("time taken to complete sorting is"+(end-st)+"milli seconds");
        
    }
}