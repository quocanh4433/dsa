import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    /*
        time
            - insert():     O(1)
            - remove():     O(1)
            - getRandom():     O(1)

        space O(n)
    */

    private final List<Integer> list;
    private final Map<Integer, Integer> map;
    private final Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int last = list.get(list.size() - 1);

        // đưa vị trị cuối lên vị trí cần xóa
        map.put(last, index);
        list.set(index, last);

        // xóa phần tử cuối
        list.remove(list.size() - 1);

        // xóa khỏi map
        map.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        int index = random.nextInt(list.size()); // sinh ra một số ngẫu nhiên từ 0 <= x < list.size()
        return list.get(index);
    }
}
