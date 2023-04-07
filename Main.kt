fun main() {
    val secret: String = "test"
    val currentUserWord: String = (underscore + separator).repeat(secret.length).dropLast(1)
    val guess: Char = 'e'
    val newUserWord = generateNewUserWord(secret, guess, currentUserWord)
    println(newUserWord)
}

fun generateNewUserWord(
    secret: String,
    guess: Char,
    currentUserWord: String)
: String {
    val newUserWord = currentUserWord.toCharArray()
    // params:
    // secret = the secret word,
    // guess = the user's guessed letter
    // currentUserWord = current state of guesses
    // function: generates a new sequence of 
    //  underscores and already guessed letters
    for (i in secret.indices) {
        if (secret[i] == guess) {
            newUserWord[i * 2] = guess
        }
    }
    return String(newUserWord)
}

fun isComplete(
    secret: String,
    currentUserWord: String)
: Boolean {
    // checks if the game is complete
    TODO()
}