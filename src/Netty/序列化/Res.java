package Netty.序列化;

import Netty.序列化.core.Serializer;

public class Res extends Serializer {
    private int  gold;

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
