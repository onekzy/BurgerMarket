package com.market.burgermarket.services;

import com.market.burgermarket.dto.TicketDto;

import java.util.List;

public interface TicketService {
    TicketDto getTicketById(Long id);

    List<TicketDto> getAllTicketsByUser(Long userId);

    TicketDto createTicket(TicketDto ticketDto);

    TicketDto updateTicket(TicketDto ticketDto);

    void deleteTicket(Long id);

    String payTicket(Long userId, Long id, String bonus);
}
