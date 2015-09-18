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
package lab.lab_20150917;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 	Yu-Hsin(Henry) Chen ({@code yu-hsin.chen@emory.edu})
 * @version	1.0
 * @since 	Sep 17, 2015
 */
public class InterfacePractice<T> implements Iterable<T>, Comparable<InterfacePractice<T>>, Serializable{
	
	public static final String filePath = "/Users/HenryChen/Desktop/obj.out";
	public static void main(String[] args){
		InterfacePractice<String> test1 = new InterfacePractice<>("PracticeInterface1");
		test1.addContent("A"); test1.addContent("B"); test1.addContent("C");
		test1.addContent("D"); test1.addContent("E"); test1.addContent("F");
		
		InterfacePractice<String> test2 = new InterfacePractice<>("PracticeInterface2");
		test2.addContent("G"); test2.addContent("H"); test2.addContent("I");
		
		if(test1.compareTo(test2) > 0) test1.export(filePath);
		InterfacePractice<String> readObj = InterfacePractice.read(filePath);
		for(String content : readObj) System.out.println(content);
	}
	
	private static final long serialVersionUID = -6520125033774880748L;
	private String interfaceName;
	private List<T> interfaceContent;
	
	public InterfacePractice(String name) {
		interfaceName = name;
		interfaceContent = new ArrayList<>();
	}
	
	public String getName(){
		return interfaceName;
	}
	
	public void addContent(T content){
		interfaceContent.add(content);
	}
	
	@SuppressWarnings("unchecked")
	public static <T>InterfacePractice<T> read(String filePath){
		InterfacePractice<T> object = null;
		try {
			ObjectInput in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)));
			try{ 
				object = (InterfacePractice<T>)in.readObject(); 
			} 
			finally { in.close(); }
		} catch (Exception e) { e.printStackTrace(); }
		
		return object;
	}
	
	public void export(String filePath){
		try {
			ObjectOutput out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)));
			try{
				out.writeObject(this); 
			} finally { out.close(); }
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	@Override
	public int compareTo(InterfacePractice<T> o) {
		return this.interfaceContent.size() - o.interfaceContent.size();
	}
	@Override
	public Iterator<T> iterator() {
		// Iterate reversely
		Iterator<T> it = new Iterator<T>() {
			int i = interfaceContent.size()-1;
			@Override
			public T next() {			return interfaceContent.get(i--); }
			@Override
			public boolean hasNext() {	return i >= 0; }
		};
		return it;
	}
}
