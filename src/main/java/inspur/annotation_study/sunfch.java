package inspur.annotation_study;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface sunfch {
    String[] value() default "";
}
