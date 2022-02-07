package hernanbosqued.samples

import java.util.Scanner

fun main(args: Array<String>) {
    println("winner: ${Game().play()}")
}

class Game {
    private val board = Board()
    private val players = arrayOf('X', 'O')
    private var moves = 0
    private var currentPlayer = players[0]
    private val reader = Scanner(System.`in`)

    private fun minimax(isComputer: Boolean, player: Char): Int {
        return when (hasWinner(player)) {
            'O' -> {
                -1
            }
            'X' -> {
                1
            }
            'T' -> {
                0
            }
            else -> {
                if (isComputer) {
                    var bestMove = Int.MIN_VALUE
                    board.board.forEachIndexed { index, c ->
                        if (board.isEmpty(index, players)) {
                            board.place(index, 'X')
                            val score = minimax(isComputer = false, player = 'X')
                            board.place(index, c)
                            bestMove = Integer.max(bestMove, score)
                        }
                    }
                    bestMove
                } else {
                    var bestMove = Int.MAX_VALUE
                    board.board.forEachIndexed { index, c ->
                        if (board.isEmpty(index, players)) {
                            board.place(index, 'O')
                            val score = minimax(isComputer = true, player = 'O')
                            board.place(index, c)
                            bestMove = Integer.min(bestMove, score)
                        }
                    }
                    bestMove
                }
            }
        }
    }

    private fun computerMove() {
        var bestScore = Int.MIN_VALUE
        var bestIndex = Int.MIN_VALUE
        board.board.forEachIndexed { index, c ->
            if (board.isEmpty(index, players)) {
                board.place(index, 'X')
                val score = minimax(isComputer = false, player = 'X')
                board.place(index, c)
                if (score > bestScore) {
                    bestScore = score
                    bestIndex = index
                }
            }
        }
        board.place(bestIndex, 'X')
    }

    private fun playerMove() {
        print("-> ")

        when (val input = reader.next().single()) {
            in '1'..'9' -> board.place(Character.getNumericValue(input) - 1, currentPlayer)
            else -> Unit
        }
    }

    fun play(): Char {
        while (hasWinner(currentPlayer) == null) {
            currentPlayer = players[moves % players.size]
            board.print()

            if (currentPlayer == 'O') {
                playerMove()
            } else {
                computerMove()
            }

            moves++
        }
        return hasWinner(currentPlayer)!!
    }

    private fun hasWinner(player: Char): Char? {
        val hasWinner = (board.board[0] == board.board[1] && board.board[1] == board.board[2]) ||
                (board.board[3] == board.board[4] && board.board[4] == board.board[5]) ||
                (board.board[6] == board.board[7] && board.board[7] == board.board[8]) ||

                (board.board[0] == board.board[3] && board.board[3] == board.board[6]) ||
                (board.board[1] == board.board[4] && board.board[4] == board.board[7]) ||
                (board.board[2] == board.board[5] && board.board[5] == board.board[8]) ||

                (board.board[0] == board.board[4] && board.board[4] == board.board[8]) ||
                (board.board[6] == board.board[4] && board.board[4] == board.board[2])

        return when {
            board.empties(players).isEmpty() && hasWinner.not() -> 'T'
            hasWinner -> player
            else -> null
        }
    }
}

class Board {
    val board = arrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9')

    fun isEmpty(index: Int, players: Array<Char>) = players.none { player -> player == board[index] }

    fun empties(players: Array<Char>) = board.filter { item -> players.none { player -> player == item } }

    fun place(index: Int, player: Char) {
        board[index] = player
    }

    fun print() = board.forEachIndexed { index, c ->
        print(" $c ")
        if ((index + 1) % 3 == 0) {
            print("\n")
        }
    }

    override fun toString(): String {
        var str = String()
        board.forEachIndexed { index, c ->
            str += " $c "
            if ((index + 1) % 3 == 0) {
                str += "\n"
            }
        }
        return str
    }
}

