package com.market.burgermarket.services.impl;

import com.market.burgermarket.dto.TicketDto;
import com.market.burgermarket.entities.Ticket;
import com.market.burgermarket.entities.User;
import com.market.burgermarket.repositories.TicketRepository;
import com.market.burgermarket.repositories.UserRepository;
import com.market.burgermarket.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final ConversionService conversionService;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, UserRepository userRepository, ConversionService conversionService) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.conversionService = conversionService;
    }

    @Override
    public TicketDto getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket is not found"));
        return conversionService.convert(ticket, TicketDto.class);
    }

    @Override
    public List<TicketDto> getAllTicketsByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User is not found"));
        return user.getTickets().stream()
                .map(ticket -> conversionService.convert(ticket, TicketDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TicketDto createTicket(TicketDto ticketDto) {
        Ticket ticket = conversionService.convert(ticketDto, Ticket.class);
        return conversionService.convert(ticketRepository.save(ticket), TicketDto.class);
    }

    @Override
    public TicketDto updateTicket(TicketDto ticketDto) {
        Ticket ticket = ticketRepository.findById(ticketDto.getId()).orElseThrow(() -> new RuntimeException("Ticket is not found"));
        ticket.setCost(ticket.getCost());
        ticket.setDiscount(ticketDto.getDiscount());
        return conversionService.convert(ticketRepository.save(ticket), TicketDto.class);
    }

    @Override
    public void deleteTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket is not found"));
        ticketRepository.delete(ticket);
    }

    @Override
    public String payTicket(Long userId, Long id, String bonus) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket is not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User is not found"));
        if (Objects.nonNull(bonus)) {
            BigDecimal bonusPoints = new BigDecimal(Integer.parseInt(bonus));
            if (user.getBonusPoints().compareTo(bonusPoints) < 0) {
                return "Not enough bonuses";
            } else {
                user.setBonusPoints(user.getBonusPoints().subtract(bonusPoints));
                ticket.setPaid(true);
                userRepository.save(user);
                return "Payment is successful";
            }
        } else {
            user.setBonusPoints(user.getBonusPoints().add(ticket.getCost().multiply(new BigDecimal(0.05))));
            ticket.setPaid(true);
            userRepository.save(user);
            return "Payment is successful";
        }
    }
}
