package thread;

/**
 * Created by Michael Allan on 2019/11/22.
 */
public class EnumThread {

    public enum MyEnumSingleton {
        singleton;
        private EnumThread enumThread;
        MyEnumSingleton () {
            enumThread = new EnumThread();
        }

        public EnumThread getEnumThread() {
            return enumThread;
        }
    }

    public static EnumThread getOurInstance() {
        return MyEnumSingleton.singleton.getEnumThread();
    }
}
