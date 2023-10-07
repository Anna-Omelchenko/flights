package ru.netology.flights;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    @Test
    public void testCompareTo() {
        Ticket t1 = new Ticket("Dubai", "Istanbul", 1500, 1696691796, 1696721436);
        Ticket t2 = new Ticket("Beijing", "Colombo", 1501, 1696645276, 1696734637);
        Ticket t3 = new Ticket("Moscow", "Novosibirsk", 1500, 1696636480, 1696732759);
        Assertions.assertTrue(t1.compareTo(t2) < 0);
        Assertions.assertTrue(t2.compareTo(t3) > 0);
        Assertions.assertEquals(0, t1.compareTo(t3));
    }

    @Test
    public void testSortedSearch() {
        Ticket t1 = new Ticket("Moscow", "Istanbul", 1500, 1696691796, 1696721436);
        Ticket t2 = new Ticket("Moscow", "Istanbul", 1601, 1696645276, 1696734637);
        Ticket t3 = new Ticket("Moscow", "Istanbul", 1420, 1696636480, 1696732759);
        AviaSouls manager = new AviaSouls();
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        Assertions.assertArrayEquals(new Ticket[]{t3, t1, t2}, manager.search("Moscow", "Istanbul"));
    }

    @Test
    public void testDurationComparator() {
        int timeFrom = 1696691796;
        int duration13 = 120042;
        int duration2 = 140086;
        Ticket t1 = new Ticket("Dubai", "Istanbul", 1500, timeFrom, timeFrom + duration13);
        Ticket t2 = new Ticket("Beijing", "Colombo", 1501, timeFrom, timeFrom + duration2);
        Ticket t3 = new Ticket("Moscow", "Novosibirsk", 1500, timeFrom, timeFrom + duration13);
        TicketTimeComparator comparator = new TicketTimeComparator();
        Assertions.assertTrue(comparator.compare(t1, t2) < 0);
        Assertions.assertTrue(comparator.compare(t2, t3) > 0);
        Assertions.assertEquals(0, comparator.compare(t1, t3));
    }

    @Test
    public void testSortedBySearch() {
        String from = "Moscow", to = "Istanbul";
        int timeFrom = 1696691796;
        int duration1 = 120138;
        int duration2 = 140086;
        int duration3 = 120042;
        int duration4 = 120098;
        Ticket t1 = new Ticket(from, to, 1500, timeFrom, timeFrom + duration1);
        Ticket t2 = new Ticket(from, to, 1601, timeFrom, timeFrom + duration2);
        Ticket t3 = new Ticket(from, to, 1420, timeFrom, timeFrom + duration3);
        Ticket t4 = new Ticket(from, to, 1470, timeFrom, timeFrom + duration4);
        AviaSouls manager = new AviaSouls();
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        Assertions.assertArrayEquals(new Ticket[]{t3, t4, t1, t2},
                manager.searchAndSortBy(from, to, new TicketTimeComparator()));
    }
}
