package com.nc.airport.backend.service;

import com.nc.airport.backend.model.dto.ResponseFilteringWrapper;
import com.nc.airport.backend.model.entities.model.airplane.Airplane;
import com.nc.airport.backend.model.entities.model.airplane.Seat;
import com.nc.airport.backend.persistence.eav.mutable2query.filtering2sorting.filtering.FilterEntity;
import com.nc.airport.backend.persistence.eav.mutable2query.filtering2sorting.sorting.SortEntity;
import com.nc.airport.backend.persistence.eav.repository.EavCrudRepository;
import com.nc.airport.backend.persistence.eav.repository.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class AirplaneService extends AbstractService{
    private EavCrudRepository<Airplane> airplaneRepository;

    @Autowired
    public AirplaneService(EavCrudRepository<Airplane> airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    public List<Airplane> findAllAirplanes() {
        return airplaneRepository.findAll(Airplane.class);
    }

    public List<Airplane> getTenAirplanes(int page) {
        return airplaneRepository.findSlice(Airplane.class, new Page(page - 1));
    }

    public Airplane addAirplane(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    public void deleteAirplane(BigInteger id) {
        airplaneRepository.deleteById(id);
    }

    public BigInteger getAirplanesAmount() {
        return airplaneRepository.count(Airplane.class);
    }

    public BigInteger getAmountOfFilteredAirplanes(String searchString) {
        List<FilterEntity> filterBy = makeFilterList(searchString, Airplane.class);
        return airplaneRepository.count(Airplane.class, filterBy);
    }

    public ResponseFilteringWrapper filterAndSortAirplanes(int page, String search, List<SortEntity> sortEntities) {
        List<FilterEntity> filterEntities = makeFilterList(search, Airplane.class);
        List<Airplane> airplanes = airplaneRepository.findSlice(Airplane.class, new Page(page - 1), sortEntities, filterEntities);
        List<Object> entities = new ArrayList<>(airplanes);
        BigInteger countOfPages = airplaneRepository.count(Airplane.class, filterEntities);
        return new ResponseFilteringWrapper(entities, countOfPages);

    }

    public List<Seat> findSeatsByAirplane(Airplane airplane) {
        return null;
    }
}

