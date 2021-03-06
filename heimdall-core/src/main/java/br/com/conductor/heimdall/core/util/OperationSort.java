
package br.com.conductor.heimdall.core.util;

/*-
 * =========================LICENSE_START==================================
 * heimdall-core
 * ========================================================================
 * Copyright (C) 2018 Conductor Tecnologia SA
 * ========================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ==========================LICENSE_END===================================
 */

import java.util.Comparator;

import br.com.conductor.heimdall.core.entity.Operation;

/**
 * This class provides a comparator for the {@link Operation} resource.
 * 
 * @author Marcos Filho
 * @author Marcelo Rodrigues
 *
 */
public class OperationSort implements Comparator<Operation> {

	@Override
    public int compare(Operation r1, Operation r2) {
         String pattern1 = r1.getPath();
         String pattern2 = r2.getPath();
         
         String[] split = pattern1.split("/");
         String[] split2 = pattern2.split("/");
         
         for (String firstSplit : split) {
              for (String secondSplit : split2) {
                   if (firstSplit.equals("**") && secondSplit.equals("**")) return 0;
                   if (firstSplit.equals("**") && !secondSplit.equals("**")) return -1;
                   if (!firstSplit.equals("**") && secondSplit.equals("**")) return 1;
                   return pattern1.compareTo(pattern2);
              }
              
         }

         return pattern1.compareTo(pattern2);
    }

}
