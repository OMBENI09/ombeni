fun main(args: Array<String>) {
    // Step 1: Check if an integer is provided as a command line argument
    if (args.size != 1) {
        println("Usage: Enter one integer as a command line argument.")
        return
    }

    try {
        // Step 2: Parse the input as an integer
        val number = args[0].toInt()

        // Step 2a: Check if the integer is within the valid range
        if (number < 0 || number > 999999) {
            println("Number out of range. Please enter a positive integer with six or fewer digits.")
            return
        }

        // Step 3: Convert the integer to words
        val words = convertNumberToWords(number)

        // Step 4: Display the result
        println("Number in words: $words")
    } catch (e: NumberFormatException) {
        println("Invalid input. Please enter a valid integer.")
    }
}

fun convertNumberToWords(number: Int): String {
    val units = arrayOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val teens = arrayOf("eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
    val tens = arrayOf("", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

    if (number == 0) {
        return "zero"
    }

    val parts = mutableListOf<String>()

    // Handle hundreds place
    val hundreds = number / 100
    if (hundreds > 0) {
        parts.add("${units[hundreds]} hundred")
    }

    // Handle tens and ones places
    val remainder = number % 100
    if (remainder > 0) {
        if (remainder < 10) {
            parts.add(units[remainder])
        } else if (remainder < 20) {
            parts.add(teens[remainder - 11])
        } else {
            parts.add(tens[remainder / 10])
            if (remainder % 10 > 0) {
                parts.add(units[remainder % 10])
            }
        }
    }

    return parts.joinToString(" ")
}
