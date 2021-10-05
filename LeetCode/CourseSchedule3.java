class CourseSchedule3 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
        int t = 0;
        for(int[] course: courses) {
            queue.add(course[0]);
            t += course[0];
            if(t > course[1]) {
                t -= queue.poll();
            }
        }
        
        return queue.size();
    }
}
