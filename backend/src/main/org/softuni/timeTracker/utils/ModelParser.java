package org.softuni.timeTracker.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 1:49.
 */

@Component
public class ModelParser {

    private final ModelMapper modelMapper;

    @Autowired
    public ModelParser(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public <T> T map(Object source, Class<T> destination) {
        return source == null ? null : this.modelMapper.map(source, destination);
    }

    public <T> List<T> map(Iterable source, Class<T> destination) {

        List<T> list = new LinkedList<>();
        for (Object o : source) {
            T mapped = modelMapper.map(o, destination);
            list.add(mapped);
        }
        return list;

    }

}
