package be.technocite.todo.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
public @interface FieldMatch {
}
