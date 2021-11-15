package statistacs;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(bf(100));
        System.out.println(eratosthenes(100));
    }

    public static int bf(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    private static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int eratosthenes(int n){
        boolean[] isPrime = new boolean[n];//false 是素数
        int count = 0;
        for(int i = 2; i < n;i++){
            if(!isPrime[i]){
                count ++ ;
                for(int j = i *i;j<n;j+=i){//j就是合数的标记位
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }
}
