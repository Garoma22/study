package Part1.DigitsAndStrings.PhoneNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TotalMap {
  private final Map<String, List<String>> commonMap = new HashMap<>();

    Map<String, List<String>> fillMap(List<String> valids, List<String> invalids) {
        commonMap.put("Невалидные номера", invalids);
        commonMap.put("Валидные номера", valids);
        return commonMap;
    }
}
