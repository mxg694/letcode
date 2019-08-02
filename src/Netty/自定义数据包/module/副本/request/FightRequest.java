package Netty.自定义数据包.module.副本.request;

import Netty.序列化.core.Serializer;

public class FightRequest extends Serializer {

    /**
     * 副本id
     */
    private int fubenId;
    /**
     * 次数
     */
    private int count;

    public void setFubenId(int fubenId) {
        this.fubenId = fubenId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFubenId() {
        return fubenId;
    }

    @Override
    protected void read() {
        this.fubenId = readInt();
        this.count = readInt();
    }

    @Override
    protected void write() {
        writeInt(fubenId);
        writeInt(count);
    }
}
