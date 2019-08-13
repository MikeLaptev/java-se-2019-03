package org.mlaptev.otus.figure;

public class Square implements FigureInterface {

  private double radius;

  public Square(double radius) {
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return radius * radius;
  }
}
