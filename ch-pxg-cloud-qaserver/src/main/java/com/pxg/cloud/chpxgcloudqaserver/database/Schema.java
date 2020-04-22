
package com.pxg.cloud.chpxgcloudqaserver.database;

import com.alibaba.fastjson.JSON;

/**
 * @author ch_pxg
 * @version v1.0.0
 * @decription 模式
 */
public class Schema {
  private String schemaName;
  private String[] items;

  public Schema( String schemaName, String[] items ) {
    this.schemaName = schemaName;
    this.items = items;
  }

  public Schema() {
  }

  public String getSchemaName() {
    return schemaName;
  }

  public void setSchemaName(String schemaName) {
    this.schemaName = schemaName;
  }

  public String[] getItems() {
    return items;
  }

  public void setItems(String[] items) {
    this.items = items;
  }

  @Override
  public String toString() {
    return JSON.toJSONString(this);
  }
}
