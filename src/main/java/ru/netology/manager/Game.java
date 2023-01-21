package ru.netology.manager;

import ru.netology.data.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.HashMap;

public class Game {
    private HashMap<String, Player> players = new HashMap();

    public void registered(String name, Player player) {
        players.put(name, player);
    }

    public int round(String playerName1, String playerName2) {
        Player PlayerOne = players.get(playerName1);
        Player PlayerTwo = players.get(playerName2);
        if (PlayerOne == null) {
            throw new NotRegisteredException("Для участия в турнире игрок должен быть зарегестрирован");
        }
        if (PlayerTwo == null) {
            throw new NotRegisteredException("Для участия в турнире игрок должен быть зарегестрирован");
        }
        if (PlayerOne.getStrength() > PlayerTwo.getStrength()) {
            return 1;
        } else if (PlayerOne.getStrength() < PlayerTwo.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}