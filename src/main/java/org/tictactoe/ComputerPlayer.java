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
import java.util.Random;
import java.util.stream.Collectors;

public class ComputerPlayer {

  private static List<Position> possibleMoves(List<List<Cell>> board) {
    return board.stream()
        .flatMap(
            row -> {
              return row.stream()
                  .filter(cell -> cell.getPlayer().equals(TicTacToe.Player.NONE))
                  .map(Cell::getPosition);
            })
        .collect(Collectors.toList());
  }

  public static Position nextMoveRandom(List<List<Cell>> board) {
    List<Position> possibleMoves = possibleMoves(board);
    int randomMove = new Random().nextInt(possibleMoves.size() - 1);
    return possibleMoves.get(randomMove);
  }
}
