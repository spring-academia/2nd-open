package com.fastcampus.inventoryTDD;

public class InventoryHelper {
  public Inventory createInventory(){
    return new Inventory();
  }

  public int getUsableCapa(Inventory inventory){
    return inventory.getCapacity() - inventory.getCurrent();
  }

  public boolean inbound(Inventory inventory, int count){
    if(this.getInboundable(inventory, count)){
      inventory.setCurrent(count);
      return true;
    }

    return false;

  }

  public boolean getInboundable(Inventory inventory, int count){

    return getUsableCapa(inventory) >= count;
  }
}
