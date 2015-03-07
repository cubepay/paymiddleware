package com.cubepayment.pmw.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class CheckoutController {

    private final Logger loggerFactory = LoggerFactory.getLogger(CheckoutController.class);

    @RequestMapping(value = "doCheckout", method = RequestMethod.GET)
    public RedirectView doCheckout(@RequestParam String url, HttpServletRequest request, HttpServletResponse response) {

        loggerFactory.info("URL:"+url);
        RedirectView redirectView = new RedirectView();

        redirectView.setUrl("http://www.google.com?test="+url);
        return redirectView;
    }

}
