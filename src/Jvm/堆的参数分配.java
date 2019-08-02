package Jvm;

public class 堆的参数分配 {
    public static void main(String[] args) {
        byte[] b = new byte[1024*1024    ];
        System.out.println("分配了1M空间给数组");
        System.out.printf("Xmx=");
        System.out.println(Runtime.getRuntime().maxMemory()/1024.0/1024 +"M");

        System.out.printf("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024 +"M");

        System.out.printf("Total mem=");
        System.out.println(Runtime.getRuntime().totalMemory()/1024.0/1024 +"M");
    }
}
