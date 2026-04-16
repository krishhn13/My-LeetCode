class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (int)(arrivalTime+delayedTime)%24;
    }
}