class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }
        cars.sort(Comparator.comparingInt(Car::position).reversed());

        int ans = 1;
        double prevTime = cars.getFirst().time(target);
        for (int i = 1; i < cars.size(); i++) {
            double currTime = cars.get(i).time(target);
            if (currTime > prevTime) {
                ans++;
                prevTime = currTime;
            }
        }
        return ans;
    }

    public record Car(int position, int speed) {
        public double time(int target) {
            return (double) (target - position) / speed;
        }
    }
}
