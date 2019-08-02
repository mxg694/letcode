package Jvm;

public class 栈大小分配 {

    private static int count = 0;

    public static void main(String[] args) {
        try{
            recursion(0L);
        }catch(Throwable e){
            System.out.println("deep of calling = "+count);
            e.printStackTrace();
        }

    }
    public static void recursion(Long a) {
        long e=1,f=2,g=3,h=4,i=5,k=6,q=7,x=8,y=9,z=10;
        count++;
        recursion(a);
    }

}
