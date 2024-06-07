package com.babify.infra.kakaopay;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

@Service
@Transactional
public class KakaopayService {

    private static final String Host = "https://kapi.kakao.com";
    private static final Logger logger = Logger.getLogger(KakaopayService.class.getName());

    @Value("${kakaopay_admin_key}")
    private String kakaopayAdminKey;

    private KakaopayDto kakaoPayDTO;

    public String kakaoPayReady() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        // Server Request Header : 서버 요청 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + kakaopayAdminKey); // 어드민 키
        headers.add("Accept", "application/json");
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // Server Request Body : 서버 요청 본문
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("cid", "TC0ONETIME"); // 가맹점 코드 - 테스트용
        params.add("partner_order_id", "1001"); // 주문 번호
        params.add("partner_user_id", "goguma"); // 회원 아이디
        params.add("item_name", "비둘기"); // 상품 명
        params.add("quantity", "1"); // 상품 수량
        params.add("total_amount", "20000"); // 상품 가격
        params.add("tax_free_amount", "100"); // 상품 비과세 금액
        params.add("approval_url", "http://localhost:8081/myAccount"); // 성공시 url
        params.add("cancel_url", "http://localhost:8081/kakaoPayCancel"); // 실패시 url
        params.add("fail_url", "http://localhost:8081/kakaoPayFail");

        // 헤더와 바디 붙이기
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<>(params, headers);

        try {
            kakaoPayDTO = restTemplate.postForObject(new URI(Host + "/v1/payment/ready"), body, KakaopayDto.class);
            logger.info("" + kakaoPayDTO);
            return kakaoPayDTO.getNext_redirect_pc_url();
        } catch (RestClientException | URISyntaxException e) {
            e.printStackTrace();
        }
        return "/pay";
    }
}
