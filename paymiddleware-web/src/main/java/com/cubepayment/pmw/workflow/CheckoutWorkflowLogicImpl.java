package com.cubepayment.pmw.workflow;

import com.cubepayment.pmw.channel.CheckoutChannel;
import com.cubepayment.pmw.data.entity.MerchantConfigurationEntity;
import com.cubepayment.pmw.dto.CheckoutRequestTransactionDto;
import com.cubepayment.pmw.service.CheckoutService;
import com.cubepayment.pmw.service.ECommerceTransactionService;
import com.cubepayment.pmw.service.MerchantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(value = "transactionManager")
public class CheckoutWorkflowLogicImpl implements CheckoutWorkflow {

    @Resource
    private ECommerceTransactionService eCommerceTransactionService;

    @Resource
    private MerchantService merchantService;

    @Resource
    private CheckoutService checkoutService;

    @Resource
    private CheckoutChannel checkoutChannel;

    @Override
    public String doCheckoutLogic(CheckoutRequestTransactionDto checkoutRequestTransactionDto) {

        //Log checkout request coming
        eCommerceTransactionService.saveCreateECommerceTransaction(checkoutRequestTransactionDto);

        //get merchant config
        MerchantConfigurationEntity merchantConfigurationEntity = merchantService.getMerchantConfigEntity(checkoutRequestTransactionDto.getMerchantId());

        //Get token from checkout channel(cybersource for now)
        String token = checkoutChannel.getToken(merchantConfigurationEntity.getCybersourceMerchantId(),merchantConfigurationEntity.getCybersourcePassword());

        //build checkout url based on token
        String checkoutUrl = checkoutService.buildCheckoutUrl(checkoutRequestTransactionDto,token);

        return checkoutUrl;
    }
}
