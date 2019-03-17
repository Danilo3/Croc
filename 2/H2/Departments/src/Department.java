public class Department {

    private int delay;

    private Department[] sub;

    public Department(int delay, Department... sub) {
        this.delay = delay;
        this.sub = sub;
    }

    public int totalDelay(){
        int sum = delay;
        if(sub != null){
            int max  = 0;
            for(Department child : sub) {
                max = Math.max(max, child.totalDelay());
            }
            sum += max;
        }
        return sum;
    }
}
