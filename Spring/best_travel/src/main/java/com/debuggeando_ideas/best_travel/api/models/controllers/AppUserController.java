package com.debuggeando_ideas.best_travel.api.models.controllers;

import com.debuggeando_ideas.best_travel.infraestructure.abstract_services.ModifyUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(path = "user")
@AllArgsConstructor
@Slf4j
@Tag(name = "user")
public class AppUserController {
    private final ModifyUserService modifyUserService;

    @Operation(summary = "enabled or disabled user")
    @PatchMapping(path = "enabledOrDisabled")
    public ResponseEntity<Map<String, Boolean>> enableOrDisabled(@RequestParam String username){
        return ResponseEntity.ok(this.modifyUserService.enabled(username));
    }

    @Operation(summary = "enabled or disabled user")
    @PatchMapping(path = "add-role")
    public ResponseEntity<Map<String, Set<String>>> addRole(@RequestParam String username, @RequestParam String role){
        return ResponseEntity.ok(this.modifyUserService.addRole(role, username));
    }

    @Operation(summary = "enabled or disabled user")
    @PatchMapping(path = "remove-role")
    public ResponseEntity<Map<String, Set<String>>> removeRole(@RequestParam String username, @RequestParam String role){
        return ResponseEntity.ok(this.modifyUserService.removeRole(role, username));
    }
}
