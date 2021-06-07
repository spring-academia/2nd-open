package com.fastcampus.inventoryTDD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTests {

  @Test
  void testInventory_size_test(){
    Inventory inventory = new Inventory();

    inventory.setLength(10);
    inventory.setWidth(10);
    inventory.setHeight(10);

    Assertions.assertEquals(10, inventory.getLength());
    Assertions.assertEquals(10, inventory.getWidth());
    Assertions.assertEquals(10, inventory.getHeight());
  }

  @Test
  void testInventory_type_test(){
    Inventory inventory = new Inventory();
    inventory.setType(InventoryTypeEnum.COLD);

    Assertions.assertEquals(InventoryTypeEnum.COLD, inventory.getType());
  }

  @Test
  void testInventory_capacity_test(){
    Inventory inventory = new Inventory();
    inventory.setCapacity(10);


    Assertions.assertEquals(10, inventory.getCapacity());
  }

  @Test
  void testInventory_current_test(){
    Inventory inventory = new Inventory();
    inventory.setCurrent(5);

    Assertions.assertEquals(5, inventory.getCurrent());
  }
}
