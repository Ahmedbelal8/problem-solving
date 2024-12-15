package leet_code;

import java.util.PriorityQueue;

public class MaximumAveragePassRatio {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int[] classArr : classes) {
            double gain=calculateGain(classArr[0],classArr[1]);
            queue.offer(new double[]{gain,classArr[0],classArr[1]});
        }
        while (extraStudents-->0){
            double[]current = queue.poll();
            int passes=(int)current[1];
            int totalStudents=(int)current[2];
            queue.offer(new double[]{calculateGain(1+passes,1+totalStudents),passes+1, totalStudents+1});
        }

        double totalPassRatio = 0;
        while (!queue.isEmpty()) {
            double[] current = queue.poll();
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            totalPassRatio += (double) passes / totalStudents;
        }

        return totalPassRatio / classes.length;
    }

    private double calculateGain(int passes, int totalStudents) {
        return (double) (passes + 1) / (totalStudents + 1) - (double) passes / totalStudents;
    }
}
