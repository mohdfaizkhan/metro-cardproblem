package com.mohdfai.repository;

import com.mohdfai.domain.StationEntity;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<StationEntity, Long>{

    StationEntity findByNameAndZone(String name, Integer zone);

}
