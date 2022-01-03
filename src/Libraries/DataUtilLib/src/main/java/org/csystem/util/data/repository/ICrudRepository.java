package org.csystem.util.data.repository;

import java.util.Optional;

public interface ICrudRepository<T, ID> {
    long count() throws Exception;
    void delete(T entity) throws Exception;
    void deleteAll() throws Exception;
    void deleteAll(Iterable<? extends T> entities) throws Exception;
    void deleteById(ID id) throws Exception;
    boolean existsById(ID id) throws Exception;
    Iterable<T> findAll() throws Exception;
    Iterable<T> findAllById(Iterable<ID> ids) throws Exception;
    Optional<T> findById(ID id) throws Exception;
    <S extends T> S save(S entity) throws Exception;
    <S extends T> Iterable<S> save(Iterable<S> entities) throws Exception;
}
