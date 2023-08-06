/*
 * Copyright (C) 2023 Mack Solomon LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.tictactoe;

import java.util.List;
import java.util.Optional;
import org.tictactoe.TicTacToe.*;

public class AiPlayer {

  private static List<List<Cell>> localBoard;

  public static Position nextMoveMiniMax(List<List<Cell>> board, Player player) {
    localBoard = board;
    Position result = new Position(0, 0);
    int bestScore = player.equals(Player.O) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

    for (int row = 0; row < localBoard.size(); row++) {
      for (int column = 0; column < localBoard.get(row).size(); column++) {
        if (localBoard.get(row).get(column).getPlayer() == Player.NONE) {
          localBoard = Board.nextBoard(localBoard, new Position(row, column), Player.O);
          int score = cycleMiniMax(0, false);
          localBoard = Board.nextBoard(localBoard, new Position(row, column), Player.NONE);

          if ((player.equals(Player.O) && score > bestScore)
              || (player.equals(Player.X) && score < bestScore)) {
            bestScore = score;
            result = new Position(row, column);
          }
        }
      }
    }

    return result;
  }

  private static int cycleMiniMax(int depth, boolean isMaximizingPlayer) {
    if (GameOps.getWinner(localBoard).equals(Optional.of(Player.O))) {
      return 1;
    }
    if (GameOps.getWinner(localBoard).equals(Optional.of(Player.X))) {
      return -1;
    }
    if (Board.isBoardFull(localBoard)) {
      return 0;
    }

    int bestScore;
    if (isMaximizingPlayer) {
      bestScore = Integer.MIN_VALUE;
      for (int row = 0; row < localBoard.size(); row++) {
        for (int column = 0; column < localBoard.get(row).size(); column++) {
          if (localBoard.get(row).get(column).getPlayer() == Player.NONE) {
            localBoard = Board.nextBoard(localBoard, new Position(row, column), Player.O);
            int score = cycleMiniMax(depth + 1, false);
            localBoard = Board.nextBoard(localBoard, new Position(row, column), Player.NONE);
            bestScore = Math.max(bestScore, score);
          }
        }
      }
    } else {
      bestScore = Integer.MAX_VALUE;
      for (int row = 0; row < localBoard.size(); row++) {
        for (int column = 0; column < localBoard.get(row).size(); column++) {
          if (localBoard.get(row).get(column).getPlayer() == Player.NONE) {
            localBoard = Board.nextBoard(localBoard, new Position(row, column), Player.X);
            int score = cycleMiniMax(depth + 1, true);
            localBoard = Board.nextBoard(localBoard, new Position(row, column), Player.NONE);
            bestScore = Math.min(bestScore, score);
          }
        }
      }
    }
    return bestScore;
  }
}
