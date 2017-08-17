package com.msl.tools;

/**
 * 位运算工具类
 *
 * @author libin<br>
 *         2016年2月23日 下午9:00:27
 */

public class RadixUtil {

    /**
     * 将二进制数组按16进制输出为字符串
     * 
     * @param byteArray 二进制数组
     * @param useSpace 每一字节之间是否空格
     * @return
     */
    public static String byteArrayToHexString(byte[] byteArray, boolean useSpace) {
        StringBuffer sb = new StringBuffer();
        for (byte b : byteArray) {
            sb.append(String.format("%x", b));
            if (useSpace) {
                sb.append(" ");
            }
        }
        if (sb.length() > 0) {
            return useSpace ? sb.delete(sb.lastIndexOf(" "), sb.length()).toString() : sb.toString();
        }
        return sb.toString();
    }

    /**
     * 将int值转换为默认4字节byte数组
     * 
     * @param intValue
     * @return
     */
    public static byte[] intToByteArray(int intValue) {
        return intToByteArray(intValue, 4);
    }

    /**
     * 将int值转换为byte数组，注意：byte数组长度不能大于4个字节，否则数据将会不准确
     * 
     * @param intValue
     * @param length
     * @return
     */
    public static byte[] intToByteArray(int intValue, int length) {
        if (length > 4) {
            length = 4;
        }
        byte[] array = new byte[length];
        for (int i = 0; i < length; i++) {
            array[i] = (byte) (intValue >> i * 8 & 0xff);
        }
        return array;
    }

    /**
     * 将long值转换为默认8字节byte数组
     * 
     * @param longValue
     * @return
     */
    public static byte[] longToByteArray(long longValue) {
        return longToByteArray(longValue, 8);
    }

    /**
     * 将long值转换为byte数组，注意：byte数组长度不能大于8个字节，否则数据将会不准确
     * 
     * @param longValue
     * @param length
     * @return
     */
    public static byte[] longToByteArray(long longValue, int length) {
        if (length > 8) {
            length = 8;
        }
        byte[] array = new byte[length];
        for (int i = 0; i < length; i++) {
            array[i] = (byte) (longValue >> i * 8 & 0xff);
        }
        return array;
    }

    /**
     * 将数组转换为int值
     * 
     * @param byteArray
     * @return
     */
    public static int byteArrayToInt(byte[] byteArray) {
        int intValue = 0;
        int length = byteArray.length > 4 ? 4 : byteArray.length;
        for (int i = 0; i < length; i++) {
            intValue += (int)(byteArray[i] & 0xff) << (i * 8);
        }
        return intValue;
    }

    /**
     * 将数组转换为long值
     * 
     * @param byteArray
     * @return
     */
    public static long byteArrayToLong(byte[] byteArray) {
        long longValue = 0;
        int length = byteArray.length > 8 ? 8 : byteArray.length;
        for (int i = 0; i < length; i++) {
            longValue += (long)(byteArray[i] & 0xff) << (i * 8);
        }
        return longValue;
    }
    
    public static void main(String[] args) {
		System.out.println("AAAAAAA");
	}
}