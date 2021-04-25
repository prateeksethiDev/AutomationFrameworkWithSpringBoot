package com.test.framework.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(TYPE)
@Retention(RUNTIME)
@Component
@Scope("thread")
public @interface PageObject {

}
