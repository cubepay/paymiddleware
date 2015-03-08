package com.cubepayment.pmw.service;

import com.cubepayment.pmw.constant.ApplicationPropsKey;
import com.cubepayment.pmw.dto.CheckoutRequestTransactionDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Properties;

@Service
@Transactional(value = "transactionManager")
public class CheckoutServiceImpl implements CheckoutService{

    @Resource(name = "applicationProps")
    private Properties applicationProps;

    @Override
    public String buildCheckoutUrl(CheckoutRequestTransactionDto eCommerceTransactionDto,String token) {
        StringBuilder sbCheckoutUrl = new StringBuilder();
        sbCheckoutUrl.append(applicationProps.getProperty(ApplicationPropsKey.CHECKOUT_URL.getKey()));
        sbCheckoutUrl.append("?");
        sbCheckoutUrl.append(token);
        return sbCheckoutUrl.toString();
    }
}
