import java.io.*;

public abstract class Pokemon {
    int number;
    String name;
    double height;
    double weight;
    String type1;
    String type2;
    double attack;
    double defence;
    double stamina;
    boolean pokemonExists;

    Pokemon(int num) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("assets/pokemon.txt"));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(num + " ")) {
                    this.pokemonExists = true;
                    String[] data = currentLine.split("\\s");
                    this.number = Integer.parseInt(data[0]);
                    this.name = data[1];
                    this.height = Double.valueOf(reader.readLine());
                    this.weight = Double.valueOf(reader.readLine());
                    this.type1 = reader.readLine();
                    this.type2 = reader.readLine();
                    this.attack = Double.valueOf(reader.readLine());
                    this.defence = Double.valueOf(reader.readLine());
                    this.stamina = Double.valueOf(reader.readLine());
                    break;
                }
            }
            reader.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                if (reader != null) reader.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    Pokemon(String name) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("assets/pokemon.txt"));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.toLowerCase().contains(name.toLowerCase())) {
                    this.pokemonExists = true;
                    String[] data = currentLine.split("\\s");
                    this.number = Integer.parseInt(data[0]);
                    this.name = data[1];
                    this.height = Double.valueOf(reader.readLine());
                    this.weight = Double.valueOf(reader.readLine());
                    this.type1 = reader.readLine();
                    this.type2 = reader.readLine();
                    this.attack = Double.valueOf(reader.readLine());
                    this.defence = Double.valueOf(reader.readLine());
                    this.stamina = Double.valueOf(reader.readLine());
                    break;
                }
            }
            reader.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                if (reader != null) reader.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    protected abstract  boolean pokemonExists();
    protected abstract int getNumber();
    protected abstract String getName();
    protected abstract double getHeight();
    protected abstract double getWeight();
    protected abstract String getType1();
    protected abstract String getType2();
    protected abstract double getAttack();
    protected abstract double getDefence();
    protected abstract double getStamina();
}
