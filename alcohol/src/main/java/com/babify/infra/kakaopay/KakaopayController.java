package com.babify.infra.kakaopay;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KakaopayController {

    private static final Logger logger = Logger.getLogger(KakaopayController.class.getName());

    private KakaopayService kakaoPay;

    @Autowired
    public void setKakaoPay(KakaopayService kakaoPay) {
        this.kakaoPay = kakaoPay;
    }

    @RequestMapping(value = "/kakaoPay", method = RequestMethod.GET)
    public void kakaoPayGet() {
        // GET 요청에 대한 처리가 필요하면 여기에 추가
    }

    @RequestMapping(value = "/kakaoPay", method = RequestMethod.POST)
    public String kakaoPay() {
        logger.info("kakaoPay post.....................");
        return "redirect:" + kakaoPay.kakaoPayReady();
    }

    @RequestMapping(value = "/kakaoPaySuccess", method = RequestMethod.GET)
    public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
        logger.info("kakaoPay Success get................");
        logger.info("kakaoPaySuccess pg_token : " + pg_token);
    }
}
