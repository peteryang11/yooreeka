/*
 *   ________________________________________________________________________________________
 *   
 *   Y O O R E E K A
 *   A library for data mining, machine learning, soft computing, and mathematical analysis
 *   ________________________________________________________________________________________ 
 *    
 *   The Yooreeka project started with the code of the book "Algorithms of the Intelligent Web " 
 *   (Manning 2009). Although the term "Web" prevailed in the title, in essence, the algorithms 
 *   are valuable in any software application.
 *  
 *   Copyright (c) 2007-2009 Haralambos Marmanis & Dmitry Babenko
 *   Copyright (c) 2009-${year} Marmanis Group LLC and individual contributors as indicated by the @author tags.  
 * 
 *   Certain library functions depend on other Open Source software libraries, which are covered 
 *   by different license agreements. See the NOTICE file distributed with this work for additional 
 *   information regarding copyright ownership and licensing.
 * 
 *   Marmanis Group LLC licenses this file to You under the Apache License, Version 2.0 (the "License"); 
 *   you may not use this file except in compliance with the License.  
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under 
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 *   either express or implied. See the License for the specific language governing permissions and
 *   limitations under the License.
 *   
 */
package org.yooreeka.test;

import org.yooreeka.math.Fibonacci;
import org.yooreeka.util.P;
import org.yooreeka.util.gui.XyGui;



/**
 * 
 * @author <a href="mailto:babis@marmanis.com">Babis Marmanis</a>
 *
 */
public class TestSandbox {

	/**
	 * Throw your code in the main method for quick tests.
	 * This is useful when you are testing Beanshell scripts.
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		int seriesSize = 51;
		double[] x = new double[seriesSize], y = new double[seriesSize];
		
		StringBuilder msg = new StringBuilder();
		msg.append("Fib [").append(seriesSize-1).append("] = ");

		Fibonacci[] fibonacci = new Fibonacci[seriesSize-2];
		
		for (int i=0; i<seriesSize; i++) {
			for (int j=2; j<seriesSize; j++) {
				fibonacci[j-2] = new Fibonacci(j,seriesSize);
				
				if (i == seriesSize-1) {
					x[j-2] = (double) j;
					y[j-2] = (double) fibonacci[j-2].get(i);
					
					if (j<seriesSize-1)
						msg.append(fibonacci[j-2].get(i)).append(", ");
					else
						msg.append(fibonacci[j-2].get(i));
				}
			}
		}
		P.println(msg.toString());
		P.hline();
		P.println(x, y);
		
		XyGui g = new org.yooreeka.util.gui.XyGui ("A plot",x,y);
		g.plot();

	}
}
