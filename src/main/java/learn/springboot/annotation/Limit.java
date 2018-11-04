package learn.springboot.annotation;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {}
)
public @interface Limit
{
    int value() default 5;
}
