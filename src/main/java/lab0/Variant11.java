package lab0;

public class Variant11 {

    public static void main(String[] args) {
        System.out.println(stringTask("wasd"));
    }

    /**
     *
     * @param a
     * @param b
     * @return array of sum, difference, product and quotient of abs(a), abs(b)
     */
    public static double[] inputOutputTask(double a, double b) {
        double absA = Math.abs(a);
        double absB = Math.abs(b);

        double sum = absA + absB;
        double difference = absA - absB;
        double product = absA * absB;
        double quotient = absA / absB;

        return new double[] {sum, difference, product, quotient};
    }

    /**
     *
     * @param num
     * @return array of sum and product digits of num
     */
    public static int[] integerNumbersTask(int num) {
        int digit1 = num / 100;
        int digit2 = (num / 10) % 10;
        int digit3 = num % 10;

        int sum = digit1 + digit2 + digit3;
        int product = digit1 * digit2 * digit3;

        return new int[] {sum, product};
    }

    /**
     *
     * @param a
     * @param b
     * @return true if a and b have the same parity
     */
    public static boolean booleanTask(int a, int b) {
        return a % 2 == b % 2;
    }

    /**
     *
     * @param a
     * @param b
     * @return array of changed a, b
     */
    public static int[] ifTask(int a, int b) {
        if (a != b) {
            int max = a > b ? a : b;
            a = max;
            b = max;
        } else {
            a = 0;
            b = 0;
        }

        return new int[] {a, b};
    }


    /**
     *
     * @param initialOrientation
     * @param command1
     * @param command2
     * @return final position
     */
    public static char switchTask(char initialOrientation, int command1, int command2) {
        char[] orientations = {'N', 'W', 'S', 'E'};

        int currentIndex = switch (initialOrientation) {
            case 'N' -> 0;
            case 'W' -> 1;
            case 'S' -> 2;
            case 'E' -> 3;
            default -> 0;
        };

        currentIndex = (currentIndex + command1) % 4;
        if (currentIndex < 0) {
            currentIndex += 4;
        }

        currentIndex = (currentIndex + command2) % 4;
        if (currentIndex < 0) {
            currentIndex += 4;
        }

        return orientations[currentIndex];
    }

    /**
     *
     * @param n
     * @return sum n^2 + (n+1)^2 + ... (2*n)^2
     */
    public static int forTask(int n) {
        if (n <= 0) {throw new IllegalArgumentException("n must be > 0");}

        int sum = 0;
        for (int i = n; i <= 2 * n; i++) {
            sum += i * i;
        }

        return sum;
    }

    /**
     *
     * @param n
     * @return smallest k that 1 + 2 + ... + k >= n
     */
    public static int whileTask(int n) {
        if (n <= 1) {throw new IllegalArgumentException("n must be > 1");}

        int k = 0;
        int sum = 0;
        while (sum < n) {
            k++;
            sum += k;
        }

        return k;
    }

    /**
     * `
     * @param k
     * @param arr
     * @return true if there are number less than k in arr
     */
    public static boolean seriesTask(int k, int[] arr) {
        for (int num : arr) {
            if (num < k) {
                return true;
            }
        }

        return false;
    }


    public static int[] functionTask(int a, int b, int c, int d) {
        int[] arr = minMax(a, b);
        a = arr[0]; b = arr[1];

        arr = minMax(c, d);
        c = arr[0]; d = arr[1];

        arr = minMax(a, c);
        a = arr[0]; c = arr[1];

        arr = minMax(b, d);
        b = arr[0]; d = arr[1];

        return new int[] {a, d};
    }

    public static int[] minMax(int x, int y) {
        if (x > y) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        return new int[] {x, y};
    }

    public static int minMaxTask(int[] arr) {
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            } else if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }

        return Math.max(minIndex, maxIndex);
    }

    public static int[] arrayTask(int[] a, int k) {
        int[] nums = new int[a.length / k];

        int j = 0;
        for (int i = k - 1; i < a.length; i += k) {
            nums[j] = a[i];
            j++;
        }

        return nums;
    }

    public static int[]  twoDimensionArrayTask(int[][] arr) {
        int[] res = new int[arr.length * arr[0].length];
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    res[k] = arr[j][i];
                    k++;
                }
            } else {
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    res[k] = arr[j][i];
                    k++;
                }
            }
        }

        return res;
    }

    public static String stringTask(String s) {
        StringBuilder sb = new StringBuilder();

        for (String c : s.split("")) {
            sb.append(c);
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}