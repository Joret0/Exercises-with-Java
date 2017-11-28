package Pr4CreateAnnotation;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        Annotation[] declaredAnnotations = TestClass.class.getAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }
    }
}
