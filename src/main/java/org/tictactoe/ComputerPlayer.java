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
import java.util.Random;
import java.util.stream.Collectors;
import org.tictactoe.TicTacToe.*;

public class ComputerPlayer {

  private static List<Position> possibleMoves(List<List<Cell>> board) {
    return board.stream()
        .flatMap(
            row ->
                row.stream()
                    .filter(cell -> cell.getPlayer().equals(Player.NONE))
                    .map(Cell::getPosition))
        .collect(Collectors.toList());
  }

  public static Position nextMoveRandom(List<List<Cell>> board) {
    List<Position> possibleMoves = possibleMoves(board);
    int randomMove = new Random().nextInt(possibleMoves.size() - 1);
    return possibleMoves.get(randomMove);
  }

  public static Position nextMoveMiniMax(List<List<Cell>> board, Player player) {
    List<List<Cell>> virtualBoard = board;
    Position result = new Position(0, 0);
    int bestScore = player.equals(Player.O) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

    for (int row = 0; row < board.size(); row++) {
      for (int column = 0; column < board.get(row).size(); column++) {
        if (board.get(row).get(column).getPlayer().equals(Player.NONE)) {
          virtualBoard = Board.nextBoard(virtualBoard, new Position(row, column), Player.O);
          int score = cycleMiniMax(virtualBoard, 0, false);

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

  private static int cycleMiniMax(List<List<Cell>> board, int depth, boolean isMaximizingPlayer) {
    if (GameOps.getWinner(board).equals(Optional.of(Player.X))) {
      return 1;
    }
    if (GameOps.getWinner(board).equals(Optional.of(Player.O))) {
      return -1;
    }
    if (Board.isBoardFull(board)) {
      return 0;
    }

    if (isMaximizingPlayer) {
      int bestScore = Integer.MIN_VALUE;
      for (int row = 0; row < board.size(); row++) {
        for (int column = 0; column < board.get(row).size(); column++) {
          if (board.get(row).get(column).getPlayer().equals(Player.NONE)) {
            board = Board.nextBoard(board, new Position(row, column), Player.O);
            int score = cycleMiniMax(board, depth + 1, false);
            bestScore = Math.max(bestScore, score);
          }
        }
      }
      return bestScore;
    } else {
      int bestScore = Integer.MAX_VALUE;
      for (int row = 0; row < board.size(); row++) {
        for (int column = 0; column < board.get(row).size(); column++) {
          if (board.get(row).get(column).getPlayer().equals(Player.NONE)) {
            board = Board.nextBoard(board, new Position(row, column), Player.X);
            int score = cycleMiniMax(board, depth + 1, true);
            bestScore = Math.min(bestScore, score);
          }
        }
      }
      return bestScore;
    }
  }
}
