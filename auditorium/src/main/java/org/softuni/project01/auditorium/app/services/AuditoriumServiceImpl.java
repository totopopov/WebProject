package org.softuni.project01.auditorium.app.services;

import org.softuni.project01.auditorium.app.dto.binding.AuditoriumBindingModel;
import org.softuni.project01.auditorium.app.dto.binding.SearchBindingModel;
import org.softuni.project01.auditorium.app.dto.view.AuditoriumVIewModel;
import org.softuni.project01.auditorium.app.entities.Auditorium;
import org.softuni.project01.auditorium.app.entities.ChairType;
import org.softuni.project01.auditorium.app.entities.TableType;
import org.softuni.project01.auditorium.app.reposityory.AuditoriumRepository;
import org.softuni.project01.auditorium.app.utils.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 11.3.2018 г. at 21:16.
 */

@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    private final AuditoriumRepository auditoriumRepository;
    private ModelParser modelParser;

    @Autowired
    public AuditoriumServiceImpl(AuditoriumRepository auditoriumRepository, ModelParser modelParser) {
        this.auditoriumRepository = auditoriumRepository;
        this.modelParser = modelParser;
    }

    @Override
    public void saveAuditorium(AuditoriumBindingModel auditoriumBindingModel) {
        Auditorium auditorium = this.modelParser.map(auditoriumBindingModel, Auditorium.class);
        this.auditoriumRepository.saveAndFlush(auditorium);
    }

    @Override
    public Page<AuditoriumVIewModel> findAll(SearchBindingModel searchBindingModel, Pageable pageable) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(searchBindingModel.getDate());
        Integer start = searchBindingModel.getStartHour();
        Integer end = searchBindingModel.getEndHour();

        Page<Object[]> rooms = this.auditoriumRepository.findRooms(date, start, end,pageable);
        List<AuditoriumVIewModel> auditoriums = new ArrayList<>();
        for (Object[] roomData : rooms) {
            AuditoriumVIewModel auditoriumVIewModel = new AuditoriumVIewModel();
            auditoriumVIewModel.setName(roomData[0].toString());
            auditoriumVIewModel.setMaxCapacity(Integer.valueOf(roomData[1].toString()));
            auditoriumVIewModel.setLiveStream(roomData[2].toString().equals("1") ? Boolean.TRUE : Boolean.FALSE);
            auditoriumVIewModel.setPrice(new BigDecimal(roomData[3].toString()));
            auditoriumVIewModel.setChairType(ChairType.valueOf(roomData[4].toString()));
            auditoriumVIewModel.setTableType(TableType.valueOf(roomData[5].toString()));

            auditoriums.add(auditoriumVIewModel);
        }

        Page<AuditoriumVIewModel> page=new PageImpl<>(auditoriums,pageable,auditoriums.size());

        return page;
    }
}
