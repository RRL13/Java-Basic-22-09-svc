package ru.otus.hws.hw03.add.a;

public class MainA {
    public static void main(String[] args) {
        A testAinA = new A();

        testAinA.voidMethod();     // Видно внутри своего пакета
        testAinA.publicMethod();   // Видно внутри своего пакета
        testAinA.protectedMethod(); // Видно внутри своего пакета
        //testAinA.privateMethod(); // Не видно внутри своего пакета

    }


}
