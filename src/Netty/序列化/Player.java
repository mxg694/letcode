package Netty.序列化;

import Netty.序列化.core.Serializer;

import java.util.ArrayList;
import java.util.List;

public class Player extends Serializer {
    private Long playerId;

    private  int age;

    private List<Integer> skills = new ArrayList<>();

    private Res res = new Res();

    public Long getPlayerid() {
        return playerId;
    }

    public void setPlayerid(Long playerid) {
        this.playerId = playerid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getSkills() {
        return skills;
    }

    public void setSkills(List<Integer> skills) {
        this.skills = skills;
    }

    public Res getRes() {
        return res;
    }

    public void setRes(Res res) {
        this.res = res;
    }

    @Override
    protected void read() {
        this.playerId = readLong();
        this.age = readInt();
        this.skills = readList(Integer.class);
        this.res = read(Res.class);
    }

    @Override
    protected void write() {
        writeLong(playerId);
        writeInt(age);
        writeList(skills);
        writeObject(res);
    }
}
