package gc_app;

import java.util.Arrays;
import java.util.HashMap;

public class CountingReference { // счетчик ссылок

    private static final HashMap<Object, Integer> refCounterArr = new HashMap<>();

    public CountingReference(Object object) {
        int count; // число ссылок на объект object
        if (refCounterArr.get(object) == null) {
            count = 1;
        } else {
            count = refCounterArr.get(object);
            count++;
        }
//        System.out.println("count " + count); //
        refCounterArr.put(object, count);
//        System.out.println("Obj - " + object);//
    }

    public void add(Object object) { // добавление объекта или ссылки для имеющегося объекта
        int count;
        if (refCounterArr.get(object) == null) {
            count = 1;
        } else {
            count = refCounterArr.get(object);
            count++;
        }
//        System.out.println("count " + count); //
        refCounterArr.put(object, count);
//        System.out.println("Obj - " + object); //
    }

    public boolean remove(Object object) { // удаление ссылки
        int count;
        if (refCounterArr.get(object) == null) {
            return false;
        } else {
            count = refCounterArr.get(object);
            count--;
            if (count < 0) {
                return false;
            }
        }
        refCounterArr.put(object, count);
        return true;
    }

    public void OUT() { // вывод счетчиков
        System.out.println(Arrays.asList(refCounterArr));
    }

    public boolean gcObj(Object object) { // сборка мусора
        if (refCounterArr.get(object) != null && refCounterArr.get(object) == 0) {
            refCounterArr.remove(object);
            return true;
        } else {
            return false;
        }
    }
}
