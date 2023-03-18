package LeetCode;

import java.util.*;

public class CityDeliveryOrder {
    public static int[] cityDeliveryOrder(int cityNodes, List<Integer> cityFrom, List<Integer> cityTo, int company) {
        // create   graph
        List<int[]>[] graph = new List[cityNodes + 1];
        for (int i = 1; i <= cityNodes; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < cityFrom.size(); i++) {
            int from = cityFrom.get(i);
            int to = cityTo.get(i);
            graph[from].add(new int[]{to, 1}); // assume all roads have distance 1
            graph[to].add(new int[]{from, 1});
        }

        // Dijkstra algorithm
        int[] distance = new int[cityNodes + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[company] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        pq.offer(new int[]{company, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int dist = curr[1];
            if (dist > distance[node]) {
                continue; // skip if has shorter path
            }
            for (int[] neighbor : graph[node]) {
                int nextNode = neighbor[0];
                int nextDist = dist + neighbor[1];
                if (nextDist < distance[nextNode]) {
                    distance[nextNode] = nextDist;
                    pq.offer(new int[]{nextNode, nextDist});
                }
            }
        }

        // Sort  by distance and priority
        List<Integer> cities = new ArrayList<>();
        for (int i = 1; i <= cityNodes; i++) {
            if (i != company) {
                cities.add(i);
            }
        }
        cities.sort((a, b) -> distance[a] != distance[b] ? distance[a] - distance[b] : a - b);

        // Convert the list to an array
        return cities.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int cityNodes = 4;
        List<Integer> cityFrom = Arrays.asList(1, 2, 2);
        List<Integer> cityTo = Arrays.asList(2, 3, 4);
        int company = 1;

//        int cityNodes = 5;
//        List<Integer> cityFrom = Arrays.asList(1,1, 2, 3,1);
//        List<Integer> cityTo = Arrays.asList(2, 3, 4, 5, 5);
//        int company = 1;

        int[] order = cityDeliveryOrder(cityNodes, cityFrom, cityTo, company);
        System.out.println(Arrays.toString(order)); // [2, 3, 4]
    }
}
