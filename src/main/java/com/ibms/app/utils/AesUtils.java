package com.ibms.app.utils;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * AES工具类
 * @author cc
 */
public class AesUtils {

    /**
     * AES加密
     * @param cipher    密钥
     * @param content   明文
     * @return          密文
     */
    public static String encrypt(String cipher, String content){
        return SecureUtil.aes(cipher.getBytes()).encryptHex(content);
    }

    /**
     * AES解密
     * @param cipher    密钥
     * @param encrypt   密文
     * @return          明文
     */
    public static String decrypt(String cipher, String encrypt){
        return SecureUtil.aes(cipher.getBytes()).decryptStr(encrypt, CharsetUtil.CHARSET_UTF_8);
    }

    public static void main(String[] args) throws Exception {
//                String s = HttpClientUtil.postJsonData("http://114.67.88.84:8068/deviceStoreMedicine/getDeviceStoreMedicines", "{\"deviceSn\":\"20400047\"}");
//        System.out.println(s);

        // 请求Url
//        String url="http://114.67.88.84:8068/deviceStoreMedicine/getDeviceStoreMedicines";
//        // 商户号
//        String merchantNo = "3621592362034398";
//        // 商户号对应密钥
//        String cipher = "91e8d9e2177ec95023af8223ef14cbbf";
//
//        // Header处理
//        HttpHeaders header = new HttpHeaders();
//        // 需求需要传参为form-data格式
//        header.setContentType(MediaType.MULTIPART_FORM_DATA);
//        // 商户号
//        header.set("merchantNo", merchantNo);
//        // 签名
//        header.set("sign", SecureUtil.md5(merchantNo + cipher));
//
//        // Body入参处理
//        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("deviceSn", "20400047");
//        map.add("data", AesUtils.encrypt(cipher, JSON.toJSONString(jsonObject)));
//        // 创建Post请求实体对象
//        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, header);
//        // 发送Post请求
//        String result = new RestTemplate().postForObject(url, httpEntity, String.class);
//        // 打印返回结果
//        Console.log(result);
    }
}
