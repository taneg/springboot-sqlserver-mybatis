package com.ibms.app.web.task;

import cn.hutool.core.lang.Console;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.ibms.app.config.RequestContant;
import com.ibms.app.utils.AesUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@EnableConfigurationProperties(RequestContant.class)
public class InvokeRemoteHandler {
	@Autowired
	private RequestContant requestContant;
	@Scheduled(fixedRate = 5000)
	public void storeMedicine() throws Exception {
		// 请求Url
		String url="http://114.67.88.84:8068/deviceStoreMedicine/getDeviceStoreMedicines";
		// 商户号
		String merchantNo = "3621592362034398";
		// 商户号对应密钥
		String cipher = "91e8d9e2177ec95023af8223ef14cbbf";

		// Header处理
		HttpHeaders header = new HttpHeaders();
		// 需求需要传参为form-data格式
		header.setContentType(MediaType.MULTIPART_FORM_DATA);
		// 商户号
		header.set("merchantNo", merchantNo);
		// 签名
		header.set("sign", SecureUtil.md5(merchantNo + cipher));

		// Body入参处理
		MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("deviceSn", "20400047");
		map.add("data", AesUtils.encrypt(cipher, JSON.toJSONString(jsonObject)));
		// 创建Post请求实体对象
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, header);
		// 发送Post请求
		String result = new RestTemplate().postForObject(requestContant.getStoreMedicine(), httpEntity, String.class);
		// 打印返回结果
		Console.log(result);
	}

//	private HttpEntity<MultiValueMap<String, String>> buildParam(){
//
//	}
}
