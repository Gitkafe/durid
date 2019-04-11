package com.exam.durid.dao.cluster;

import com.exam.durid.model.Dict;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DictMapper {

    List<Dict> getAll();
}
