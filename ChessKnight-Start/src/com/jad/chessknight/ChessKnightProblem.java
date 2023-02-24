package com.jad.chessknight;

/**
 * The type Chess knight problem.
 */
public abstract class ChessKnightProblem {
    /**
     * Solve.
     *
     * @throws CloneNotSupportedException the clone not supported exception
     */
    public static void solve() throws CloneNotSupportedException {
        ChessBoard chessBoard = new ChessBoard();
        ChessKnight chessKnight = new ChessKnight(chessBoard, 0, 0);
        chessKnight.moveTo(0, 0);

        // Calcul du nombre total de mouvements possibles
        int height = chessBoard.getHeight();
        int width = chessBoard.getWidth();
        int totalSquares = height * width;
        int totalMoves = totalSquares - 1;

        // Boucle pour parcourir toutes les cases du plateau (en dehors de la case de départ)
        for (int i = 1; i <= totalMoves; i++) {
            // Trouver le prochain mouvement optimal pour le cavalier
            int[] nextMove = getNextMove(chessKnight, chessBoard);
            // Déplacer le cavalier vers la prochaine case
            int nextX = nextMove[0];
            int nextY = nextMove[1];
            chessKnight.moveTo(nextX, nextY);
        }

        System.out.println(chessBoard);
    }



    private static int[] getNextMove(ChessKnight chessKnight, ChessBoard chessBoard) {
        // Récupération de la position actuelle du cavalier
        int x = chessKnight.getX();
        int y = chessKnight.getY();

        // Initialisation des variables pour stocker le prochain mouvement optimal
        int[] nextMove = new int[2];
        int minMoves = Integer.MAX_VALUE;
        int count;

        // Mouvements possible du cavalier
        int[][] possiblesMoves = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

        // Parcourir tous les mouvements possibles du cavalier
        for (int i = 0; i < 8; i++) {
            int nextX = x + possiblesMoves[i][0];
            int nextY = y + possiblesMoves[i][1];

            // Si la case suivante est valide, vérifie si le nombre de mouvements restants est inférieur au minimum actuel
            if (nextX >= 0 && nextX < chessBoard.getWidth() && nextY >= 0 && nextY < chessBoard.getHeight() &&
                    chessBoard.getAt(nextX, nextY).getValue() == 0) {
                count = 0;

                // Compte le nombre de mouvements possibles à partir de cette case
                for (int j = 0; j < 8; j++) {
                    int nextNextX = nextX + possiblesMoves[j][0];
                    int nextNextY = nextY + possiblesMoves[j][1];

                    if (nextNextX >= 0 && nextNextX < chessBoard.getWidth() && nextNextY >= 0 && nextNextY < chessBoard.getHeight() &&
                            chessBoard.getAt(nextNextX, nextNextY).getValue() == 0) {
                        count++;
                    }
                }

                // Si cette case a moins de mouvements possibles que la case précédente, on met à jour les valeurs des variables
                if (count < minMoves) {
                    nextMove[0] = nextX;
                    nextMove[1] = nextY;
                    minMoves = count;
                }
            }
        }

        return nextMove;
    }

}


