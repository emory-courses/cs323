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
package lab.lab2_20150911.structure.machine;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

import lab.lab2_20150911.structure.LambdaObject;

/**
 * @author 	Yu-Hsin(Henry) Chen ({@code yu-hsin.chen@emory.edu})
 * @version	1.0
 * @since 	Sep 11, 2015
 */
public class LambdaObjectMerger extends AbstractLambdaMachine<LambdaObject, LambdaObject, String>{

	protected BiPredicate<LambdaObject, LambdaObject> getBiPredicate() {
		BiPredicate<LambdaObject, LambdaObject> predicate = new BiPredicate<LambdaObject, LambdaObject>() {
			@Override
			public boolean test(LambdaObject t, LambdaObject u) {
				return t.getType() == u.getType() && t.getNumber() < u.getNumber();
			}
		};
		return predicate;
	}

	protected BiFunction<LambdaObject, LambdaObject, String> getBiFunction() {
		BiFunction<LambdaObject, LambdaObject, String> function = new BiFunction<LambdaObject, LambdaObject, String>() {
			@Override
			public String apply(LambdaObject t, LambdaObject u) {
				return t.getValue() + u.getValue();
			}
		};
		return function;
	}

}
