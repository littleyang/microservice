package com.micro.service.auth.controller;

import com.micro.service.auth.model.dto.OauthClientDetailsDto;
import com.micro.service.auth.service.OauthService;
import com.micro.service.auth.web.validator.OauthClientDetailsDtoValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-13 5:04 PM
 */

@Controller
public class ClientDetailsController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private OauthService oauthService;

    @Autowired
    private OauthClientDetailsDtoValidator clientDetailsDtoValidator;


    @RequestMapping("/client_details")
    public String clientDetails(Model model) {
        List<OauthClientDetailsDto> clientDetailsDtoList = oauthService.loadAllOauthClientDetailsDtos();
        model.addAttribute("clientDetailsDtoList", clientDetailsDtoList);
        return "clientdetails/client_details";
        //return "index";
    }


    /*
    * Logic delete
    * */
    @RequestMapping("/archive_client/{clientId}")
    public String archiveClient(@PathVariable("clientId") String clientId) {
        oauthService.archiveOauthClientDetails(clientId);
        return "redirect:../client_details";
    }

    /*
    * Test client
    * */
    @RequestMapping("/test_client/{clientId}")
    public String testClient(@PathVariable("clientId") String clientId, Model model) {
        OauthClientDetailsDto clientDetailsDto = oauthService.loadOauthClientDetailsDto(clientId);
        model.addAttribute("clientDetailsDto", clientDetailsDto);
        return "clientdetails/test_client";
    }


    /*
    * Register client
    * */
    @RequestMapping(value = "register_client", method = RequestMethod.GET)
    public String registerClient(Model model) {
        model.addAttribute("formDto", new OauthClientDetailsDto());
        return "clientdetails/register_client";
    }


    /*
    * Submit register client
    * */
    @RequestMapping(value = "register_client", method = RequestMethod.POST)
    public String submitRegisterClient(@ModelAttribute("formDto") OauthClientDetailsDto formDto, BindingResult result) {
        clientDetailsDtoValidator.validate(formDto, result);
        if (result.hasErrors()) {
            return "clientdetails/register_client";
        }
        oauthService.registerClientDetails(formDto);
        return "redirect:client_details";
    }



}
