package com.example.dataBaseUpdater;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.data.domain.Example;

import com.example.dataBaseUpdater.entity.Data;
import com.example.dataBaseUpdater.repository.DataRepository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InmemoryReposytory implements DataRepository {
     Map<Long,Data> db = new HashMap<>();
    AtomicInteger id = new AtomicInteger();
    @Override
    public Data save(Data inputRow) {
       
        db.put(Long.valueOf(this.id.getAndIncrement()),inputRow);
            return inputRow;
    }

    @Override
    public List<Data> findAll(Example<Data> example) {
        return this.db.values().stream().filter(x->x.getSwiftCode()==example.getProbe().getSwiftCode()).toList();
    }
    
}
