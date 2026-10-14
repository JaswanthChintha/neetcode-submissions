/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
           if(intervals.size()==0) return 0;
           Collections.sort(intervals,(a,b)->a.start-b.start);
           List<Integer> rooms=new ArrayList<>();
           for(Interval meeting:intervals){
            boolean placed=false;
            for(int i=0;i<rooms.size();i++){
                if(rooms.get(i)<=meeting.start){
                    rooms.set(i,meeting.end);
                    placed=true;
                    break;
                }
            }
            if(!placed){
                rooms.add(meeting.end);
            }
           }
           return rooms.size();
    }
}
