package org.mlaptev.otus.framework;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.mlaptev.otus.framework.annotations.After;
import org.mlaptev.otus.framework.annotations.Before;
import org.mlaptev.otus.framework.annotations.Test;

class Helper {

  static List<Method> getAfterSteps(List<Method> methods) {
    return methods.stream()
        .filter(method -> method.isAnnotationPresent(After.class))
        .sorted(Comparator.comparing(method -> method.getDeclaredAnnotation(After.class).order()))
        .collect(Collectors.toList());
  }

  static List<Method> getTests(List<Method> methods) {
    return methods.stream()
        .filter(method -> method.isAnnotationPresent(Test.class))
        .collect(Collectors.toList());
  }

  static List<Method> getBeforeSteps(List<Method> methods) {
    return methods.stream()
        .filter(method -> method.isAnnotationPresent(Before.class))
        .sorted(Comparator.comparing(method -> method.getDeclaredAnnotation(Before.class).order()))
        .collect(Collectors.toList());
  }
}
