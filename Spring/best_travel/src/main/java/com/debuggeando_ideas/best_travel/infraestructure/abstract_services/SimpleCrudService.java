package com.debuggeando_ideas.best_travel.infraestructure.abstract_services;

public interface SimpleCrudService <Rq, Rs, Id>{
    Rs crate(Rq request);
    Rs read(Id id);

    void delete(Id id);
}
