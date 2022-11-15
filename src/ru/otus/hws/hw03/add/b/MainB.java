package ru.otus.hws.hw03.add.b;

import ru.otus.hws.hw03.add.a.A;

public class MainB {
    public void main(String[] args) {
        A testAinB = new A();
        B testBinB = new B();

        //testAinB.voidMethod();     // Не видно внутри соседнего пакета
        testAinB.publicMethod();   // Видно внутри соседнего пакета
        //testAinB.protectedMethod(); // Не видно внутри соседнего пакета
        //testAinB.privateMethod(); // Не видно внутри соседнего пакета

        //testBinB.voidMethod();     // Не видно внутри соседнего пакета, даже если класс объекта унаследован в данном пакете
        testBinB.publicMethod();   // Видно внутри соседнего пакета
        //testBinB.protectedMethod(); // Не видно внутри соседнего пакета, даже если класс объекта унаследован в данном пакете
        //testBinB.privateMethod(); // Не видно внутри соседнего пакета, даже если класс объекта унаследован в данном пакете

    }
}
