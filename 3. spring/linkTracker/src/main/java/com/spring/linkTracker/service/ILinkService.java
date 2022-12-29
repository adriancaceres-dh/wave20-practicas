package com.spring.linkTracker.service;

import com.spring.linkTracker.dto.request.RequestLinkDTO;
import com.spring.linkTracker.dto.response.ResponseLinkDTO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

public interface ILinkService {
    ResponseLinkDTO createLink(RequestLinkDTO requestLinkDTO);

    List<ResponseLinkDTO> getAllLinks();

    RedirectView redirect(int linkId);
    RedirectView redirect(int linkId, String password);

    ResponseLinkDTO getMetricsLink(int linkId);

    ResponseLinkDTO invalidateLink(int linkId);

}
