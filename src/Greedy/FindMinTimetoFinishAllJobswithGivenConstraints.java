package Greedy;

/*
 *  Q:
Given an arr of jobs with dif time reqs
k assignees available
how much time an assignee takes to do one unit of job

 *  Thought Process: 
isPossible()[Greedy]:if it possible to finish all jobs in time given and # of asiignees
[BinarySearch]if middle impossible, search in 2nd half, else 1st half
 *  Get:
isPossible: we traverse through all jobs and keep assigning jobs to curr assignee
when exceeds, create a new assignee
if > k false; else true;
 */

/**
 *
 * @author xinrong
 */

public class FindMinTimetoFinishAllJobswithGivenConstraints {   
    int getMax(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > res) res = arr[i];
        }
        return res;
    }
    // return true if it is possible to finish jobs[] within given time
    boolean isPossible(int time, int K, int[] jobs) {
        int cnt = 1; // curr assignee
        int curr_time = 0; // time assigned to curr assignee
        for (int i = 0; i < jobs.length; ) {
            if (curr_time + jobs[i] > time) {  
                cnt++;
                curr_time = 0;
            } else { // add time of job to curr_time and move
                curr_time += jobs[i];
                i++;
            }
        }
        return cnt <= K;
    }

    int findMinTime(int K, int T, int[] job) {
        int start = 0, end = 0;
        for (int i = 0; i < job.length; i++) end += job[i];
        int ans = end;
        int jobmax = getMax(job);
        while (start <= end) {
            int mid = (start + end) / 2;
            // if possible to finish jobs in mid time
            if (mid >= jobmax && isPossible(mid, K, job)) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans * T;
    }
}
