public class Main {

    public static <MyGraph> void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(false);
        fillWithWeights(weightedGraph);
        System.out.println("DFS:");
        MyGraph<String> graph = null;
        Search<String> dfs = new DFS<>(graph, "Moscow");
        outputPath(dfs, "Pitersburg");
        System.out.println("____________________");
        graph = new MyGraph<>(false);
        fillWithoutWeights(graph);
        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Moscow");
        outputPath(djk, "Pitersburg");
        System.out.println("_____________________");
        System.out.println("BFS:");
        Search<String> bfs;
        bfs = new BFS<>(graph, "Moscow");
        outputPath(bfs, "Pitersburg");
    }
    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + "-->");
        }
        System.out.println();
    }
    public static void fillWithoutWeights(MyGraph<String> graph) {
        graph.addEdge("Moscow", "Kazan");
        graph.addEdge("Kazan", "Omsk");
        graph.addEdge("Omsk", "Samara");
        graph.addEdge("Kazan", "Pitersburg");
        graph.addEdge("Moscow", "Omsk");
        graph.addEdge("Kazan", "Aoi");
        graph.addEdge("Aoi", "Omsk");


    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Moscow", "Omsk", 3.3);
        graph.addEdge("Kazan", "Aoi", 8.6);
        graph.addEdge("Aoi", "Omsk", 6.1);
        graph.addEdge("Moscow", "Kazan", 1.8);
        graph.addEdge("Kazan", "Omsk", 4.6);
        graph.addEdge("Omsk", "Samara", 5.5);
        graph.addEdge("Kazan", "Pitersburg", 6.4);
    }




}