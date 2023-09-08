class Pair{
    int pos, speed;
    Pair(int pos, int speed){
        this.pos = pos;
        this.speed = speed;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        Pair[] cars = new Pair[n];
        for(int i=0; i<n; i++){
            cars[i] = new Pair(position[i], speed[i]);
        }

        Arrays.sort(cars, (a,b) -> a.pos - b.pos);

        Stack<Double> st = new Stack<>();
        for(int i=0; i<n; i++){
            Pair p = cars[i];
            int remDis = target - p.pos;
            double time = (double)remDis/p.speed;

            while(!st.isEmpty() && st.peek() <= time)
                st.pop();

            st.push(time);
        }

        return st.size();
    }
}