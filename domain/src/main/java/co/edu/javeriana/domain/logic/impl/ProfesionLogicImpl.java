package co.edu.javeriana.domain.logic.impl;

import co.edu.javeriana.domain.logic.ProfesionLogic;
import co.edu.javeriana.domain.model.Profesion;
import co.edu.javeriana.domain.ports.out.maria.ProfesionPortMaria;
import co.edu.javeriana.domain.ports.out.mongo.ProfesionPortMongo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProfesionLogicImpl implements ProfesionLogic {

    @Autowired
    private ProfesionPortMaria profesionPortMaria;

    @Autowired
    private ProfesionPortMongo profesionPortMongo;

    @Override
    public Boolean create(Profesion profesion, int persistence) {
        if (persistence == 1){
            return profesionPortMaria.crear(profesion);
        }
        else if (persistence == 2) {
            return profesionPortMongo.crear(profesion);
        }
        else {
            return profesionPortMaria.crear(profesion) && profesionPortMongo.crear(profesion);
        }
    }

    @Override
    public Boolean delete(Profesion profesion, int persistence) {

        if (persistence == 1){
            return profesionPortMaria.delete(profesion);
        }
        else if (persistence == 2) {
            return profesionPortMongo.delete(profesion);
        }
        else {
            return profesionPortMaria.delete(profesion) && profesionPortMongo.delete(profesion);
        }
    }

    @Override
    public Boolean update(Profesion profesion, int persistence) {

        if (persistence == 1){
            return profesionPortMaria.update(profesion);
        }
        else if (persistence == 2) {
            return profesionPortMongo.update(profesion);
        }
        else {
            return profesionPortMaria.update(profesion) && profesionPortMongo.update(profesion);
        }
    }

    @Override
    public List<Profesion> findAll(int persistence) {

        if (persistence == 1){
            return profesionPortMaria.findAll();
        }
        else if (persistence == 2) {
            return profesionPortMongo.findAll();
        }
        else {
            List<Profesion> list = new ArrayList<>();
            list.addAll(profesionPortMaria.findAll());
            list.addAll(profesionPortMongo.findAll());
            return list;
        }
    }

    @Override
    public Profesion findById(Integer id, int persistence) {
        if (persistence == 1){
            return profesionPortMaria.findById(id);
        }
        else if (persistence == 2) {
            return profesionPortMongo.findById(id);
        }
        else {
//            return profesionPortMaria.findById(id) && profesionPortMongo.findById(id);
        }
        return null;
    }

    @Override
    public Long count(int persistence) {
        if (persistence == 1){
            return profesionPortMaria.count();
        }
        else if (persistence == 2) {
            return profesionPortMongo.count();
        }
        else {
            return profesionPortMaria.count() + profesionPortMongo.count();
        }
    }
}
