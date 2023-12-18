package model.gamIntro;

import model.entity.Player;

public class WelcomePage {
    private Player player;
    public boolean getPlayerName(String input) {
        if (input.matches("\\p{L}+")) {
            String firstLetter = input.substring(0, 1);
            String name = firstLetter.toUpperCase() + input.substring(1).toLowerCase();
            player = new Player(name);
            return true;
        }
        return false;
    }

    public String getWelcomeMsg() {
        return "Welcome " + player.playerName() + ". Do you dare to continue?";
    }

    public String getInvalidNameError() {
        return "Name must only contain letters.";
    }
}
