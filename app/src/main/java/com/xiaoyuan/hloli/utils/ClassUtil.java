package com.xiaoyuan.hloli.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by yubai on 2017/1/3.
 */

public class ClassUtil {

    public static <T> T getT(Object o, int i) {
        try {
            Type t = o.getClass().getGenericSuperclass();
            if (t instanceof ParameterizedType) {
                return ((Class<T>) ((ParameterizedType)t).getActualTypeArguments()[i])
                        .newInstance();
            }
//            return ((Class<T>) ((ParameterizedType) (o.getClass()
//                    .getGenericSuperclass())).getActualTypeArguments()[i])
//                    .newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }
}
