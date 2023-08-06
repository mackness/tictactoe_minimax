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

import static org.junit.Assert.assertEquals;

import java.util.Optional;
import org.junit.Test;
import org.tictactoe.TicTacToe.*;

public class TicTacToeTest {

  @Test
  public void noWinner() {
    Optional<Player> winner = GameOps.getWinner(BoardFixture.NO_WINNER_BOARD());
    assertEquals(Optional.empty(), winner);
  }

  @Test
  public void winnerHorizontal() {
    Optional<Player> winner = GameOps.getWinner(BoardFixture.HORIZONTAL_WINNER_BOARD());
    assertEquals(Optional.of(Player.X), winner);
  }

  @Test
  public void winnerVertical() {
    Optional<Player> winner = GameOps.getWinner(BoardFixture.VERTICAL_WINNER_BOARD());
    assertEquals(Optional.of(Player.X), winner);
  }

  @Test
  public void winnerDiagonal() {
    Optional<Player> winner = GameOps.getWinner(BoardFixture.DIAGONAL_WINNER_BOARD());
    assertEquals(Optional.of(Player.X), winner);
  }

  @Test
  public void reverseWinnerDiagonal() {
    Optional<Player> winner = GameOps.getWinner(BoardFixture.REVERSE_DIAGONAL_WINNER_BOARD());
    assertEquals(Optional.of(Player.X), winner);
  }
}
