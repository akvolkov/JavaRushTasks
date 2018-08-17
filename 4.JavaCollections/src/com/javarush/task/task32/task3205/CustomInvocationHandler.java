package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Home PC Volkov on 28.05.2018.
 */
public class CustomInvocationHandler implements InvocationHandler{
    SomeInterfaceWithMethods someInterfaceWithMethods;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in]");
        Object object = method.invoke(someInterfaceWithMethods, args);
        System.out.println(method.getName() + " out]");
        return object;
    }

    public CustomInvocationHandler(SomeInterfaceWithMethods someInterfaceWithMethods) {
        this.someInterfaceWithMethods = someInterfaceWithMethods;
    }
}
