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
package lab.lab1_20150123.templates;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 	Yu-Hsin(Henry) Chen ({@code yu-hsin.chen@emory.edu})
 * @version	1.0
 * @since 	Jan 22, 2015
 */
public abstract class Storage<T>{
	private String ownerName;
	private List<T> content;
	
	public Storage(String o){	
		//To be filled
		/*
		 * 1. Assign o to ownerName
		 * 2. Initialize content as ArrayList
		 *  
		 */
	}
	
	abstract public T getMostValue();
	
	public String getOwnerName()	{ 	return ownerName; }
	public List<T> getContent()		{ 	return content; }
}