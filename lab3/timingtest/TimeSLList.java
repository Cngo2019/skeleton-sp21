package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Ns = new AList<>();
        AList<Integer> ops = new AList<>();

        Ns.addLast(100);
        Ns.addLast(2000);
        Ns.addLast(4000);
        Ns.addLast(8000);
        Ns.addLast(16000);
        Ns.addLast(32000);
        Ns.addLast(64000);
        Ns.addLast(128000);

        AList<Double> times = new AList<>();
        SLList<Integer> sLListNs = new SLList<>();
        for (int i = 0; i < Ns.size(); i++) {
            SLList<Integer> list = new SLList<>();
            int currentN = Ns.get(i);

            sLListNs.addLast(currentN);

            for (int j = 0; j < currentN; j++) {
                list.addLast(i);
            }

            Stopwatch watch = new Stopwatch();
            ops.addLast(1000);
            for (int j = 0; j < 1000; j++) {
                list.getLast();
            }
            times.addLast(watch.elapsedTime());

        }

        printTimingTable(Ns, times, ops);
    }

}
