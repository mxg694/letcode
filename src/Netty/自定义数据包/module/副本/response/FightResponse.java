package Netty.自定义数据包.module.副本.response;

import Netty.序列化.core.Serializer;

public class FightResponse extends Serializer {

    /**
     * 获取金币
     */
    private int gold;



    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    protected void read() {
        this.gold = readInt();
    }

    @Override
    protected void write() {
        writeInt(gold);
    }

}
