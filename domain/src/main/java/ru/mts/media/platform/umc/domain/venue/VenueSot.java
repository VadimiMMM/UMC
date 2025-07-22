package ru.mts.media.platform.umc.domain.venue;

import java.util.List;
import java.util.Optional;
import ru.mts.media.platform.umc.domain.gql.types.Event;
import ru.mts.media.platform.umc.domain.gql.types.FullExternalId;
import ru.mts.media.platform.umc.domain.gql.types.Venue;

public interface VenueSot {
    Optional<Venue> getVenueByReferenceId(String id);

    Optional<Venue> getVenueById(FullExternalId externalId);

    List<Event> getAllEvents();

    List<Venue> getAllVenuesWithLastEvents();

}
