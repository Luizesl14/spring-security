package com.spring.secirity.infrastructure.util;

import java.util.List;

public interface IService<T> {
    List<T> searchAll();
    T searchById(Integer id);
    T save(T t);
    T update(T t);
    void delete(Integer id);
}
