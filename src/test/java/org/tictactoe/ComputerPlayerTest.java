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

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.tictactoe.TicTacToe.*;

public class ComputerPlayerTest {

  @Test
  public void noWinner() {
    Position position =
        ComputerPlayer.nextMoveMiniMax((BoardFixture.DIAGONAL_WINNER_BOARD()), Player.O);
    assertEquals(new Position(0, 1).getPosition(), position.getPosition());
  }
}