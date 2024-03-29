/*
 * Copyright (C) 2023 Mack Solomon
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

import java.util.*;

public class TicTacToe {

  public enum Player {
    X,
    O,
    NONE
  }

  public static class State {
    public static Player currentPlayer = Player.X;
    private static Optional<Player> winner = Optional.empty();
    private static List<List<Cell>> board = new Board().getBoard();
  }

  public static void main(String[] args) {

    while (true) {
      GameOps.print("");

      if (State.currentPlayer.equals(Player.X)) {
        Position move =
            GameOps.parseMove(GameOps.input("Player " + State.currentPlayer + " enter your move:"));

        State.board = Board.nextBoard(State.board, move, State.currentPlayer);

        Board.renderBoard(State.board);
      } else {
        Position move = AiPlayer.nextMoveMiniMax(State.board, Player.O);

        GameOps.print("Player O moved into position " + move);

        State.board = Board.nextBoard(State.board, move, State.currentPlayer);

        Board.renderBoard(State.board);
      }

      State.winner = GameOps.getWinner(State.board);

      if (State.winner.isPresent()) {
        GameOps.print("");
        GameOps.print("Game over, player " + State.winner.get() + " wins");
        break;
      }

      if (Board.isBoardFull(State.board)) {
        GameOps.print("");
        GameOps.print("Tie Game!");
        break;
      }

      State.currentPlayer = GameOps.nextPlayer(State.currentPlayer);
    }
  }
}
