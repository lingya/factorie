/* Copyright (C) 2008-2016 University of Massachusetts Amherst.
   This file is part of "FACTORIE" (Factor graphs, Imperative, Extensible)
   http://factorie.cs.umass.edu, http://github.com/factorie
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License. */
package cc.factorie.directed

import cc.factorie.util.FastLogging
import cc.factorie.variable.DoubleVariable
import org.junit.Assert._
import org.junit.Test
import org.scalatest.junit.JUnitSuite

class TestBeta extends JUnitSuite with FastLogging {

  @Test
  def testBta(): Unit = {
    val alpha = new DoubleVariable(1.0)
    val beta = new DoubleVariable(3.0)
    val value = new DoubleVariable(0.5)

    // mean = alpha / (alpha + beta)
    assertEquals(0.25, Beta.mean(alpha.doubleValue, beta.doubleValue), 0.01)

    val f = Beta.newFactor(value, alpha, beta)
    assert(f.pr(value.doubleValue, alpha.doubleValue, beta.doubleValue) == Beta.pr(value.doubleValue, alpha.doubleValue, beta.doubleValue))
  }

}
