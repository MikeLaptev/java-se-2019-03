package org.mlaptev.otus;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.Graphs;
import com.google.common.graph.MutableGraph;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloOtus {

  private static final Logger logger = LogManager.getLogger(HelloOtus.class);

  public static void main(String[] args) {

    MutableGraph<String> graph =
        GraphBuilder.undirected()
            .allowsSelfLoops(false)
            .build();
    graph.putEdge("a", "b");
    graph.putEdge("b", "c");
    graph.putEdge("c", "a");

    if (Graphs.hasCycle(graph)) {
      logger.error("Graph {} has cycle(s)!", graph);
    }
  }
}
