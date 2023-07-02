public class PokemonCard extends Pokemon {

    PokemonCard(String pokemonName) {
        super(pokemonName);
    }

    PokemonCard(int num) {
        super(num);
    }

    @Override
    public boolean pokemonExists() {
        return this.pokemonExists;
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String getType1() {
        return this.type1;
    }

    @Override
    public String getType2() {
        return this.type2;
    }

    @Override
    public double getAttack() {
        return this.attack;
    }

    @Override
    public double getDefence() {
        return this.defence;
    }

    @Override
    public double getStamina() {
        return this.stamina;
    }
}
