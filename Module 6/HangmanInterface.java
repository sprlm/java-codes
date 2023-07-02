public interface HangmanInterface {
    void intro();
    int playOneGame(String secretWord);
    void displayHangman(int guessCount);
    String createHint(String secretWord, String guessedLetters);
    char[] readGuess(String guessedLetters, String secretWord);
    String getRandomWord(String filename);
    void stats(int gamesCount, int gamesWon, int best);
}
