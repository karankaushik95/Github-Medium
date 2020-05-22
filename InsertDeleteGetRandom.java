// https://leetcode.com/problems/insert-delete-getrandom-o1/

class RandomizedSet {

    private HashMap<Integer,Integer> setMap;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        setMap = new HashMap<Integer,Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
        if(setMap.containsKey(val))
            return false;
        setMap.put(val,1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if((setMap.containsKey(val))){
            setMap.remove(val);
            return true;
        }
            return false;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        List<Integer> keysAsArray = new ArrayList<Integer>(setMap.keySet());
        Random r = new Random();
        return keysAsArray.get(r.nextInt(keysAsArray.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */