package com.apirest.laborator11PA.services;

import com.apirest.laborator11PA.models.Player;
import com.apirest.laborator11PA.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getPlayers() {
        List<Player> players = playerRepository.findAll();
        return players;
    }

    public Player add(Player player) {
        this.playerRepository.insert(player);
        return player;
    }

    public Player modifyName(String id, String name) {
        Player player = this.playerRepository.findPlayerById(id);
        player.setName(name);
        this.playerRepository.save(player);
        return player;
    }

    public Player delete(String id) {
        Player player = this.playerRepository.findPlayerById(id);
        playerRepository.deleteById(id);
        return player;
    }
}
