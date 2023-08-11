package com.example.apiserver.mappers;

abstract public class BaseMapper<DTO, T> {
    public BaseMapper() {
    }

    public T map(DTO dto, T entity) {
        setParameters(dto, entity);
        return entity;
    }

    public T map(DTO source) {
        T t = (T) new Object();
        return map(source, t);
    }

    protected abstract void setParameters(DTO dto, T entity);
}
