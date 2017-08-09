
/*
 * Copyright (c) 2017, FSTOP, Inc. All Rights Reserved.
 *
 * You may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tw.com.fstop.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class NumericUtilTest
{
    @Before    
    public void setup() 
    {
    }
    
    @After
    public void tearDown() 
    {
    }

    @Test
    public void testNumericUtil()
    {
        double d1;
        double d2;
        String fmt;
        String strVal;
        boolean isOK;
        
        strVal = "123.45";
        isOK = NumericUtil.isNumeric(strVal);
        assertTrue(isOK);

        strVal = "12345";
        isOK = NumericUtil.isNumeric(strVal);
        assertTrue(isOK);
        
        strVal = "a123.45";
        isOK = NumericUtil.isNumeric(strVal);
        assertFalse(isOK);
                
        
        d1 = 2.534;
        d2 = 1.533;
        d2 = NumericUtil.add(d1, d2);
        assertThat(d2).isEqualTo(4.067);
        
        d1 = 2.534;
        d2 = 1.533;
        d2 = NumericUtil.sub(d1, d2);
        assertThat(d2).isEqualTo(1.001);
        
        d1 = 2.5;
        d2 = 4;
        d2 = NumericUtil.mul(d1, d2);
        assertThat(d2).isEqualTo(10);
        
        
        fmt = "#0.00######";
        d1 = 1234567d;       
        strVal = NumericUtil.formatDouble(d1, fmt);
        assertThat(strVal).isEqualTo("1234567.00");
        System.out.println(strVal);

        fmt = "#,##0.00";
        d1 = 1234567d;       
        strVal = NumericUtil.formatDouble(d1, fmt);
        assertThat(strVal).isEqualTo("1,234,567.00");
        System.out.println(strVal);
        
        d1 = 12345.54d;
        strVal = NumericUtil.toHalfUpString(d1, 1);
        assertThat(strVal).isEqualTo("12345.5");
        System.out.println(strVal);
        
        d1 = 12345.55d;
        strVal = NumericUtil.toHalfUpString(d1, 1);
        assertThat(strVal).isEqualTo("12345.6");
        System.out.println(strVal);

        d1 = 12345.55d;
        strVal = NumericUtil.toRoundDownString(d1, 1);
        assertThat(strVal).isEqualTo("12345.5");
        System.out.println(strVal);

        d1 = 12345.54d;
        strVal = NumericUtil.toRoundUpString(d1, 1);
        assertThat(strVal).isEqualTo("12345.6");
        System.out.println(strVal);
        
        
    }
    
    
}
