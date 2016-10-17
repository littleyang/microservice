package com.micro.service.oauth.controller.web.client;

import com.micro.service.oauth.model.dto.OauthClientDetailsDto;
import com.micro.service.oauth.service.client.OauthClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-15 8:52 AM
 */

@RestController
@RequestMapping("/open/patrner")
public class OAuthClientDetailController {

    @Autowired
    private OauthClientService oauthClientService;

    @RequestMapping(value = "/client/details", method = RequestMethod.GET)
    public String clientDetails(Model model) {
        List<OauthClientDetailsDto> clientDetailsDtoList = oauthClientService.loadAllOauthClientDetailsDtos();
        model.addAttribute("clientDetailsDtoList", clientDetailsDtoList);
        return "client/details";
    }


    /*
    * Logic delete
    * */
    @RequestMapping("/client/archive/{clientId}")
    public String archiveClient(@PathVariable("clientId") String clientId) {
        oauthClientService.archiveOauthClientDetails(clientId);
        return "redirect:../client/details";
    }

    /*
    * Test client
    * */
    @RequestMapping("/test/client/{clientId}")
    public String testClient(@PathVariable("clientId") String clientId, Model model) {
        OauthClientDetailsDto clientDetailsDto = oauthClientService.loadOauthClientDetailsDto(clientId);
        model.addAttribute("clientDetailsDto", clientDetailsDto);
        return "client/test";
    }


    /*
    * Register client
    * */
    @RequestMapping(value = "/client/register", method = RequestMethod.GET)
    public String registerClient(Model model) {
        model.addAttribute("formDto", new OauthClientDetailsDto());
        return "client/register";
    }


    /*
    * Submit register client
    * */
    @RequestMapping(value = "/client/register", method = RequestMethod.POST)
    public String submitRegisterClient(@ModelAttribute("formDto") OauthClientDetailsDto formDto, BindingResult result) {
        // 暂时不使用验证
        // clientDetailsDtoValidator.validate(formDto, result);
        if (result.hasErrors()) {
            return "client/register";
        }
        oauthClientService.registerClientDetails(formDto);
        return "redirect:/client/details";
    }

}
