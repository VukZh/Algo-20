package gc_app;

public class GC_App {

    public static void main(String[] args) throws InterruptedException {
        Obj o1 = new Obj(1);
        CountingReference cr1 = new CountingReference(o1);

/////  проверка на небольшом количестве ссылок
        cr1.add(o1); // добавляем ссылку
        cr1.add(o1);
        cr1.add(o1);
        cr1.OUT(); // вывод счетчика ссылок
        cr1.remove(o1); // удаляем ссылку
        cr1.remove(o1);
        cr1.remove(o1);
        cr1.remove(o1);
        cr1.OUT(); // 
        if (cr1.gcObj(o1)) { // запуск "сборки мусора"
            System.out.println("del " + o1);
            o1 = null;
        }
        System.out.println("O1 " + o1);
        cr1.OUT();

/////  проверка на большом количестве ссылок (проверка finalize)
        System.out.println("---------------------------------");

        CountingReference cr2 = new CountingReference(o1);
        for (int i = 0; i < 2000000; i++) {
            o1 = new Obj(i);
            cr2.add(o1);
            cr2.remove(o1); // отключаем обнуление счетчика - сборка мусора отключается
            if (cr2.gcObj(o1)) {
                o1 = null;
            }
        }
    }
}
