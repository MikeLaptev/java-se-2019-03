package org.mlaptev.otus.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mlaptev.otus.annotations.Log;

public class LogProxy implements InvocationHandler {

  private static Logger logger = LogManager.getLogger(LogProxy.class);

  private Object obj;

  private static Map<Method, Boolean> annotatedMethods = new WeakHashMap<>();

  public static Object instanceOf(Object obj) {

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
      if (!annotatedMethods.containsKey(m)) {
        annotatedMethods.put(m, m.getAnnotation(Log.class) != null);
      }

      if (annotatedMethods.get(m)) {
        logMethodDetails(m, args);
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

  private void logMethodDetails(Method m, Object[] args) {
    List<Argument> arguments = new ArrayList<>();
    int i = 0;
    for (Parameter p : m.getParameters()) {
      arguments.add(new Argument(p.getName(), args[i++]));
    }

    String parameters = "none";
    if (!arguments.isEmpty()) {
      parameters = arguments.stream()
          .map(Argument::toString)
          .collect(Collectors.joining(", "));
    }

    logger.info("Executed method: {}, parameters: {}", m.getName(), parameters);
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