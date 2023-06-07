package com.debuggeando_ideas.best_travel.infraestructure.abstract_services;

public interface CrudService <Rq, Rs, Id>{

    Rs create(Rq request);

    Rs read(Id id);

    Rs update(Rq request, Id id);

    void delete(Id id);
}
