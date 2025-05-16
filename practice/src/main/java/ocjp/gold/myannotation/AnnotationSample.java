package ocjp.gold.myannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 컴파일 후에 남겨두고 싶지 않음
@Retention(RetentionPolicy.SOURCE)
// Target을 지정하지 않으면 모든 대상
@Target(ElementType.METHOD)
public @interface AnnotationSample {
    // 어노테이션 파라미터
    String test();
}
