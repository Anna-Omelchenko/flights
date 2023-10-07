package ru.netology.flights;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int t1Duration = t1.getTimeTo() - t1.getTimeFrom();
        int t2Duration = t2.getTimeTo() - t2.getTimeFrom();
        int result = 0;
        if (t1Duration < t2Duration) {
            result = -1;
        } else if (t1Duration > t2Duration) {
            result = 1;
        }
        return result;
    }
}