package reflection;

import java.lang.reflect.AccessFlag;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Author
public class Main {


    public static Boolean isAllFieldsPrivate(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .allMatch(
                        x -> x.accessFlags().contains(AccessFlag.PRIVATE)
                );
    }

    public static String getAuthorName(Class<?> clazz) {

        Author[] authors = clazz.getAnnotationsByType(Author.class);

        return authors.length != 0 ? authors[0].name() : "No author";
    }

    public static Method[] methodsWithAuthorDifferentThanClass(Class<?> clazz) {
        String author = clazz.getAnnotation(Author.class).name();

        if (author == null) return new Method[0];

        return Arrays.stream(clazz.getMethods())
                .filter(method -> method.isAnnotationPresent(Author.class))
                .filter(method -> !method.getAnnotation(Author.class).name().equals(author))
                .toArray(Method[]::new);


    }


    public static Method[] callCreatedBefore(Class<?> clazz, int year) {
        Method[] methods = Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.getParameterCount() == 0)
                .filter((Method m) -> {
                    CreatedInYear ciy = m.getAnnotation(CreatedInYear.class);
                    return ciy != null && ciy.year() < year;
                        })

                .toArray(Method[]::new);

        Arrays.stream(methods).forEach(method -> {


            try {
                method.setAccessible(true);
                if (Modifier.isStatic(method.getModifiers())) method.invoke(true);
                else {
                    Object instance = clazz.getDeclaredConstructor().newInstance();
                    method.invoke(instance);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return methods;
    }

    public static void callWithParams(Class<?> clazz) {
        Method[] methods = Arrays.stream(clazz.getDeclaredMethods()).filter(
                method -> method.getAnnotation(ParameterFor.class) != null
        ).toArray(Method[]::new);


        Arrays.stream(methods).forEach(
                method -> {

                    try {
                        method.setAccessible(true);
                        if (Modifier.isStatic(method.getModifiers())) method.invoke(null);
                        else {
                            Object instance = clazz.getDeclaredConstructor().newInstance();
                            method.invoke(instance);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                }
        );

    }


}

