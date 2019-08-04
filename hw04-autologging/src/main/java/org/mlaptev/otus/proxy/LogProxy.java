package org.mlaptev.otus.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.mlaptev.otus.annotations.Log;

public class LogProxy implements InvocationHandler {

  private Object obj;

  public static Object newInstance(Object obj) {
    return Proxy.newProxyInstance(
        obj.getClass().getClassLoader(),
        obj.getClass().getInterfaces(),
        new LogProxy(obj));
  }

  private LogProxy(Object obj) {
    this.obj = obj;
  }

  public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
    Object result;
    try {
      if (m.getAnnotation(Log.class) != null) {
        List<Argument> arguments = new ArrayList<>();
        int i = 0;
        for (Parameter p : m.getParameters()) {
          arguments.add(new Argument(p.getName(), args[i++]));
        }
        System.out.println(
            String.format("Executed method: %s, parameters: %s",
                m.getName(),
                arguments.stream().map(Argument::toString).collect(Collectors.joining(", "))));
      }
      result = m.invoke(obj, args);
    } catch (InvocationTargetException e) {
      throw e.getTargetException();
    } catch (Exception e) {
      throw new RuntimeException("unexpected invocation exception: " +
          e.getMessage());
    }
    return result;
  }

  @AllArgsConstructor
  private class Argument {

    String name;
    Object value;

    @Override
    public String toString() {
      return "{" + name + ": " + value + "}";
    }
  }
}