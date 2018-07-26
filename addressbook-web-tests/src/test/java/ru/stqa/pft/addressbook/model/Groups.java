package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Groups extends ForwardingSet<GroupData> {

    private Set<GroupData> delegetae;

    public Groups(Groups groups) {
        this.delegetae = new HashSet<GroupData>(groups.delegate());
    }

    public Groups() {
        this.delegetae = new HashSet<GroupData>();
    }

    public Groups(Collection<GroupData> groups) {
        this.delegetae = new HashSet<GroupData>(groups);
    }

    @Override
    protected Set<GroupData> delegate() {
        return delegetae;
    }

    public Groups withAdded(GroupData group){
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups withOut(GroupData group){
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}