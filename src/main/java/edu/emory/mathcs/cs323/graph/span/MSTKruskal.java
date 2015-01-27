/**
 * Copyright 2014, Emory University
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.emory.mathcs.cs323.graph.span;

import java.util.PriorityQueue;
import java.util.Set;

import edu.emory.mathcs.cs323.graph.Edge;
import edu.emory.mathcs.cs323.graph.Graph;
import edu.emory.mathcs.cs323.utils.DSUtils;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class MSTKruskal implements MSTAlgorithm
{
	@Override
	public SpanningTree getMinimumSpanningTree(Graph graph)
	{
		Set<Integer>[] forest = createForest(graph.size());
		PriorityQueue<Edge> queue = createEdgePQ(graph);
		SpanningTree tree = new SpanningTree();
		Set<Integer> visited;
		Edge edge;
		
		while (!queue.isEmpty())
		{
			edge = queue.poll();
			visited = forest[edge.getTarget()];
			
			if (!visited.contains(edge.getSource()))
			{
				tree.addEdge(edge);
				//If a spanning tree is found, break.
				if (tree.size()+1 == graph.size()) break;
				
				//Merge forests
				visited.addAll(forest[edge.getSource()]);
				//Update all affected forests with merged forest
				for (int i : visited) forest[i] = visited;
			}
		}
		
		return tree;
	}
	
	/**
	 * @param size Size of forest
	 * @return forest that contain each vertex as a forest 
	 */
	@SuppressWarnings("unchecked")
	private Set<Integer>[] createForest(int size)
	{
		Set<Integer>[] forest = (Set<Integer>[])DSUtils.createEmptySetArray(size);
		for (int i=0; i<size; i++) forest[i].add(i);
		return forest;
	}
	
	/**
	 * @param graph Graph
	 * @return PriorityQueue that contains all edges in graph sorted by their weights
	 */
	private PriorityQueue<Edge> createEdgePQ(Graph graph)
	{
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		
		for (Edge edge : graph.getAllEdges())
			queue.add(edge);
		
		return queue;
	}
}
