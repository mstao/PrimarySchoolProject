package com.primaryschool.admin.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过反射获取泛型实例
 * @author Administrator
 *
 */
public abstract class Genericity<T> {
    /**
     * 当前操作的实体的类型信息
     */
    @SuppressWarnings("rawtypes")
    protected Class clazz;

    @SuppressWarnings("unchecked")
    public Genericity() {
        // 通过反射机制获取子类传递过来的实体类的类型信息
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
    }

    /**
     * 获取指定实例的所有属性名及对应值的Map实例
     * 
     * @param entity
     *            实例
     * @return 字段名及对应值的Map实例
     */
    protected Map<String, Object> getFieldValueMap(T entity) {
        // key是属性名，value是对应值
        Map<String, Object> fieldValueMap = new HashMap<String, Object>();

        // 获取当前加载的实体类中所有属性（字段）
        Field[] fields = this.clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            String key = f.getName();// 属性名 
            Object value = null;//属性值  
            if (! "serialVersionUID".equals(key)) {// 忽略序列化版本ID号
                f.setAccessible(true);// 取消Java语言访问检查
                try {
                    value =f.get(entity);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                fieldValueMap.put(key, value);
            }
        }
        return fieldValueMap;
    }
}