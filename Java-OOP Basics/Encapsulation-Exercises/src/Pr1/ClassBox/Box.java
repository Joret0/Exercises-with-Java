package Pr1.ClassBox;


public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double getLength() {
        return this.length;
    }
    private void setLength(double length) {
        this.length = length;
    }
    public double getWidth() {
        return this.width;
    }
    private void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return this.height;
    }
    private void setHeight(double height) {
        this.height = height;
    }

    public double getSurfaceArea() {
        return (2 * this.getLength() * this.getHeight()) + (2 * this.getLength() * this.getWidth()) + (2 * this.getWidth() * this.getHeight());
    }

    public double getVolume() {
        return this.getWidth() * this.getHeight() * this.getLength();
    }

    public double getLateralSurfaceArea() {
        return (2 * this.getLength() * this.getHeight()) + (2 * this.getWidth() * this.getHeight());
    }
}
