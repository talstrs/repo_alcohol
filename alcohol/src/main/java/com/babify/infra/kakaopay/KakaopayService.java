package com.babify.infra.kakaopay;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.babify.infra.orders.OrdersDto;
import com.babify.infra.orders.OrdersService;
import com.babify.infra.productorders.ProductOrdersDto;
import com.babify.infra.productorders.ProductOrdersService;

@Service
@Transactional
public class KakaopayService {

    private static final String HOST = "https://kapi.kakao.com";
    private static final Logger logger = Logger.getLogger(KakaopayService.class.getName());

    @Value("${kakaopay_admin_key}")
    private String kakaopayAdminKey;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductOrdersService productOrdersService;

    private KakaopayDto kakaoPayDTO;

    public String kakaoPayReady(OrdersDto dto, ProductOrdersDto podto) {
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + kakaopayAdminKey);
        headers.add("Accept", "application/json");
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_user_id", kakaoPayDTO.getMembersEmail());
        params.add("item_name", kakaoPayDTO.getProductName());
        params.add("quantity", kakaoPayDTO.getProductOrdersCount());
        params.add("total_amount", kakaoPayDTO.getOrdersTotalPrice());
        params.add("approval_url", "http://localhost:8081/myAccount");
        params.add("cancel_url", "http://localhost:8081/myAccount");
        params.add("fail_url", "http://localhost:8081/myAccount");

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<>(params, headers);

        try {
            kakaoPayDTO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaopayDto.class);
            logger.info("" + kakaoPayDTO);
            ordersService.insert(dto);
            podto.setOrdersSeq(dto.getSeq());
            productOrdersService.insert(podto);
            return kakaoPayDTO.getNext_redirect_pc_url();
        } catch (RestClientException | URISyntaxException e) {
            e.printStackTrace();
        }
        return "/pay";
    }
}
