package com.knubisoft.tasks.algorithm.luckyticket;

public class LuckyTicketImpl implements LuckyTicket {
    @Override
    public boolean checkIsLuckyTicket(String ticket) {
        if (ticket == null) {
            return false;
        }

        if (!ticket.matches("\\b\\d+\\b")) {
            return false;
        }

        if (!ticket.matches(".{6,8}")) {
            return false;
        }

        int lastIndex = ticket.length() - 1;
        char[] input = ticket.toCharArray();
        char[] palindrome = new char[input.length];

        for (int i = 0; i <= lastIndex; i++) {
            palindrome[i] = input[lastIndex - i];
        }

        return String.valueOf(palindrome).equals(ticket);
    }
}

