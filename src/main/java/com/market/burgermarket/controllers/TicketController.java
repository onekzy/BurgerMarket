package com.market.burgermarket.controllers;

import com.market.burgermarket.dto.TicketDto;
import com.market.burgermarket.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/{userId}/ticket")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<TicketDto> getAllTicketsByUser(@PathVariable("userId") Long userId) {
        return ticketService.getAllTicketsByUser(userId);
    }

    @GetMapping(value = "/{id}")
    public TicketDto getTicketById(@PathVariable("id") Long id) {
        return ticketService.getTicketById(id);
    }

    @PutMapping
    public TicketDto updateTicket(@RequestBody TicketDto ticketDto) {
        return ticketService.updateTicket(ticketDto);
    }

    @PostMapping
    public TicketDto createTicket(@RequestBody TicketDto ticketDto) {
        return ticketService.createTicket(ticketDto);
    }

    @PostMapping(value = "/{id}/pay")
    public String payTicket(@PathVariable("userId") Long userId,
                            @PathVariable("id") Long id,
                            @RequestParam(value = "bonus", required = false) String bonus) {
        return ticketService.payTicket(userId, id, bonus);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTicket(@PathVariable("id") Long id) {
        ticketService.deleteTicket(id);
    }
}
