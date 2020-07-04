package com.market.burgermarket.converters;

import com.market.burgermarket.dto.BurgerDto;
import com.market.burgermarket.dto.TicketDto;
import com.market.burgermarket.dto.UserDto;
import com.market.burgermarket.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TicketToTicketDtoConverter implements Converter<Ticket, TicketDto> {
    private final ConversionService conversionService;

    @Autowired
    public TicketToTicketDtoConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public TicketDto convert(Ticket ticket) {
        TicketDto target = new TicketDto();
        target.setId(ticket.getId());
        target.setCost(ticket.getCost());
        target.setDiscount(ticket.getDiscount());
        target.setPaid(ticket.getPaid());
        target.setUser(conversionService.convert(ticket.getUser(), UserDto.class));
        target.setBurgers(ticket.getBurgers().stream()
                .map(burger -> conversionService.convert(burger, BurgerDto.class)).collect(Collectors.toList()));
        return target;
    }
}
