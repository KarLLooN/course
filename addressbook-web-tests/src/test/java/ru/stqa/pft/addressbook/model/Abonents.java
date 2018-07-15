package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Abonents extends ForwardingSet<AbonentData>{

    private Set<AbonentData> delegate;

    public Abonents(Abonents abonents) {
        this.delegate = new HashSet<AbonentData>(abonents.delegate());
    }

    public Abonents() {
        this.delegate = new HashSet<AbonentData>();
    }

    @Override
    protected Set<AbonentData> delegate() {
        return delegate;
    }

    public Abonents withAdded(AbonentData abonent){
        Abonents abonents = new Abonents(this);
        abonents.add(abonent);
        return abonents;
    }

    public Abonents withOut(AbonentData abonent){
        Abonents abonents = new Abonents(this);
        abonents.remove(abonent);
        return abonents;
    }
}