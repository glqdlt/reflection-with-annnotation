package com.glqdlt.ex.reflectionwithannotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author glqdlt
 * @see <a href= "https://stackoverflow.com/questions/16966629/what-is-the-difference-between-getfields-and-getdeclaredfields-in-java-reflectio/37916809#37916809">fields vs declaredFields</a>
 * 2019-02-19
 */
@Slf4j
public class ObjectMapper {

    <T> void consume(List<T> list){
        if(list.size() < 1){
            return;
        }

        Class<?> t = list.get(0).getClass();
        String typeName = t.getTypeName();
        String name = t.getName();
        Field[] f_d = t.getDeclaredFields();

        List<Field> fields = Stream.of(f_d)
                .filter(_x -> {
                    Annotation[] annos = _x.getDeclaredAnnotations();
                    for (Annotation a : annos) {
                        if (a instanceof IndexAnnotation) {
                            if(((IndexAnnotation) a).parseSkip()){
                                return true;
                            }
                        }
                    }
                    return false;
                }).collect(Collectors.toList());
        log.info("{}",fields.get(0).toString());
    }

}
