import acm.graphics.*;

import java.awt.*;

class PokemonCanvas extends GCanvas {

    private Color type1Color;

    void displayPokemon(PokemonCard pokemon) {
        GImage background = new GImage("assets/" + pokemon.getType1() + ".jpg");
        background.scale(.5);
        add(background, 0, 0);

        GLabel num = new GLabel("#" + pokemon.getNumber());
        num.setColor(Color.WHITE);
        num.setFont("SansSerif-Bold-40");
        add(num, 10, 40);

        GImage sprite = new GImage("assets/" + pokemon.getName() + ".png");
        sprite.scale(1.5);
        add(sprite, (getWidth() - sprite.getWidth()) / 2, getHeight() * .1);

        displayInfo(pokemon);
        displayType(pokemon);
        displayStats(pokemon);
    }

    private void displayInfo(PokemonCard pokemon) {
        GRect textBG = new GRect(getWidth(), getHeight() * .25);
        textBG.setFilled(true  );
        textBG.setColor(new Color(0, 0, 0, 100));
        add(textBG, 0, getHeight() * .4);

        GLabel name = new GLabel(pokemon.getName().toUpperCase());
        name.setColor(Color.WHITE);
        name.setFont("SansSerif-Bold-40");
        add(name, (getWidth() - name.getWidth()) / 2, getHeight() * .4 + 40);

        GLabel height = new GLabel("Height: " + pokemon.getHeight() + "m");
        height.setColor(Color.WHITE);
        height.setFont("SansSerif-Italic-25");
        add(height, (getWidth() - height.getWidth()) / 2, getHeight() * .4 + 70);

        GLabel weight = new GLabel("Weight: " + pokemon.getWeight() + "kg");
        weight.setColor(Color.WHITE);
        weight.setFont("SansSerif-Italic-25");
        add(weight, (getWidth() - weight.getWidth()) / 2, getHeight() * .4 + 100);
    }

    private void displayType(PokemonCard pokemon) {
        GRect type1BG;
        GRect type2BG;

        if (pokemon.getType2().equals("null")) {
            type1BG = new GRect(getWidth(), getHeight() * .1);
        } else {
            type1BG = new GRect(getWidth() / 2, getHeight() * .1);
            type2BG = new GRect(getWidth() / 2, getHeight() * .1);
            type2BG.setFilled(true);
            switch (pokemon.getType2()) {
                case "Fire":
                    type2BG.setColor(Color.RED.darker());
                    break;
                case "Dark":
                    type2BG.setColor(Color.MAGENTA.darker());
                    break;
                case "Grass":
                    type2BG.setColor(Color.GREEN.darker());
                    break;
                case "Ground":
                    type2BG.setColor(Color.YELLOW.darker());
                    break;
                case "Ice":
                    type2BG.setColor(Color.CYAN);
                    break;
                case "Water":
                    type2BG.setColor(Color.BLUE.brighter());
                    break;
                case "Dragon":
                    type2BG.setColor(Color.BLUE.darker());
                    break;
                case "Fighting":
                    type2BG.setColor(Color.RED.darker().darker());
                    break;
                case "Steel":
                    type2BG.setColor(Color.LIGHT_GRAY);
                    break;
            }
            add(type2BG, getWidth() / 2, getHeight() * .65);

            GLabel type2 = new GLabel(pokemon.getType2().toUpperCase());
            type2.setColor(Color.WHITE);
            type2.setFont("SansSerif-*-25");
            add(type2, (getWidth() + type2BG.getWidth() - type2.getWidth()) / 2, getHeight() * .70 + 8);
        }
        type1BG.setFilled(true);
        switch (pokemon.getType1()) {
            case "Fire":
                type1BG.setColor(type1Color = Color.RED.darker());
                break;
            case "Dark":
                type1BG.setColor(type1Color = Color.MAGENTA.darker());
                break;
            case "Grass":
                type1BG.setColor(type1Color = Color.GREEN.darker());
                break;
            case "Ground":
                type1BG.setColor(type1Color = Color.YELLOW.darker());
                break;
            case "Ice":
                type1BG.setColor(type1Color = Color.CYAN);
                break;
            case "Water":
                type1BG.setColor(type1Color = Color.BLUE.brighter());
                break;
            case "Dragon":
                type1BG.setColor(type1Color = Color.BLUE.darker());
                break;
            case "Fighting":
                type1BG.setColor(type1Color = Color.RED.darker().darker());
                break;
            case "Steel":
                type1BG.setColor(type1Color = Color.LIGHT_GRAY);
                break;
        }
        add(type1BG, 0, getHeight() * .65);

        GLabel type1 = new GLabel(pokemon.getType1().toUpperCase());
        type1.setColor(Color.WHITE);
        type1.setFont("SansSerif-*-25");
        add(type1, (type1BG.getWidth() - type1.getWidth()) / 2, getHeight() * .70 + 8);
    }

    private void displayStats(PokemonCard pokemon) {
        GRect statsBG = new GRect(getWidth(), getHeight() * .25);
        statsBG.setFilled(true);
        statsBG.setColor(Color.DARK_GRAY.darker());
        add(statsBG, 0, getHeight() * .75);

        GLabel attack = new GLabel("ATTACK");
        attack.setColor(Color.WHITE);
        attack.setFont("SansSerif-*-20");
        add(attack, 15, getHeight() * .75 + 30);

        displayStatBar(pokemon.getAttack(), getHeight() * .75 + 17);

        GLabel defence = new GLabel("DEFENCE");
        defence.setColor(Color.WHITE);
        defence.setFont("SansSerif-*-20");
        add(defence, 15, getHeight() * .75 + 65);

        displayStatBar(pokemon.getDefence(), getHeight() * .75 + 52);

        GLabel stamina = new GLabel("STAMINA");
        stamina.setColor(Color.WHITE);
        stamina.setFont("SansSerif-*-20");
        add(stamina, 15, getHeight() * .75 + 100);

        displayStatBar(pokemon.getStamina(), getHeight() * .75 + 87);
    }

    private void displayStatBar(double statValue, double y) {
        for (double i = 1.0; i <= 10; i++) {
            GRect statBar = new GRect(20, 10);
            statBar.setFilled(true);
            if ((i / 10.0) <= statValue) statBar.setColor(type1Color);
            else statBar.setColor(Color.DARK_GRAY);
            add(statBar, 140 + (i * 20), y);
        }
    }
}

