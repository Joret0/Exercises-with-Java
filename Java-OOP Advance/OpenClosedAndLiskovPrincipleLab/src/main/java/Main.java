import detailPrinter.Employee;
import detailPrinter.Manager;
import extendedArrayList.ExtendedArrayList;
import fileStream.BaseFile;
import fileStream.File;
import fileStream.Music;
import fileStream.StreamProgressInfo;
import graphicEditor.Circle;
import graphicEditor.GraphicEditor;
import graphicEditor.IShape;
import graphicEditor.Rectangle;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //task_1();
        //task_2();
        //task_3();
        task_4();
    }

    private static void task_4() {
        Employee employee = new Employee("Georgi");
        employee.print();
        Employee manager = new Manager("Georgi", new ArrayList<String>() {{
           add("document");
        }});
        manager.print();
    }

    private static void task_3() {
        IShape rectangle = new Rectangle();
        IShape circle = new Circle();
        GraphicEditor graphicEditor1 = new GraphicEditor();
        graphicEditor1.drawShape(rectangle);
        GraphicEditor graphicEditor2 = new GraphicEditor();
        graphicEditor2.drawShape(circle);
    }

    private static void task_2() {
        BaseFile music = new Music("Georgi", "Melody", 5, 2);
        BaseFile file = new File("String", 50, 30);
        StreamProgressInfo spi = new StreamProgressInfo(music);
        System.out.println(spi.calculateCurrentPercent());
        spi = new StreamProgressInfo(file);
        System.out.println(spi.calculateCurrentPercent());
    }

    private static void task_1() {
        ExtendedArrayList<Integer> list = new ExtendedArrayList<>();
        list.add(4);
        list.add(10);
        list.add(100);
        list.add(-5);
        list.add(46);
        System.out.println("Max: " + list.max());
        System.out.println("Min: " + list.min());
    }
}
