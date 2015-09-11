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
package lab.lab2_20150911.structure;

/**
 * @author 	Yu-Hsin(Henry) Chen ({@code yu-hsin.chen@emory.edu})
 * @version	1.0
 * @since 	Sep 11, 2015
 */
public class LambdaObject {
	private LambdaEum type;
	private int number;
	private String value;
	
	public LambdaObject(LambdaEum t, int n, String v){
		init(t, n, v);
	}
	
	public LambdaObject(String t, int n, String v){
		init(LambdaEum.valueOf(t), n, v);
	}
	
	private void init(LambdaEum t, int n, String v){
		type = t; number = n; value = v;
	}
	
	public LambdaEum getType(){
		return type;
	}
	
	public int getNumber(){
		return number;
	}
	
	public String getValue(){
		return value;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder(type.toString());
		sb.append(" ["); sb.append(number); sb.append(','); sb.append(value); sb.append(']');
		return sb.toString();
	}
}
