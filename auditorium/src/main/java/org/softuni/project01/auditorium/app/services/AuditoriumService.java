package org.softuni.project01.auditorium.app.services;

import org.softuni.project01.auditorium.app.dto.binding.AuditoriumBindingModel;
import org.softuni.project01.auditorium.app.dto.binding.SearchBindingModel;
import org.softuni.project01.auditorium.app.dto.view.AuditoriumVIewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 11.3.2018 г. at 21:15.
 */
public interface AuditoriumService {
    void saveAuditorium(AuditoriumBindingModel auditoriumBindingModel);

    Page<AuditoriumVIewModel> findAll(SearchBindingModel searchBindingModel, Pageable pageable);
}
