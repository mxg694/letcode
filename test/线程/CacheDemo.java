package 线程;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {
    private Map<String, Object> cache = new HashMap<>();

    public static void main(String[] args) {

    }

    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public Object getData(String key) {
        rwl.readLock().lock();
        Object value = null;

        try {
            value = cache.get(key);
            if (value == null) {
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try {
                    if (value == null) {
                        value = "aaa"; //实际去查数据
                    }
                }finally {
                    rwl.writeLock().unlock();
                }
                rwl.readLock().lock();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            rwl.readLock().unlock();
        }
        return value;
    }

}
