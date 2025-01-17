/*

 * Copyright (C) 2020-2022 Huawei Technologies Co., Ltd. All rights reserved.

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huaweicloud.governance.authentication.provider;

import java.util.ArrayList;
import java.util.List;

public class BlackWhiteListProperties {

  static class ConfigurationItem {
    static final String CATEGORY_PROPERTY = "property";

    private String category;

    private String propertyName;

    private String rule;

    public String getCategory() {
      return category;
    }

    public void setCategory(String category) {
      this.category = category;
    }

    public String getPropertyName() {
      return propertyName;
    }

    public void setPropertyName(String propertyName) {
      this.propertyName = propertyName;
    }

    public String getRule() {
      return rule;
    }

    public void setRule(String rule) {
      this.rule = rule;
    }
  }

  private List<ConfigurationItem> black = new ArrayList<>();

  private List<ConfigurationItem> white = new ArrayList<>();

  public List<ConfigurationItem> getBlack() {
    return black;
  }

  public void setBlack(
      List<ConfigurationItem> black) {
    this.black = black;
  }

  public List<ConfigurationItem> getWhite() {
    return white;
  }

  public void setWhite(
      List<ConfigurationItem> white) {
    this.white = white;
  }
}
