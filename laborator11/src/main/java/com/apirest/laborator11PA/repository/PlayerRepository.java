package com.apirest.laborator11PA.repository;

import com.apirest.laborator11PA.models.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

    Player findPlayerById(String id);
}
