class Logger {
    private Map<Integer, Set<String>> map;
    
    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        map.putIfAbsent(timestamp, new HashSet<>());
        Set<String> set = map.get(timestamp);
        int cnt = 0;
        while (timestamp - cnt >= 0 && cnt < 10) {
            int prevTimestamp = timestamp - cnt;
            Set<String> prevSet = map.get(prevTimestamp);
            if (prevSet != null && prevSet.contains(message)) {
                return false;
            }
            cnt++;
        }
        if (set.add(message)) {
            map.put(timestamp, set);
        }
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */