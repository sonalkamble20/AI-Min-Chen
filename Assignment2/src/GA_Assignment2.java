import java.util.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class GA_Assignment2 {
    static final int N = 20;
    static final double PC = 0.7;
    static final double PM = 0.001;
    static final int BITS = 10;
    static final int MAX_GEN = 20;
    static final Random RNG = new Random(42);

    static int decode(String bits) { return Integer.parseInt(bits, 2); }

    static double fitness(int x) {
        return x * Math.sin(x * Math.PI / 1024.0);
    }

    static String randomChrom() {
        StringBuilder sb = new StringBuilder(BITS);
        for (int i = 0; i < BITS; i++) sb.append(RNG.nextBoolean() ? '1' : '0');
        return sb.toString();
    }

    static String rouletteSelect(String[] pop, double[] fit) {
        double min = Arrays.stream(fit).min().orElse(0.0);
        double shift = (min <= 0) ? -min + 1e-9 : 0.0;
        double total = 0.0;
        double[] w = new double[fit.length];
        for (int i = 0; i < fit.length; i++) { w[i] = fit[i] + shift; total += w[i]; }
        double r = RNG.nextDouble() * total, acc = 0.0;
        for (int i = 0; i < pop.length; i++) { acc += w[i]; if (acc >= r) return pop[i]; }
        return pop[pop.length - 1];
    }

    static String[] crossover(String p1, String p2) {
        if (RNG.nextDouble() > PC) return new String[]{p1, p2};
        int point = 1 + RNG.nextInt(BITS - 1);
        String c1 = p1.substring(0, point) + p2.substring(point);
        String c2 = p2.substring(0, point) + p1.substring(point);
        return new String[]{c1, c2};
    }

    static String mutate(String bits) {
        char[] b = bits.toCharArray();
        for (int i = 0; i < b.length; i++) {
            if (RNG.nextDouble() < PM) b[i] = (b[i] == '1') ? '0' : '1';
        }
        return new String(b);
    }

    public static void main(String[] args) throws Exception {
        String[] pop = new String[N];
        for (int i = 0; i < N; i++) pop[i] = randomChrom();

        List<String> bestCSV = new ArrayList<>();
        List<String> avgCSV  = new ArrayList<>();
        bestCSV.add("generation,best_fitness");
        avgCSV.add("generation,avg_fitness");

        String bestBits = null;
        int bestX = -1;
        double bestFit = Double.NEGATIVE_INFINITY;

        for (int g = 0; g <= MAX_GEN; g++) {
            int[] xs = new int[N];
            double[] fits = new double[N];
            for (int i = 0; i < N; i++) { xs[i] = decode(pop[i]); fits[i] = fitness(xs[i]); }

            int gi = 0;
            for (int i = 1; i < N; i++) if (fits[i] > fits[gi]) gi = i;

            double genBest = fits[gi];
            double genAvg = Arrays.stream(fits).sum() / N;
            if (genBest > bestFit) { bestFit = genBest; bestBits = pop[gi]; bestX = xs[gi]; }

            bestCSV.add(g + "," + genBest);
            avgCSV.add(g + "," + genAvg);

            if (g == MAX_GEN) break;

            String[] next = new String[N];
            int k = 0;
            while (k < N) {
                String p1 = rouletteSelect(pop, fits);
                String p2 = rouletteSelect(pop, fits);
                String[] children = crossover(p1, p2);
                next[k++] = mutate(children[0]);
                if (k < N) next[k++] = mutate(children[1]);
            }
            pop = next;
        }

        System.out.println("Best fitness: " + bestFit);
        System.out.println("Best X: " + bestX);
        System.out.println("Best chromosome: " + bestBits);

        Files.write(Paths.get("best_fitness.csv"), String.join("\n", bestCSV).getBytes(StandardCharsets.UTF_8));
        Files.write(Paths.get("avg_fitness.csv"), String.join("\n", avgCSV).getBytes(StandardCharsets.UTF_8));
        System.out.println("Wrote best_fitness.csv and avg_fitness.csv");
    }
}
