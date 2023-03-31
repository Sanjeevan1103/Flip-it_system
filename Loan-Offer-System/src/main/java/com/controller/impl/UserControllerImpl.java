package com.controller.impl;

import com.business.UserBusiness;
import com.controller.UserController;
import com.dto.request.UserLoginReq;
import com.dto.response.CommonResponse;
import com.dto.response.GeneralResponse;
import com.dto.response.LoanOfferResponse;
import com.dto.user.request.CreateNewUserReq;
import com.dto.user.request.GetCustomerDetailReq;
import com.dto.user.response.CustomerRes;
import com.util.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserControllerImpl implements UserController {

    @Autowired
    UserBusiness userBusiness;

    @Override
    @PostMapping("/create/new/user")
    public LoanOfferResponse createNewUser(@RequestBody CreateNewUserReq createNewUserReq) {
        GeneralResponse response = userBusiness.createNewUser(createNewUserReq);
        return LoanOfferResponse.generateResponse(null,response.getStatusCode(),response.getMsg());
    }

    @Override
    @PostMapping("/get/customer/detail")
    public LoanOfferResponse getCustomerDetail(@RequestBody GetCustomerDetailReq getCustomerDetailReq) {
        CustomerRes customerDetail = userBusiness.getCustomerDetail(getCustomerDetailReq);
        return LoanOfferResponse.generateResponse(
                customerDetail,
                ApplicationConstant.SuccessStatusCode,
                ApplicationConstant.SuccessMsg);
    }

    @Override
    @PostMapping("/get/customer/list")
    public LoanOfferResponse getCustomerList() {
        List<CustomerRes> customerResList = userBusiness.getCustomerList();
        return LoanOfferResponse.generateResponse(
                customerResList,
                ApplicationConstant.SuccessStatusCode,
                ApplicationConstant.SuccessMsg);
    }

    @Override
    @PostMapping("/user/login")
    public LoanOfferResponse login(@RequestBody UserLoginReq loginReq) {
        CommonResponse commonResponse = userBusiness.login(loginReq);
        return LoanOfferResponse.generateResponse(
                commonResponse.getValue(),
                commonResponse.getStatusCode(),
                commonResponse.getMsg());
    }
}
