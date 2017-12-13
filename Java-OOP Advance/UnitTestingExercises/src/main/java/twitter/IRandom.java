package twitter;

public interface IRandom {

    int nextInt(int max);

    class Random implements IRandom {
        private java.util.Random rand;

        public Random() {
            this.rand = new java.util.Random();
        }

        @Override
        public int nextInt(int max) {
            return this.rand.nextInt(max);
        }
    }
}
