class RandomizedSet {
    private final Map<Integer, Integer> map = new HashMap<>();
    private final List<Integer> list = new ArrayList<>();
    private final Random rand = ThreadLocalRandom.current();

    public RandomizedSet() {}
    
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int lastVal = list.get(list.size() - 1);
        int targetIdx = map.get(val);
        
        // val에 해당하는 인덱스에 마지막 값 대입하고 마지막 인덱스 값 제거
        list.set(targetIdx, lastVal);
        list.remove(list.size() - 1);

        //기존 val 엔트리 쌍을 지우고, map val에 해당하는 index를 list의 마지막 값과 연결.
        map.put(lastVal, targetIdx);
        map.remove(val);
        return true; 
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */