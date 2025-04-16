class LFUCache {
    class Node {
        int key, value, freq;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
    int capacity, minFreq;
    Map<Integer, Node> keyNode;                  // key -> Node
    Map<Integer, LinkedHashSet<Integer>> freqMap; // freq -> keys with this freq
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyNode = new HashMap<>();
        freqMap = new HashMap<>();
    }
    public int get(int key) {
        if (!keyNode.containsKey(key)) return -1;
        Node node = keyNode.get(key);
        updateFreq(node);
        return node.value;
    }
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (keyNode.size() == capacity) {
                // Evict least freq & least recently used key
                LinkedHashSet<Integer> minFreqKeys = freqMap.get(minFreq);
                int keyToRemove = minFreqKeys.iterator().next();
                minFreqKeys.remove(keyToRemove);
                if (minFreqKeys.isEmpty()) freqMap.remove(minFreq);
                keyNode.remove(keyToRemove);
            }
            Node newNode = new Node(key, value);
            keyNode.put(key, newNode);
            freqMap.computeIfAbsent(1, f -> new LinkedHashSet<>()).add(key);
            minFreq = 1;
        }
    }
    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        freqMap.get(oldFreq).remove(node.key);
        if (freqMap.get(oldFreq).isEmpty()) {
            freqMap.remove(oldFreq);
            if (minFreq == oldFreq) minFreq++;
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq, f -> new LinkedHashSet<>()).add(node.key);
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */