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

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

/**
 * @author 	Yu-Hsin(Henry) Chen ({@code yu-hsin.chen@emory.edu})
 * @version	1.0
 * @since 	Sep 11, 2015
 */
public abstract class AbstractLambdaMachine<T1, T2, T3> {
	protected BiPredicate<T1, T2> check;
	protected BiFunction<T1, T2, T3> operation;
	
	public AbstractLambdaMachine(){
		check = getBiPredicate();
		operation = getBiFunction();
	}
	
	abstract protected BiPredicate<T1, T2> getBiPredicate();
	abstract protected BiFunction<T1, T2, T3> getBiFunction();
	
	public T3 run(T1 t1, T2 t2){
		if(check.test(t1, t2))
			return operation.apply(t1, t2);
		return null;
	}
}
