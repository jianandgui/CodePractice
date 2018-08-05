package sort;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class Singleton {

    public static void main(String[] args) {
        sigleton s = sigleton.getSin();
        sigleton s2 = sigleton.getSin();
        System.out.println(s==s2);
        ArrayList arrayList;
    }


}

class singeleton {
    //单例模式 内部内形式

    private singeleton() {
    }

    private static final class help {
        public static final singeleton s = new singeleton();
    }

    public static final singeleton getSingleton() {
        return help.s;
    }
}

//懒汉式
class sigleton {

    private static sigleton s;
    //私有构造器
    private sigleton() {
    }

    //获取单例
    public static synchronized sigleton getSin() {
        if (s == null) {
            s = new sigleton();
        }
        return s;
    }
}

//饿汉式 线程安全
class hungerySingleton {
    //类加载机制保证线程安全
    private static hungerySingleton singleton=new hungerySingleton();

    //私有构造器
    private hungerySingleton() {
    }

    //获取单例
    public static hungerySingleton get() {
        return singleton;
    }
}

class DCLsingleton {

    //私有构造器
    private DCLsingleton() {
    }

    private volatile static DCLsingleton s;

    //获取单例
    public static DCLsingleton getS() {
        if (s == null) {
            synchronized (DCLsingleton.class) {
                if (s == null) {
                    s = new DCLsingleton();//防止指令重排
                    //因为new() 在内存中分三步
                    // 1、分配内存地址
                    // 2、初始化
                    // 3、将内簇地址赋给对象
                    // 如果此时2 3 重排序了 那就会返回一个没有初始化的对象

                }
                ConcurrentHashMap concurrentHashMap;
            }
        }
        return s;
    }
}

enum E{
    ISTANCE;

}



