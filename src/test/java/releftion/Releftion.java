package releftion;

import com.zys.collect.releftion.Person;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mock;

import javax.security.auth.Subject;
import javax.swing.text.html.HTML;
import javax.xml.transform.Source;
import java.lang.reflect.Field;

/**
 * @author zhaoyshan
 * @date 2021/7/24 21:10
 */

public class Releftion extends TestCase{

    @Test
    public void test(){
    }



    @Test
    public void testBeanUtils() throws IllegalAccessException { // 就是可以根据BeanUtil创建一个bean 也可以用BeanUtils转换一个成另外一个bean
        Person person = new Person("zhaoyshan",22);
        Person person1 = new Person("zhaoyangshan",23);
        Class<? extends Person> aClass = person.getClass();
        Class<? extends Person> aClass1 = person1.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for(Field field:declaredFields){
            String name = field.getName();
            Object o = field.get(person);
            if (name != null && name.equals("userName") == true){
                field.setAccessible(true);

                String userName = (String)field.get(person);
                System.out.println(userName);
            }
        }
    }


    @Test
    public void testConverto() throws Exception {
        Person zhaoyshanq = new Person("zhaoyshanq", 22);
        Person person = new Person();
        convertor(zhaoyshanq,person);
        System.out.println(person);
        ;
    }

    public static void convertor(Object sourceObj, Object targetObj) throws Exception{
        Class<?> sourceClazz = sourceObj.getClass();
        Class<?> targetClazz = targetObj.getClass();

        Field[] sourceObjClazzFields = sourceClazz.getDeclaredFields();
        Field[] targetClazzFields = targetClazz.getDeclaredFields();

        for( Field originField : sourceObjClazzFields){
            for (Field targetField : targetClazzFields){
                if (originField.getName().equals(targetField.getName())){
                    originField.setAccessible(true);
                    targetField.setAccessible(true);
                    targetField.set(targetObj,originField.get(sourceObj));
                }
            }
        }
    }

}
