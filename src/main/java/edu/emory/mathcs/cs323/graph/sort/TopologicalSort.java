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
package edu.emory.mathcs.cs323.graph.sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import edu.emory.mathcs.cs323.graph.Edge;
import edu.emory.mathcs.cs323.graph.Graph;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class TopologicalSort
{
	public List<Integer> sort(Graph graph)
	{
		Deque<Integer> global = graph.getVerticesWithNoIncomingEdges();
		Deque<Edge>[] outgoingEdgesAll = graph.getOutgoingEdges();
		List<Integer> order = new ArrayList<Integer>();
		
		while (!global.isEmpty())
		{
			Deque<Integer> local = new ArrayDeque<>();
			int vertex = global.poll();
			order.add(vertex);
			Deque<Edge> outgoingEdges = outgoingEdgesAll[vertex];
			
			while (!outgoingEdges.isEmpty())
			{
				Edge edge = outgoingEdges.poll();
				List<Edge> incomingEdges = graph.getIncomingEdges(edge.getTarget());
				incomingEdges.remove(edge);
				
				if (incomingEdges.isEmpty())
					local.add(edge.getTarget());
			}
			
			while (!local.isEmpty())
				global.addLast(local.removeFirst());
//				global.addFirst(local.removeLast());
		}
		
		if (!graph.isEmpty()) throw new IllegalArgumentException("Cyclic graph.");
		return order;
	}
}
