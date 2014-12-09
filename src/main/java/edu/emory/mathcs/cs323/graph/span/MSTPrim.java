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

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import edu.emory.mathcs.cs323.graph.Edge;
import edu.emory.mathcs.cs323.graph.Graph;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class MSTPrim implements MSTAlgorithm
{
	@Override
	public SpanningTree getMinimumSpanningTree(Graph graph)
	{
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		SpanningTree tree = new SpanningTree();
		Set<Integer> visited = new HashSet<>();
		Edge edge;
		
		add(queue, visited, graph, 0);
		
		while (!queue.isEmpty())
		{
			edge = queue.poll();
			
			if (!visited.contains(edge.getSource()))
			{
				tree.addEdge(edge);
				if (tree.size()+1 == graph.size()) break;
				add(queue, visited, graph, edge.getSource());
			}
		}
		
		return tree;
	}
	
	private void add(PriorityQueue<Edge> queue, Set<Integer> visited, Graph graph, int target)
	{
		visited.add(target);
		
		for (Edge edge : graph.getIncomingEdges(target))
		{
			if (!visited.contains(edge.getSource()))
				queue.add(edge);
		}
	}
}
