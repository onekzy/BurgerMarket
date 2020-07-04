package com.market.burgermarket.converters;

import com.market.burgermarket.dto.TicketDto;
import com.market.burgermarket.entities.Burger;
import com.market.burgermarket.entities.Ticket;
import com.market.burgermarket.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TicketDtoToTicketConverter implements Converter<TicketDto, Ticket> {
    private final ConversionService conversionService;

    @Autowired
    public TicketDtoToTicketConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Ticket convert(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDto.getId());
        ticket.setCost(ticketDto.getCost());
        ticket.setDiscount(ticketDto.getDiscount());
        ticket.setPaid(ticketDto.getPaid());
        ticket.setUser(conversionService.convert(ticketDto.getUser(), User.class));
        ticket.setBurgers(ticketDto.getBurgers().stream()
                .map(burger -> conversionService.convert(burger, Burger.class)).collect(Collectors.toList()));
        return ticket;
    }
}
