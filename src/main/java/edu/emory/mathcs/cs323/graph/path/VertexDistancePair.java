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
package edu.emory.mathcs.cs323.graph.path;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class VertexDistancePair implements Comparable<VertexDistancePair>
{
	public int    vertex;
	public double distance;
	
	public VertexDistancePair(int vertex, double distance)
	{
		this.vertex = vertex;
		this.distance = distance;
	}

	@Override
	public int compareTo(VertexDistancePair p)
	{
		double diff = this.distance - p.distance;
		if (diff > 0) return  1;
		if (diff < 0) return -1;
		return 0;
	}
}