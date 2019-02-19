package com.glqdlt.ex.reflectionwithannotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

    public LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    <T> void consume(List<T> list){
        if(list.size() < 1){
            return;
        }

        Class<?> t = list.get(0).getClass();
        String typeName = t.getTypeName();
        String name = t.getName();
        log.info("ClassName : {}, TypeName : {}",name,typeName);
        Field[] f_d = t.getDeclaredFields();
        Method[] m_d = t.getDeclaredMethods();

        List<Field> fields = Stream.of(f_d)
                .filter(_x -> {
                    Annotation[] annotations = _x.getDeclaredAnnotations();
                    for (Annotation a : annotations) {
                        if (a instanceof IndexAnnotation) {
                            if(!((IndexAnnotation) a).parseSkip()){
                                return true;
                            }
                        }
                    }
                    return false;
                }).collect(Collectors.toList());

        for(Field f : fields){
            Annotation[] annotations = f.getDeclaredAnnotations();

            try{
            for(Annotation a : annotations){
                IndexAnnotation _a = (IndexAnnotation) a;
                String methodName = (_a.getMethodNamePrefix()+f.getName()).toLowerCase();
                Method m = Stream.of(m_d).filter(_x -> {
                    String d_m = _x.getName().toLowerCase();
                    return d_m.equals(methodName);
                }).findAny().orElseThrow(() -> new RuntimeException(String.format("Not Found MethodName %s",methodName)));

                list.forEach(x -> {
                    try {
                        Object o = m.invoke(x);
                        if(f.getType().equals(Date.class) && o != null){
                            log.info("{} : {}",f.getName(),convertToLocalDateTime((Date)o).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                        }else{
                            log.info("{} : {}",f.getName(),String.valueOf(o));
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        log.error(e.getMessage(),e);
                    }
                });
            }}catch(RuntimeException e){
                log.error(e.getMessage(),e);
                log.info("Skip field : {}",f.getName());
            }
        }
    }

}
