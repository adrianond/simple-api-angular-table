package com.example.database.repository;

import com.example.database.entity.TabelaPeriodica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabelaPeriodicaRepository extends CrudRepository<TabelaPeriodica, Integer> {
}
