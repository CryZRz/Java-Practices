package com.debuggeando_ideas.best_travel.api.models.controllers;


import com.debuggeando_ideas.best_travel.api.models.request.TourRequest;
import com.debuggeando_ideas.best_travel.api.models.responses.ErrorsResponse;
import com.debuggeando_ideas.best_travel.api.models.responses.TourResponse;
import com.debuggeando_ideas.best_travel.infraestructure.abstract_services.ITourService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(path = "tour")
@AllArgsConstructor
@Slf4j
@Tag(name = "Tour")
public class TourController {

    private final ITourService tourService;

    @ApiResponse(
            responseCode = "400",
            description = "When the request have a field invalid we response this",
            content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))
            }
    )
    @Operation(summary = "Save in system one tour based in list of hotels and list flights")
    @PostMapping
    public ResponseEntity<TourResponse> post(@RequestBody TourRequest request){
        return ResponseEntity.ok(this.tourService.crate(request));
    }

    @Operation(summary = "Return a tour with id passed")
    @GetMapping(path = "{id}")
    public ResponseEntity<TourResponse> get(@PathVariable Long id){
        return ResponseEntity.ok(this.tourService.read(id));
    }

    @Operation(summary = "Delete a tour with id passed")
    @DeleteMapping(path ="{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.tourService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Remove a ticket from tour")
    @PatchMapping(path ="{tourId}/remove_ticket/{ticketId}")
    public ResponseEntity<Void> deleteTicket(
            @PathVariable Long tourId,
            @PathVariable UUID ticketId
            ){
        this.tourService.removeTicket(tourId, ticketId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "add a ticket from tour")
    @PatchMapping(path ="{tourId}/add_ticket/{flyId}")
    public ResponseEntity<Map<String, UUID>> postTicket(
            @PathVariable Long tourId,
            @PathVariable Long flyId
    ){
        var response = Collections.singletonMap("ticketId", this.tourService.addTicket(flyId, tourId));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Remove a reservation from tour")
    @PatchMapping(path ="{tourId}/remove_reservation/{reservationId}")
    public ResponseEntity<Void> deleteReservation(
            @PathVariable Long tourId,
            @PathVariable UUID reservationId
    ){
        this.tourService.removeReservation(tourId, reservationId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Remove a reservation from tour")
    @PatchMapping(path ="{tourId}/add_reservation/{hotelId}")
    public ResponseEntity<Map<String, UUID>> postReservation(
            @PathVariable Long tourId,
            @PathVariable Long hotelId,
            @RequestParam Integer totalDays
    ){
        var response = Collections.singletonMap("ticketId", this.tourService.addReservation(hotelId, tourId, totalDays));
        return ResponseEntity.ok(response);
    }
}
