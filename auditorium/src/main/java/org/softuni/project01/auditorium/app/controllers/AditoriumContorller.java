package org.softuni.project01.auditorium.app.controllers;

import org.softuni.project01.auditorium.app.dto.PageWrapper;
import org.softuni.project01.auditorium.app.dto.binding.AuditoriumBindingModel;
import org.softuni.project01.auditorium.app.dto.binding.SearchBindingModel;
import org.softuni.project01.auditorium.app.dto.view.AuditoriumVIewModel;
import org.softuni.project01.auditorium.app.services.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Todor Popov using Lenovo on 11.3.2018 г. at 19:26.
 */

@Controller
@RequestMapping("/auditorium")
public class AditoriumContorller {

    private final AuditoriumService auditoriumService;

    @Autowired
    public AditoriumContorller(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    @GetMapping("/create")
    public String createAuditorium() {
        return "auditorium/auditorium";
    }

    @PostMapping("/create")
    public String createAuditorium(AuditoriumBindingModel auditoriumBindingModel) {
        this.auditoriumService.saveAuditorium(auditoriumBindingModel);
        return "index";
    }


    @GetMapping("/search")
    public String findeAuditorium() {
        return "auditorium/search";
    }


    @Transactional
    @PostMapping(value = "/search")
    public String findeAuditoriumConfirm(Model model, SearchBindingModel searchBindingModel, @PageableDefault(size = 5) Pageable pageable) {

        Page<AuditoriumVIewModel> available = this.auditoriumService.findAll(searchBindingModel, pageable);
        PageWrapper<AuditoriumVIewModel> page = new PageWrapper<>(available, "/auditorium/search");
        model.addAttribute("page", page);
        System.out.println(page.isHasNextPage());
        return "auditorium/result";


    }
}
