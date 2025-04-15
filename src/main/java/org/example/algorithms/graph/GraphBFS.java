package org.example.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    // 图的邻接表表示
    private LinkedList<Integer>[] adjList;
    private boolean[] visited;
    private int vertexCount;

    // 构造函数，初始化图
    public GraphBFS(int vertexCount) {
        this.vertexCount = vertexCount;
        adjList = new LinkedList[vertexCount];
        visited = new boolean[vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            adjList[i] = new LinkedList<>();
            visited[i] = false; // 初始化访问标记数组为false
        }
    }

    // 添加边（无向图）
    public void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v); // 无向图需要添加双向边
    }

    // 获取顶点的第一个邻接点
    private int firstNeighbor(int v) {
        return adjList[v].isEmpty() ? -1 : adjList[v].getFirst();
    }

    // 获取顶点v在w之后的下一个邻接点
    private int nextNeighbor(int v, int w) {
        int index = adjList[v].indexOf(w);
        if (index == -1 || index == adjList[v].size() - 1) {
            return -1;
        }
        return adjList[v].get(index + 1);
    }

    // 访问顶点的方法
    private void visit(int v) {
        System.out.print(v + " ");
    }

    // BFS遍历实现
    public void BFS(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();

        visit(startVertex);          // 访问初始顶点
        visited[startVertex] = true; // 标记为已访问
        queue.add(startVertex);      // 入队列

        while (!queue.isEmpty()) {
            int current = queue.poll(); // 出队列

            // 遍历所有邻接点
            for (int w = firstNeighbor(current); w >= 0; w = nextNeighbor(current, w)) {
                if (!visited[w]) {
                    visit(w);          // 访问顶点
                    visited[w] = true; // 标记为已访问
                    queue.add(w);      // 入队列
                }
            }
        }
    }

    public static void main(String[] args) {
        // 创建图（8个顶点，对应图片中的visited数组）
        GraphBFS graph = new GraphBFS(8);

        // 添加边（示例连接关系）
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 7);

        System.out.println("BFS遍历顺序（从顶点0开始）：");
        graph.BFS(0); // 从顶点0开始BFS遍历

        System.out.println("\nvisited数组最终状态：");
        for (int i = 0; i < graph.vertexCount; i++) {
            System.out.print(graph.visited[i] + " ");
        }
    }
}
