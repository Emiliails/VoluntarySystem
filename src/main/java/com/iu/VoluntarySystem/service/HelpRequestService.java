package com.iu.VoluntarySystem.service;

import com.iu.VoluntarySystem.dao.HelpRequestDao;
import com.iu.VoluntarySystem.entity.HelpRequest;

import java.util.List;

public class HelpRequestService {
    public void addHelpRequest(HelpRequest helpRequest) {
        HelpRequestDao helpRequestDao = new HelpRequestDao();
        helpRequestDao.addHelpRequest(helpRequest);
    }

    public List<HelpRequest> findByHelpSeekerId(int helpSeekerId) {
        HelpRequestDao helpRequestDao = new HelpRequestDao();
        return helpRequestDao.findByHelpSeekerId(helpSeekerId);
    }

    public void volunteerTeamSelectHelpRequest(int volunteerTeamId, int helpRequestId) {
        HelpRequestDao helpRequestDao = new HelpRequestDao();
        helpRequestDao.volunteerTeamSelectHelpRequest(volunteerTeamId,helpRequestId);
    }

    public List<HelpRequest> findAll() {
        HelpRequestDao helpRequestDao = new HelpRequestDao();
        return helpRequestDao.findAll();
    }

    public List<HelpRequest> findSelectableHelpRequest() {
        HelpRequestDao helpRequestDao  = new HelpRequestDao();
        return  helpRequestDao.findSelectableHelpRequest();
    }
}
