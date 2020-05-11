package org.matsim.project;

import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;

public class SimpleEventsHandler implements PersonDepartureEventHandler, PersonArrivalEventHandler {
    @Override
    public void handleEvent(PersonDepartureEvent event) {
            System.out.println("Departure event; time " + event.getTime() + "__linkID:" + event.getLinkId()
            + "Which PersonId: " + event.getPersonId());
    }
    @Override
    public void handleEvent(PersonArrivalEvent event) {
        System.out.println();
    }
}
