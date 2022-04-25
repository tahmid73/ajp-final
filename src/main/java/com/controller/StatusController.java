package com.controller;

import com.model.Status;
import com.service.StatusService;
import com.service.StatusService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/status")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/list")
    public String list(Model model, @RequestParam(required = false) String sortKey) {
        List<Status> statuses = new ArrayList<>();
        if (sortKey != null) {
            int field = Integer.parseInt(sortKey);
            statuses = statusService.sort(field);
        }
        else {
            statuses = statusService.getAll();
        }
        model.addAttribute("status", statuses);
        return "status-list";
    }

    @RequestMapping("/status-create-form")
    public String statusCreateForm(Model model) {
        Status status = new Status();
        model.addAttribute("status", status);
        return "status-view";
    }

    @RequestMapping("/create")
    public String create(@ModelAttribute("status") Status status) {
        statusService.save(status);
        return "redirect:/status/list";
    }

    @RequestMapping("/status-update-form")
    public String statusUpdateForm(@RequestParam("statusId") int id, Model model) {
        Status status = statusService.get(id);
        model.addAttribute("status", status);
        return "update-status-form";
    }

    @RequestMapping("/update")
    public String update(@ModelAttribute("status") Status status) {
        statusService.update(status);
        return "redirect:/status/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("statusId") int id) {
        statusService.delete(id);
        return "redirect:/status/list";
    }

    @RequestMapping("/search")
    public String search(@RequestParam(name = "searchValue", required = false) int statusId, Model model) {
        List<Status> statuses = new ArrayList<>();
        if (statusId >=-1) {
            statuses = statusService.getAll();
        }
        else {
            statuses = statusService.getAll(statusId);
        }
        model.addAttribute("statuses", statuses);
        return "status-list";
    }
}
