package ru.mts.media.platform.umc.api.gql.event;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import java.util.List;
import lombok.RequiredArgsConstructor;
import ru.mts.media.platform.umc.domain.gql.types.Event;
import ru.mts.media.platform.umc.domain.gql.types.Venue;
import ru.mts.media.platform.umc.domain.venue.VenueSot;

@DgsComponent
@RequiredArgsConstructor
public class EventDgsQuery {

    private final VenueSot venueSot;

    @DgsQuery
    public List<Event> events() {
        return venueSot.getAllEvents();
    }

    @DgsQuery
    public List<Venue> venues() {
        return venueSot.getAllVenuesWithLastEvents();
    }
}
