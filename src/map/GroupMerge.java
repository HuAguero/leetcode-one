package map;

public class GroupMerge {
    public static void main(String[] args) {

        System.out.println(getProvince(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(getProvince(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }

    //T O(N^2)  S O(N)
    private static int getProvince(int[][] citiesConnected) {
        int cities = citiesConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;

        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                dfs(i, cities, visited, citiesConnected);
                provinces++;
            }
        }

        return provinces;
    }

    private static void dfs(int i, int cities, boolean[] visited, int[][] citiesConnected) {
        for (int j = 0; j < cities; j++) {
            if (citiesConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j, cities, visited, citiesConnected);
            }
        }
    }
}
