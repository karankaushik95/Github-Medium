class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> indexList = new ArrayList<Integer>();
        
        // Iterate over the big string
        for(int i = 0; i<= s.length() - p.length(); i++){
            
            // If you find a character in the String
            if(p.indexOf(s.charAt(i))>=0){
                // Call the method
                if(checkStrings(s.substring(i, i+p.length()),p)){
                    indexList.add(i);    
                }        
            }
            
        }
         
        return indexList;
    }
    
    public static boolean checkStrings(String subString, String originalString){
        
        char[] subStringArray = subString.toCharArray();
        char[] originalStringArray = originalString.toCharArray();
        
        // Sort both arrays
        Arrays.sort(subStringArray);
        Arrays.sort(originalStringArray);
        
        // Compare them
        return (new String(subStringArray)).equals(new String(originalStringArray));
        
    }

}