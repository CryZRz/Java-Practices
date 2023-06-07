package com.debuggeando_ideas.best_travel.infraestructure.abstract_services;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ModifyUserService {

    Map<String, Boolean> enabled(String username);
    Map<String, Set<String>> addRole(String role, String username);
    Map<String, Set<String>> removeRole(String role, String username);
}
