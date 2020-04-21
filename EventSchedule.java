class EventSchedule {
    public int maxEvents(int[][] events) {
        int noOfEvents = 0;
        
        HashMap<Integer,Integer> eventsMap = new HashMap<Integer,Integer>();
        

        //Sort the events by end time
        Arrays.sort(events, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        for(int i=0; i<events.length; i++){
            for(int j=events[i][0]; j<=events[i][1]; j++){
                if(!eventsMap.containsKey(j)){
                    eventsMap.put(j,1);
                    noOfEvents++;
                    break;
                }
            }
        }
        
        return noOfEvents;
    }
}