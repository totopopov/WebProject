package softuni.org.project00.app.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 1:49.
 */

@Component
public class ModelParser {

    private ModelMapper modelMapper;

    public ModelParser() {
        this.modelMapper = new ModelMapper();
    }

    public <T> T map(Object source, Class<T> destination) {
        return source == null ? null : this.modelMapper.map(source, destination);
    }

    public <T> List<T> map(Iterable source, Class<T> destination) {

        List<T> list = new LinkedList<>();
        for (Object o : source) {
            T mapped = this.map(o, destination);
            list.add(mapped);
        }
        return list;

    }


}
