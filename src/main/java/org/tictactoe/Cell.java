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

import org.tictactoe.TicTacToe.*;

public class Cell {
  private final Position position;
  private final Player player;

  public Cell(int row, int column, Player player) {
    this.position = new Position(row, column);
    this.player = player;
  }

  public Player getPlayer() {
    return this.player;
  }

  public Position getPosition() {
    return this.position;
  }
}
