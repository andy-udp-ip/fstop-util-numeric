
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

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 提供精確的數值運算與轉換
 *
 * @since 1.0
 */
public class NumericUtil
{
    //Default divide result scale
    static final int DEF_DIV_SCALE = 10;
    
    /**
     * Check if input string is numeric string.
     * 
     * @param numeric input string
     * @return true/false
     */
    public static boolean isNumeric(String numeric)
    {
        try
        {
            Double.parseDouble(numeric);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
    /**
     * 提供精確的加法運算。
     * 
     * @param v1
     *            被加數
     * @param v2
     *            加數
     * @return 兩個參數的和
     */
    public static double add(double v1, double v2)
    {
        //此處 Double.toString(value) 很重要，若直接以 BigDecimal 轉 double 會發生進位問題
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精確的減法運算。
     * 
     * @param v1
     *            被減數
     * @param v2
     *            減數
     * @return 兩個參數的差
     */
    public static double sub(double v1, double v2)
    {
        //此處 Double.toString(value) 很重要，若直接以 BigDecimal 轉 double 會發生進位問題
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精確的乘法運算。
     * 
     * @param v1
     *            被乘數
     * @param v2
     *            乘數
     * @return 兩個參數的積
     */
    public static double mul(double v1, double v2)
    {
        //此處 Double.toString(value) 很重要，若直接以 BigDecimal 轉 double 會發生進位問題
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }
    
    /**
     * 提供（相對）精確的除法運算。當發生除不盡的情況時，由scale參數指定精度
     * 
     * @param dividend      被除數
     * @param divisor       除數
     * @param scale         表示表示需要精確到小數點以後幾位, 大於等於 0
     * @param op            進位方式
     * @return              兩個參數的商
     */
    public static double div(double dividend, double divisor, int scale, int op)
    {
        //此處 Double.toString(value) 很重要，若直接以 BigDecimal 轉 double 會發生進位問題
        BigDecimal b1 = new BigDecimal(Double.toString(dividend));
        BigDecimal b2 = new BigDecimal(Double.toString(divisor));
        return b1.divide(b2, scale, op).doubleValue();        
    }
    
    /**
     * 提供（相對）精確的除法運算。當發生除不盡的情況時，由scale參數指定精度，以後的數字四捨五入。
     * 
     * @param dividend
     *            被除數
     * @param divisor
     *            除數
     * @param scale
     *            表示表示需要精確到小數點以後幾位, 大於等於 0
     * @return 兩個參數的商
     */
    public static double divHalfUp(double dividend, double divisor, int scale)
    {
        return div(dividend, divisor, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供（相對）精確的除法運算。當發生除不盡的情況時，由scale參數指定精度，以後的數字無條件捨去。
     * @param dividend          被除數
     * @param divisor           除數
     * @param scale             表示表示需要精確到小數點以後幾位, 大於等於 0
     * @return                  兩個參數的商
     */
    public static double divRoundDown(double dividend, double divisor, int scale)
    {
        return div(dividend, divisor, scale, BigDecimal.ROUND_DOWN);
    }

    /**
     * 提供（相對）精確的除法運算。當發生除不盡的情況時，由scale參數指定精度，以後的數字無條件進位。
     * @param dividend          被除數
     * @param divisor           除數
     * @param scale             表示表示需要精確到小數點以後幾位, 大於等於 0
     * @return                  兩個參數的商
     */
    public static double divRoundUp(double dividend, double divisor, int scale)
    {
        return div(dividend, divisor, scale, BigDecimal.ROUND_UP);
    }
    
    /**
     * 提供（相對）精確的除法運算。以後的數字四捨五入
     * @param dividend          被除數
     * @param divisor           除數
     * @return                  兩個參數的商
     */
    public static double div(double dividend, double divisor)
    {
        return divHalfUp(dividend, divisor, DEF_DIV_SCALE);
    }
    
    /**
     * 提供精確的小數位四捨五入處理。
     * @param value 需要四捨五入的數值
     * @param scale 小數點後保留幾位, 大於等於 0
     * @return 四捨五入後的結果
     */
    public static double roundHalfUp(double value, int scale)
    {
        return divHalfUp(value, 1, scale);
    }

    /**
     * 提供精確的小數位無條件捨去處理
     * @param value     要處理的數值
     * @param scale     小數點後保留幾位, 大於等於 0
     * @return          結果值
     */
    public static double roundDown(double value, int scale)
    {
        return divRoundDown(value, 1, scale);
    }

    /**
     * 提供精確的小數位無條件進位處理
     * @param value     要處理的數值
     * @param scale     小數點後保留幾位, 大於等於 0
     * @return          結果值
     */
    public static double roundUp(double value, int scale)
    {
        return divRoundUp(value, 1, scale);
    }
    
    /**
     * 數值四捨五入後轉換為字串
     * 
     * @param value         要處理的數值
     * @param scale         小數點後保留幾位, 大於等於 0
     * @return              結果值
     */
    public static String toHalfUpString(double value, int scale)
    {
        return String.valueOf(roundHalfUp(value, scale));
    }

    /**
     * 數值無條件捨去後轉換為字串
     * @param value         要處理的數值
     * @param scale         小數點後保留幾位, 大於等於 0
     * @return              結果值
     */
    public static String toRoundDownString(double value, int scale)
    {
        return String.valueOf(roundDown(value, scale));
    }

    /**
     * 數值無條件進位後轉換為字串
     * @param value         要處理的數值
     * @param scale         小數點後保留幾位, 大於等於 0
     * @return              結果值
     */
    public static String toRoundUpString(double value, int scale)
    {
        return String.valueOf(roundUp(value, scale));
    }
    
    /**
     * 格式化數字為字串
     * @param value         要處理的數值
     * @param format        格式
     * @return              結果值
     */
    public static String formatDouble(double value, String format)
    {
        format.trim();
        DecimalFormat fmt = new DecimalFormat(format);
        String strValue = fmt.format(value);
        return strValue;
    }

    

    
    
}
