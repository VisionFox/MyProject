package com.xidian.project4;

public class NewRectangle {
    double width;
    double height;

    public NewRectangle() {
        this.width = 0.0;
        this.height = 0.0;
    }

    public NewRectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }
}
