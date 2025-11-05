import java.util.ArrayList;
import java.util.List;

class Job{
    String jobId;
    int deadline;
    int profit;

    public Job(String jobId, int deadline, int profit) {
        this.jobId = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class Exp2 {
    public static void jobSequencing(List<Job> jobs){
        //Step 1: Sort jobs by decreasing profit
        jobs.sort((a,b) -> b.profit - a.profit);

        //Step 2: Find maximum deadline
        int maxDeadline = 0;
        for(Job job : jobs){
            if(job.deadline > maxDeadline){
                maxDeadline = job.deadline;
            }
        }

        //Step 3: Initialize time slots (null = free)
        String[] slots = new String[maxDeadline + 1];
        int totalProfit = 0;

        //Step 4: Assign jobs to slots
        for(Job job : jobs){
            for(int slot = job.deadline; slot > 0; slot--){
                if(slots[slot] == null){
                    slots[slot] = job.jobId;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        //Step 5: Display result
        System.out.print("Scheduled Jobs: ");
        for(int i = 1; i <= maxDeadline; i++){
            if(slots[i] != null){
                System.out.print(slots[i] + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }
    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("J1", 2, 100));
        jobs.add(new Job("J2", 1, 19));
        jobs.add(new Job("J3", 2, 27));
        jobs.add(new Job("J4", 1, 25));
        jobs.add(new Job("J5", 3, 15));

        jobSequencing(jobs);
    }
}
