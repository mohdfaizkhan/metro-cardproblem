package com.mohdfai.metrocard.repository;

import com.mohdfai.metrocard.domain.Card;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Date;

@Repository
public interface CardRepository extends ReactiveMongoRepository<Card, String> {
    Flux<Card> findByCheckInTimeGreaterThan(Date date);
}
