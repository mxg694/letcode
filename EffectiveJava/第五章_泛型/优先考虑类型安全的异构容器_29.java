package 第五章_泛型;

import java.util.HashMap;
import java.util.Map;

public class 优先考虑类型安全的异构容器_29 {

    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class,"java");
        f.putFavorite(Class.class, Favorites.class);

        String s = f.getFavorites(String.class);
        Class<?> fClass = f.getFavorites(Class.class);

        System.out.println(s +", " + fClass);
    }
}

class  Favorites {
    private Map<Class<?>,Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        if (type  != null){
            favorites.put(type, instance);
        }
    }
    public <T> T getFavorites(Class<T> type) {
        return type.cast(favorites.get(type));
    }



}