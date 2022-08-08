package com.knubisoft.tasks.algorithm.luckyticket;

public class LuckyTicketImpl implements LuckyTicket {
    @Override
    public boolean checkIsLuckyTicket(String ticket) {
        if (ticket == null || ticket.isBlank())
            return false;
        if (ticket.length() < 6 || ticket.length() > 8)
            return false;
        for (int i = 0; i < ticket.length(); i++) {
            try {
                int digit = Integer.parseInt(String.valueOf(ticket.charAt(i)));
            }catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}
