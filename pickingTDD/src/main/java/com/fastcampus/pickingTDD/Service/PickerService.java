package com.fastcampus.pickingTDD.Service;

import com.fastcampus.pickingTDD.Entity.Picker;
import com.fastcampus.pickingTDD.Entity.PickingList;
import org.springframework.stereotype.Service;

@Service
public interface PickerService {

  Picker assignPickingList(Picker picker, PickingList pickingList);

}
