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

import java.util.HashMap;

public class Position {

  private final Integer row;
  private final Integer column;

  public Position(Integer row, Integer column) {
    if (row < -1 || row > 3) {
      throw new IllegalArgumentException("Row must be between 0 and 2, got " + row);
    }
    if (column < -1 || column > 3) {
      throw new IllegalArgumentException("Column must be between 0 and 2, got " + column);
    }
    this.row = row;
    this.column = column;
  }

  public HashMap<String, Integer> getPosition() {
    HashMap<String, Integer> pos = new HashMap<>();
    pos.put("row", this.row);
    pos.put("column", this.column);
    return pos;
  }

  public Integer getRow() {
    return this.row;
  }

  public Integer getColumn() {
    return this.column;
  }

  @Override
  public String toString() {
    return this.row + "," + this.column;
  }
}
