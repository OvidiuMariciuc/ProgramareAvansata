import java.util.Random;

public class Lab1Optional {

    public static void DFS(int x, int nrc, boolean matrix[][], int Visited[], int n) {
        int i;
        Visited[x] = nrc;
        for (i = 0; i < n; i++)
            if (matrix[x][i] == true && Visited[i] == 0) {
                DFS(i, nrc, matrix, Visited, n);
            }
    }

    public static void main(String args[]) {
        int n, k, nrc;
        String[] words = new String[31];
        n = Integer.parseInt(args[0]);
        k = Integer.parseInt(args[1]);
        Random rand = new Random();
        int[] Neighbors = new int[31];
        int[] Visited = new int[31];
        int nrnmax = 0, nrnmin = 31;
        //generare array
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < k; j++) {
                int c = rand.nextInt(args.length - 2) + 2;
                s.append(args[c]);
            }
            words[i] = s.toString();
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%s ", words[i]);
        }
        //generare matrice
        boolean[][] m = new boolean[31][31];
        for (int i1 = 0; i1 < n; i1++) {
            Neighbors[i1] = 0;
            for (int j1 = 0; j1 < n; j1++) {
                if (i1 != j1) {
                    boolean ok = false;
                    //verificare litera comuna
                    for (int i2 = 0; i2 < k; i2++) {
                        for (int j2 = 0; j2 < k; j2++)
                            if (words[i1].charAt(i2) == words[j1].charAt(j2)) ok = true;
                    }
                    if (ok) {
                        m[i1][j1] = true;
                        m[j1][i1] = true;
                        Neighbors[i1]++;
                    }

                }
            }
            //calculare nrmax, nrmin de vecini
            if (nrnmax <= Neighbors[i1]) nrnmax = Neighbors[i1];
            if (nrnmin >= Neighbors[i1]) nrnmin = Neighbors[i1];
        }
        System.out.printf("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%B ", m[i][j]);
            }
            System.out.printf("\n");
        }
        /*System.out.printf("%d %d\n", nrnmax, nrnmin);
        for (int i = 0; i < n; i++)
            if (Neighbors[i] == nrnmax) System.out.printf("%s ", words[i]);
        System.out.printf("\n");
        for (int i = 0; i < n; i++)
            if (Neighbors[i] == nrnmin) System.out.printf("%s ", words[i]);
         */

        nrc = 0;
        for (int i = 0; i < n; i++)
            if (Visited[i] == 0) {
                nrc++;
                DFS(i, nrc, m, Visited, n);
            }
        System.out.printf("\n");
        System.out.printf("%d\n", nrc);
        for (int i = 1; i <= nrc; i++) {
            for (int j = 0; j < n; j++)
                if (Visited[j] == i) System.out.printf("%s ", words[j]);
            System.out.printf("\n");
        }
    }
}
