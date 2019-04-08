package gc_app;
public class Obj {
    int I;
    Obj(int i) {
        I = i;
    }
    @Override
    protected void finalize() {
        System.out.println("finalize " + I);
    }
}
