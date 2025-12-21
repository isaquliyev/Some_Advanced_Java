package reflection;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Authors.class)
public @interface Author {
    public String name() default "Isa";
}


