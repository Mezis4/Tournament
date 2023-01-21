package ru.netology.manager;

import ru.netology.data.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public boolean registered(Player player) {
        return players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        int idPlayerOne = findById(playerName1);
        int idPlayerTwo = findById(playerName2);
        if (idPlayerOne == -1) {
            throw new NotRegisteredException("Для участия в турнире игрок должен быть зарегестрирован");
        }
        if (idPlayerTwo == -1) {
            throw new NotRegisteredException("Для участия в турнире игрок должен быть зарегестрирован");
        }
        if (players.get(idPlayerOne).getStrength() > players.get(idPlayerTwo).getStrength()) {
            return 1;
        } else if (players.get(idPlayerOne).getStrength() < players.get(idPlayerTwo).getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

    public int findById(String playerNick) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(playerNick)) {
                return players.indexOf(player);
            }
        }
        return -1;
    }
}