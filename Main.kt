fun main() {
    val secret = "test"
    val currentUserWord = (underscore + separator).repeat(secret.length).dropLast(1)
    val guess = "e"
    val newUserWord = generateNewUserWord(secret, guess, currentUserWord)
    println(newUserWord)
}

fun generateNewUserWord(
    secret: String,
    guess: String,
    currentUserWord: String): String {
    val newUserWord = currentUserWord.toCharArray()
    // params:
    // secret = the secret word,
    // guess = the user's guessed letter
    // currentUserWord = current state of guesses
    // function: generates a new sequence of 
    //  underscores and already guessed letters
    for (i in secret.indices) {
        if (secret[i] == guess[0]) {
            newUserWord[i * 2] = guess[0]
        }
    }
    return String(newUserWord)
}

fun isComplete() {
    // checks if the game is complete
    TODO()
}