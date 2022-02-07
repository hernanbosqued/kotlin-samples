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

    private fun minimax(isComputer: Boolean): Int {
        return when (hasWinner(if (isComputer) 'X' else 'O')) {
            'X' -> 1
            'O' -> -1
            'T' -> 0
            else -> bestMove(!isComputer).first
        }
    }

    private fun bestMove(isComputer: Boolean): Pair<Int, Int> {
        var result = (if (isComputer) Int.MIN_VALUE else Int.MAX_VALUE) to -1

        board.board.forEachIndexed { index, c ->
            if (board.isEmpty(index, players)) {
                board.place(index, if (isComputer) 'X' else 'O')
                val score = minimax(isComputer = isComputer)
                board.place(index, c)
                if ((isComputer && score > result.first) || (!isComputer && score < result.first)) {
                    result = score to index
                }
            }
        }
        return result
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
                val bestMove = bestMove(true)
                board.place(bestMove.second, 'X')
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
    }.also {
        print("\n")
    }
}

