class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int startAlice = getDayOfYear(arriveAlice, daysInMonths);
        int endAlice = getDayOfYear(leaveAlice, daysInMonths);
        int startBob = getDayOfYear(arriveBob, daysInMonths);
        int endBob = getDayOfYear(leaveBob, daysInMonths);
        
        int overlapStart = Math.max(startAlice, startBob);
        int overlapEnd = Math.min(endAlice, endBob);
        
        return Math.max(0, overlapEnd - overlapStart + 1);
    }
    
    private int getDayOfYear(String date, int[] daysInMonths) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        
        int dayOfYear = day;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonths[i];
        }
        return dayOfYear;
    }
}