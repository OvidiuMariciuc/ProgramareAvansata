package com.apirest.laborator11PA.controllers;

import com.apirest.laborator11PA.models.Player;
import com.apirest.laborator11PA.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> getPlayers() {
        List<Player> players = playerService.getPlayers();
        return new ResponseEntity<>(players, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        player = this.playerService.add(player);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Player> modifyPlayerName(@PathVariable String id, @RequestParam String name) {
        Player player = this.playerService.modifyName(id, name);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Player> deletePlayer(@PathVariable String id) {
        Player player = this.playerService.delete(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }


}
