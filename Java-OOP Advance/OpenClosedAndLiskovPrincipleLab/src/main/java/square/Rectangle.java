package square;

public class Rectangle {
    private int m_width;
    private int m_height;

    public Rectangle(int m_width, int m_height) {
        this.setWidth(m_width);
        this.setHeight(m_height);
    }

    private void setWidth(int width) {
        this.m_width = width;
    }

    private void setHeight(int height) {
        this.m_height = height;
    }

    public int getWidth() {
        return this.m_width;
    }

    public int getHeight() {
        return this.m_height;
    }

    public int getArea() {
        return this.m_width * this.m_height;
    }
}
