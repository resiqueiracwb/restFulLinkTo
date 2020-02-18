package com.roadmap.service.impl;

import com.roadmap.model.Predio;
import com.roadmap.repository.IPredioRepository;
import com.roadmap.service.IPredioService;
import com.roadmap.vo.PredioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PredioService implements IPredioService {
    @Autowired
    private IPredioRepository dataBasesRepository;

    @Override
    public List<PredioVO> getAllPredio() {
        List<PredioVO> result = new ArrayList<PredioVO>();

        this.dataBasesRepository.findAll().forEach(predio ->{
            result.add(new PredioVO(predio));
        });

        return result;
    }

    @Override
    public Predio save(Predio predio) {
        return this.dataBasesRepository.save(predio);
    }

    @Override
    public void delete(Integer id) {

        this.dataBasesRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public Predio getById(Long id) {

        return this.dataBasesRepository.findById(id).get();
    }
}
