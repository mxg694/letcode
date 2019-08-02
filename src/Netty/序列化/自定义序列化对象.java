package Netty.序列化;

import org.junit.Test;

import java.util.Arrays;

public class 自定义序列化对象 {

    @Test
    public void test自定义序列化对象() {
        Player player = new Player();
        player.setPlayerid(10001L);
        player.setAge(22);
        player.getSkills().add(101);
        player.getRes().setGold(99999);

        byte[] bytes = player.getBytes();

        System.out.println(Arrays.toString(bytes));

        //----------------------------------------
        Player player2 = new Player();
        player2.readFromBytes(bytes);
        System.out.println(player2.getPlayerid() + "   "+player2.getAge() + "     "+ Arrays.toString(player2.getSkills().toArray())+"   " +player2.getRes().getGold());

    }


}


