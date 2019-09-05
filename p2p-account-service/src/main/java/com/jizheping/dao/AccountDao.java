package com.jizheping.dao;

import com.jizheping.api.entity.Account;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao extends JpaRepository<Account,Long> {
    @Override
    List<Account> findAll();

    @Override
    List<Account> findAll(Sort sort);

    @Override
    List<Account> findAllById(Iterable<Long> iterable);

    @Override
    <S extends Account> List<S> saveAll(Iterable<S> iterable);

    @Override
    void flush();

    @Override
    <S extends Account> S saveAndFlush(S s);

    @Override
    void deleteInBatch(Iterable<Account> iterable);

    @Override
    void deleteAllInBatch();

    @Override
    Account getOne(Long aLong);

    @Override
    <S extends Account> List<S> findAll(Example<S> example);

    @Override
    <S extends Account> List<S> findAll(Example<S> example, Sort sort);
}
