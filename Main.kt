fun main() {
    // print the game rules
    // call playGame()
    // at end of game, display win or lose message
    val wordLength = 4
    val maxAttemptsCount: Int = wordLength * 2
    val secret: String = generateSecretWord()
    printGameRules(wordLength, maxAttemptsCount)
    playGame(secret, maxAttemptsCount)
}

fun generateSecretWord(): String {
    return words.random()
}

fun playGame(secret: String, maxAttemptsCount: Int) {
    // Loop for user input until maxAttemptsCount or word guessed
    var currentUserWord: String = (underscore + separator).repeat(secret.length).dropLast(1)
    var guessed = ""
    var tries = 0
    do {
        println(currentUserWord)
        if (guessed.isNotEmpty()) { println("Guessed letters: $guessed") }
        tries += 1
        println("try number $tries of $maxAttemptsCount:")
        val guess: Char = safeUserInput()
        guessed += guess + separator
        currentUserWord = generateNewUserWord(secret, guess, currentUserWord)

    } while (tries < maxAttemptsCount && !isComplete(secret, currentUserWord))

    if (isComplete(secret, currentUserWord)) {
        println(currentUserWord)
        println("Congratulations! You guessed it!")
    } else {
        println("Sorry, you lost! My word is $secret")
    }
}

fun printGameRules(wordLength: Int, maxAttemptsCount: Int) {
    // Explain how to play
    println("Welcome to the game!$newLineSymbol" +
            newLineSymbol +
            "In this game, you need to guess the word chosen by the computer.$newLineSymbol" +
            "The hidden word will appear as a sequence of underscore characters, one per letter.$newLineSymbol" +
            "You have $maxAttemptsCount attempts to guess the word.$newLineSymbol" +
            "All words are English words, consisting of $wordLength letters.$newLineSymbol" +
            "At each attempt, you should enter one letter; $newLineSymbol" +
            "if it is present in the hidden word, all matches will be displayed.$newLineSymbol" +
            newLineSymbol +
            "For example, if the word CAT was chosen by the computer, _ _ _ will be displayed first,$newLineSymbol" +
            "since the word has 3 letters.$newLineSymbol" +
            "If you enter the letter A, you will see _ A _, and so on.$newLineSymbol" +
            newLineSymbol +
            "Good luck with the game!")
}



fun isCorrectInput(x: String): Boolean {
    // check user input is one english letter
    return if (x.length != 1) {
        println("Error: Your input must be only one character.")
        false
    } else if (x[0].isLetter().not()) {
        println("Error: Your input must be alphabetical.")
        false
    } else
        true
}

fun safeReadLine() = readlnOrNull() ?: error("Your input is incorrect, sorry")

fun safeUserInput(): Char {
    // uses isCorrectInput and convert to uppercase
    var userInput: String
    do {
        println("Please guess a single alphabetical character:")
        userInput = safeReadLine()
    } while (!isCorrectInput(userInput))
    return userInput.uppercase()[0]
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
    val userWord = currentUserWord.replace(separator, "")
    return secret == userWord
}