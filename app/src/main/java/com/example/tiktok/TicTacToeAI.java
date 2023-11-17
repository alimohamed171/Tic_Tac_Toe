package com.example.tiktok;


public class TicTacToeAI {
    public static int findBestMove(int[] boxPositions) {
        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;

        for (int i = 0; i < boxPositions.length; i++) {
            if (boxPositions[i] == 0) {
                // Make a move and get the score for this move
                boxPositions[i] = 2; // Assume AI's move is represented by 2
                int score = minimax(boxPositions, 0, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
                boxPositions[i] = 0; // Undo the move

                // Update the best move if a better score is found
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }

        return bestMove;
    }



    private static int minimax(int[] boxPositions, int depth, boolean isMaximizing, int alpha, int beta) {
        int score = evaluate(boxPositions);

        if (score == 10 || score == -10 || !isMovesLeft(boxPositions)) {
            return score;
        }

        if (isMaximizing) {
            int maxEval = Integer.MIN_VALUE;

            for (int i = 0; i < boxPositions.length; i++) {
                if (boxPositions[i] == 0) {
                    boxPositions[i] = 2; // Assume AI's move is represented by 2
                    maxEval = Math.max(maxEval, minimax(boxPositions, depth + 1, false, alpha, beta));
                    boxPositions[i] = 0; // Undo the move

                    alpha = Math.max(alpha, maxEval);

                    if (beta <= alpha) {
                        break; // Beta cut-off
                    }
                }
            }

            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;

            for (int i = 0; i < boxPositions.length; i++) {
                if (boxPositions[i] == 0) {
                    boxPositions[i] = 1; // Assume player's move is represented by 1
                    minEval = Math.min(minEval, minimax(boxPositions, depth + 1, true, alpha, beta));
                    boxPositions[i] = 0; // Undo the move

                    beta = Math.min(beta, minEval);

                    if (beta <= alpha) {
                        break; // Alpha cut-off
                    }
                }
            }

            return minEval;
        }
    }

    private static int evaluate(int[] boxPositions) {
        // Check for a win or a draw
        int result = checkForWin(boxPositions);
        if (result == 2) {
            return 10; // AI wins
        } else if (result == 1) {
            return -10; // Player wins
        } else if (!isMovesLeft(boxPositions)) {
            return 0; // Draw
        }

        return 0; // No winner yet
    }

    private static int checkForWin(int[] boxPositions) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (boxPositions[i * 3] == boxPositions[i * 3 + 1] && boxPositions[i * 3 + 1] == boxPositions[i * 3 + 2]) {
                if (boxPositions[i * 3] == 2) {
                    return 2; // AI wins
                } else if (boxPositions[i * 3] == 1) {
                    return 1; // Player wins
                }
            }

            // Check columns
            if (boxPositions[i] == boxPositions[i + 3] && boxPositions[i + 3] == boxPositions[i + 6]) {
                if (boxPositions[i] == 2) {
                    return 2; // AI wins
                } else if (boxPositions[i] == 1) {
                    return 1; // Player wins
                }
            }
        }

        // Check diagonals
        if (boxPositions[0] == boxPositions[4] && boxPositions[4] == boxPositions[8]) {
            if (boxPositions[0] == 2) {
                return 2; // AI wins
            } else if (boxPositions[0] == 1) {
                return 1; // Player wins
            }
        }

        if (boxPositions[2] == boxPositions[4] && boxPositions[4] == boxPositions[6]) {
            if (boxPositions[2] == 2) {
                return 2; // AI wins
            } else if (boxPositions[2] == 1) {
                return 1; // Player wins
            }
        }

        return 0; // No winner yet
    }


    private static boolean isMovesLeft(int[] boxPositions) {
        // Check if there are still empty boxes
        for (int position : boxPositions) {
            if (position == 0) {
                return true;
            }
        }
        return false;
    }
}
