import acm.program.*;

public class Hangman extends ConsoleProgram {

    private int guessCount;
    private String hint;
    private char guess;

    public void run() {
        //intro();                          PUT INTRO LATER
        guessCount = playOneGame("PROGRAMMER");
    }

    // TODO: comment this method
    private void intro() {
        println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        println("        Welcome to Hangman!       ");
        println("  I will think of a random word.  ");
        println(" You'll try to guess its letters. ");
        println("  Every time you guess a letter   ");
        println("  that isn't my word, a new body  ");
        println(" part of the hanging man appears. ");
        println("            Good luck!            ");
        println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

    }

    // TODO: comment this method
    private int playOneGame(String secretWord) {
        String guessedLetters = " ";
        guessCount = 8;
        while (guessCount != 0) {
            hint = createHint(secretWord, guessedLetters);
            println("Secret Word: " + hint);
            println("Your guesses:" + guessedLetters);
            println("Guesses left: " + guessCount);
            guess = readGuess(guessedLetters);
            guessedLetters = guessedLetters + guess;
        }
        return guessCount;
    }


    // TODO: comment this method
    private String createHint(String secretWord, String guessedLetters) {
        hint = "";
        boolean correct = false;
        for (int i = 0; i < secretWord.length(); i++) {

            for (int j = 0; j < guessedLetters.length(); j++){
                char c = guessedLetters.charAt(j);
                if (secretWord.indexOf(c) >= 0) {
                    correct = true;
                }
            }
            if (correct) {
                hint = hint + secretWord.charAt(i);
            }
            else hint = hint + "-";
        }
        return hint;
    }

    // TODO: comment this method
    private char readGuess(String guessedLetters) {
        while (true) {
            boolean repeated = false;
            println("Your guess?");
            String input = readLine();
            input.toUpperCase();
            if (input.length() != 1 || !input.matches("[a-zA-Z]+")) {
                println("Type a single letter from A-Z.");
                continue;
            }
            char c = input.charAt(0);
            c = Character.toUpperCase(c);
            for(int i = 0; i < guessedLetters.length(); i++) {
                if(guessedLetters.charAt(i) == c) {
                    println("You already guessed that letter.");
                    repeated = true;
                    break;
                }
            }
            if(repeated) continue;
            return c;
        }
    }

    // TODO: comment this method
    private void displayHangman(int guessCount) {
        // TODO: write this method
    }

    // TODO: comment this method
    private void stats(int gamesCount, int gamesWon, int best) {
        // TODO: write this method
    }

    // TODO: comment this method
    private String getRandomWord(String filename) {
        // TODO: write this method
        return "";
    }

    public void init() {
        canvas = new HangmanCanvas();
        add(canvas);
        canvas.reset();  // sample canvas method call
    }


    /* Solves NoClassDefFoundError */
    public static void main(String[] args) {
        new Hangman().start(args);
    }


    // private HangmanCanvas canvas;
    private HangmanCanvas canvas;
}
