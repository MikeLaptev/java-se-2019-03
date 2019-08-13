package org.mlaptev.otus.figure;

public class Circle implements FigureInterface {

  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return Math.PI*radius*radius;
  }
}
