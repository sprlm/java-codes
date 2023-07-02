import acm.program.ConsoleProgram;
import java.io.*;

public class Module6_2 extends ConsoleProgram {

    private PokemonCanvas canvas;

    public void run() {
        int choice;
        while (true) {
            displayMenu();
            choice = readInt(">> ");

            if (choice < 1 || choice > 5) println("\nInvalid choice.\n");

            else if (choice == 1) {
                try {
                    removePokemon();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (choice == 2) viewPokemon();
            else if (choice == 3) {
                try {
                    viewSlideshow();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if (choice == 4) searchPokemon();
            else System.exit(0);

        }
    }

    private void displayMenu() {
        println("Choose:");
        println("1) Remove Pokemon");
        println("2) View One Pokemon");
        println("3) View Slideshow");
        println("4) Search for a Pokemon");
        println("5) Quit");
    }

    private void removePokemon() throws IOException {
        String name = readLine("\nInput name of Pokemon: ");
        PokemonCard pokemon = new PokemonCard(name);
        if (!pokemon.pokemonExists()) {
            println("Error: The name of the Pokemon could not be found.\n");
            return;
        }
        PrintWriter writer = new PrintWriter("assets/pokemonNew.txt");
        BufferedReader reader = null;
        boolean firstFlag = false;
        try {
            reader = new BufferedReader(new FileReader("assets/pokemon.txt"));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.toLowerCase().contains(name.toLowerCase())) {
                    for (int i = 0; i < 7; i++)  reader.readLine();
                    continue;
                }
                if (!firstFlag) {
                    writer.write(currentLine);
                    firstFlag = true;
                }
                else writer.write("\n" + currentLine);
            }
            reader.close();
            writer.close();
        }
        catch(IOException ex){
                ex.printStackTrace();
            }
        finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        File f = new File("assets/pokemon.txt");
        boolean b = f.delete();

        File f1 = new File("assets/pokemonNew.txt");
        File f2 = new File("assets/pokemon.txt");
        boolean b2 = f1.renameTo(f2);
        if (b && b2) println("\nRemoval successful.\n");
    }


    private void viewPokemon() {
        int num = readInt("\nInput number of pokemon: ");
        PokemonCard pokemon = new PokemonCard(num);
        if (pokemon.getNumber() == num) {
            canvas.displayPokemon(pokemon);
        }
        else println("Error: No Pokemon with that number exists.\n");
    }

    private void viewSlideshow() throws InterruptedException {
        for (int i = 1; i < 21; i++) {
            PokemonCard pokemon = new PokemonCard(i);
            if (pokemon.getNumber() == i) {
                canvas.displayPokemon(pokemon);
            }
            else continue;
            Thread.sleep(3000);
        }
    }

    private void searchPokemon() {
        String pokemonName = readLine("\nInput name of Pokemon: ");
        PokemonCard pokemon = new PokemonCard(pokemonName);
        if (pokemon.getName().toLowerCase().contains(pokemonName.toLowerCase())) {
            canvas.displayPokemon(pokemon);
        }
        else println("Error: The name of the Pokemon could not be found.\n");
    }

    public void init() {
        canvas = new PokemonCanvas();
        add(canvas);
    }


    /* Solves NoClassDefFoundError */
    public static void main(String[] args) {
        new Module6_2().start(args);
    }
}
