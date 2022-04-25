package com.rest;

import com.model.Status;
import com.service.StatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StatusResource {

    private StatusService statusService;

    public StatusResource(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/Statuses")
    public List<Status> getAll() {
        return statusService.getAll();
    }
}