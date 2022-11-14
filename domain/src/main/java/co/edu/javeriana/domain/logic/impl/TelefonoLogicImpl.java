package co.edu.javeriana.domain.logic.impl;

import co.edu.javeriana.domain.logic.TelefonoLogic;
import co.edu.javeriana.domain.model.Telefono;
import co.edu.javeriana.domain.ports.out.maria.TelefonoPortMaria;
import co.edu.javeriana.domain.ports.out.mongo.TelefonoPortMongo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TelefonoLogicImpl implements TelefonoLogic {
    @Autowired
    private TelefonoPortMaria telefonoPortMaria;

    @Autowired
    private TelefonoPortMongo telefonoPortMongo;

    @Override
    public Boolean create(Telefono telefono, int persistence) {
        if (persistence == 1){
            return telefonoPortMaria.crear(telefono);
        }
        else if (persistence == 2) {
            return telefonoPortMongo.crear(telefono);
        }
        else {
            return telefonoPortMaria.crear(telefono) && telefonoPortMongo.crear(telefono);
        }
    }

    @Override
    public Boolean delete(Telefono telefono, int persistence) {
        if (persistence == 1){
            return telefonoPortMaria.delete(telefono);
        }
        else if (persistence == 2) {
            return telefonoPortMongo.delete(telefono);
        }
        else {
            return telefonoPortMaria.delete(telefono) && telefonoPortMongo.delete(telefono);
        }
    }

    @Override
    public Boolean update(Telefono telefono, int persistence) {
        if (persistence == 1){
            return telefonoPortMaria.update(telefono);
        }
        else if (persistence == 2) {
            return telefonoPortMongo.update(telefono);
        }
        else {
            return telefonoPortMaria.update(telefono) && telefonoPortMongo.update(telefono);
        }
    }

    @Override
    public List<Telefono> findAll(int persistence) {
        if (persistence == 1){
            return telefonoPortMaria.findAll();
        }
        else if (persistence == 2) {
            return telefonoPortMongo.findAll();
        }
        else {
            List<Telefono> list = new ArrayList<>();
            list.addAll(telefonoPortMaria.findAll());
            list.addAll(telefonoPortMongo.findAll());
            return list;
        }
    }

    @Override
    public Telefono findByNum(String num, int persistence) {
        if (persistence == 1){
            return telefonoPortMaria.findByNum(num);
        }
        else if (persistence == 2) {
            return telefonoPortMongo.findByNum(num);
        }
        else {
//            return telefonoPortMaria.findById(cc) && telefonoPortMongo.findById(cc);
        }
        return null;
    }

    @Override
    public Long count(int persistence) {
        if (persistence == 1){
            return telefonoPortMaria.count();
        }
        else if (persistence == 2) {
            return telefonoPortMongo.count();
        }
        else {
            return telefonoPortMaria.count() + telefonoPortMongo.count();
        }
    }
}
