package map;

import array.FibonacciSequence;

import java.util.LinkedList;
import java.util.Queue;

public class GroupMerge {
    public static void main(String[] args) {

        System.out.println(getProvinceMergeFind(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(getProvinceMergeFind(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
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

    private static int getProvinceBfs(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                queue.offer(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    for (int j = 0; j < cities; j++) {
                        if (isConnected[v][j] == 1 && !visited[j]) {
                            visited[j]=true;
                            queue.offer(j);
                        }
                    }
                }
                provinces++;
            }
        }
        return provinces;
    }

    public static int getProvinceMergeFind(int[][] isConnected){
        int cities = isConnected.length;
        int[] head = new int[cities];
        int[] level = new int[cities];

        for(int i = 0; i < cities;i++){
            head[i]=i;
            level[i]=1;
        }

        for(int i = 0; i < cities;i++){
            for(int j = i + 1; j< cities;j++){
                if(isConnected[i][j] == 1){
                    merge(i,j,head,level);
                }
            }
        }

        int count = 0;
        for(int i = 0; i < cities;i++){
            if(head[i] == i){
                count++;
            }
        }

        return count;
    }

    private static void merge(int i, int j, int[] head, int[] level) {
        int x = find(i,head);
        int y = find(j,head);

        if(x == y){
            return;
        }

        if(level[x] <= level[y]){
            head[x] = y;
        }
        else {
            head[y] = x;
        }

        if(level[x] == level[y]){
            level[x]++;
            level[y]++;
        }
    }

    private static int find(int i, int[] head) {
        if(i == head[i]){
            return i;
        }

        head[i] = find(head[i],head);
        return head[i];
    }
}
