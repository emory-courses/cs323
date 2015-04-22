/**
 * Copyright 2015, Emory University
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
package edu.emory.mathcs.cs323.graph.match;

import edu.emory.mathcs.cs323.graph.Edge;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public interface Match
{
	/** Adds the edge to this match. */
	void addEdge(Edge edge);

	/** @return true if this match contains the vertex. */
	boolean containsVertex(int vertex);
	
	/** @return true if this match contains the edge. */
	boolean containsEdge(Edge edge);
	
	/** @return the edge matched to the vertex. */
	Edge getMatchedEdge(int vertex);
}
