package org.hdwyl.tags.common.security;

// 蜂巢加密解密包装类
public class PwdEncryptor {

    // 系统默认，暂且不在系统上做加密参数
    private static final int KEY = 197107;
    private static final int CH1 = 197506;
    private static final int CH2 = 199912;

    /***
     * 明文和密文转换
     * @param vo 待加密或解密字符
     * @param tojm 是否加密
     * @param key keys[0];
     * @param ch1 keys[1];
     * @param ch2 keys[2];
     * @return 返回加密或解密后的信息；
     */
    private static String toTran(String vo, boolean tojm, int key, int ch1, int ch2) {
        return C0_04.s07(vo, tojm, key, ch1, ch2);
    }

    /**
     * 加密
     * @param vo
     * @return
     */
    public static String encrypt(String vo){
        return toTran(vo, true, KEY, CH1, CH2);
    }

    /**
     * 解密
     * @param vo
     * @return
     */
    public static String decrypt(String vo){
        return toTran(vo, false, KEY, CH1, CH2);
    }

    // 测试用
    public static void main(String args[]){

        String src = "";
        String des = PwdEncryptor.encrypt(src);
        System.out.println(des);
        System.out.println(PwdEncryptor.decrypt(des));

    }

}
