package com.mohdfai.repository;

import com.mohdfai.domain.AgglomerationEntity;
import org.springframework.data.repository.CrudRepository;

public interface AgglomerationRepository extends CrudRepository<AgglomerationEntity, Long>{

    AgglomerationEntity findByName(String name);

}
