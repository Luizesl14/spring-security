package com.spring.secirity.infrastructure.util;

import org.springframework.http.ResponseEntity;

public interface IResource<T> {
    ResponseEntity<?> searchAll();
    ResponseEntity<?> searchById(Integer id);
    ResponseEntity<?> save(T t);
    ResponseEntity<?> update(T t);
    ResponseEntity<?> delete(Integer id);
}
