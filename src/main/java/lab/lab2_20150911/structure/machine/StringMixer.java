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

/**
 * @author 	Yu-Hsin(Henry) Chen ({@code yu-hsin.chen@emory.edu})
 * @version	1.0
 * @since 	Sep 18, 2015
 */
public class StringMixer extends AbstractLambdaMachine<String, String, String>{

	@Override
	protected BiPredicate<String, String> getBiPredicate() {
		return new BiPredicate<String, String>() {
			@Override
			public boolean test(String t, String u) {
				return t.length() == u.length();
			}
		};
	}

	@Override
	protected BiFunction<String, String, String> getBiFunction() {
		return new BiFunction<String, String, String>(){
			@Override
			public String apply(String t, String u) {
				int i, size = t.length();
				StringBuilder sb = new StringBuilder();
				
				for(i = 0; i < size; i++){
					sb.append(t.charAt(i));
					sb.append(u.charAt(i));
				}
				
				return sb.toString();
			}
			
		};
	}

}
