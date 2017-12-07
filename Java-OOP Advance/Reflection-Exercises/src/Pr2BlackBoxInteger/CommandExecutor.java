package Pr2BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class CommandExecutor {
    private static final String ADD_METHOD = "add";
    private static final String SUBTRACT_METHOD = "subtract";
    private static final String MULTIPLY_METHOD = "multiply";
    private static final String DIVIDE_METHOD = "divide";
    private static final String LEFTSHIFT_METHOD = "leftShift";
    private static final String RIGHTSHIFT_METHOD = "rightShift";
    private static final String INNER_VALUE_NAME = "innerValue";
    private BlackBoxInt blackBoxInt;

    CommandExecutor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<BlackBoxInt> declaredConstructor = BlackBoxInt.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        this.blackBoxInt = declaredConstructor.newInstance();
    }

    void execute(String command, int value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        switch (command) {
            case ADD_METHOD:
                this.getDeclaredMethod(ADD_METHOD).invoke(blackBoxInt, value);
                break;
            case SUBTRACT_METHOD:
                this.getDeclaredMethod(SUBTRACT_METHOD).invoke(blackBoxInt, value);
                break;
            case MULTIPLY_METHOD:
                this.getDeclaredMethod(MULTIPLY_METHOD).invoke(blackBoxInt, value);
                break;
            case DIVIDE_METHOD:
                this.getDeclaredMethod(DIVIDE_METHOD).invoke(blackBoxInt, value);
                break;
            case LEFTSHIFT_METHOD:
                this.getDeclaredMethod(LEFTSHIFT_METHOD).invoke(blackBoxInt, value);
                break;
            case RIGHTSHIFT_METHOD:
                this.getDeclaredMethod(RIGHTSHIFT_METHOD).invoke(blackBoxInt, value);
                break;
        }

        print(blackBoxInt);
    }

    private Method getDeclaredMethod(String addMethod) throws NoSuchMethodException {
        Method declaredMethod = BlackBoxInt.class.getDeclaredMethod(addMethod, int.class);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    private void print(BlackBoxInt declaredConstructor) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Field innerValue = BlackBoxInt.class.getDeclaredField(INNER_VALUE_NAME);
        innerValue.setAccessible(true);
        System.out.println(innerValue.getInt(declaredConstructor));
    }
}
