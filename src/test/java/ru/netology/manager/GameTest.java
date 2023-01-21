package ru.netology.manager;

import ru.netology.data.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.exception.NotRegisteredException;


public class GameTest {

    Game manager = new Game();
    Player player1 = new Player(19, "МощныеШтаны", 50);
    Player player2 = new Player(6, "Разрушитель3000", 63);
    Player player3 = new Player(28, "Агент00Победа", 49);
    Player player4 = new Player(5, "Старожил", 82);
    Player player5 = new Player(3, "Кратос", 82);

    @BeforeEach
    public void setup() {
        manager.registered(player1);
        manager.registered(player3);
        manager.registered(player4);
        manager.registered(player5);
    }

    @Test
    public void shouldFindRegisteredPlayerId() {
        int expected = 3;
        int actual = manager.findById("Кратос");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindUnregisteredPlayerId() {
        int expected = -1;
        int actual = manager.findById("Разрушитель3000");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinFirstPlayer() {
        int expected = 1;
        int actual = manager.round("МощныеШтаны", "Агент00Победа");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {
        int expected = 2;
        int actual = manager.round("МощныеШтаны", "Старожил");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldDrawEqualStrength() {
        int expected = 0;
        int actual = manager.round("Кратос", "Старожил");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowExceptionIfFirstPlayerUnregistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("Разрушитель3000", "Старожил");
        });
    }

    @Test
    public void shouldShowExceptionIfSecondPlayerUnregistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("Агент00Победа", "Разрушитель3000");
        });
    }
}