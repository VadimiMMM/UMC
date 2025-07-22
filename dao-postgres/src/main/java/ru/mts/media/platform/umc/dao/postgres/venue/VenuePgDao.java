package ru.mts.media.platform.umc.dao.postgres.venue;

import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.mts.media.platform.umc.dao.postgres.event.EventPgMapper;
import ru.mts.media.platform.umc.domain.gql.types.Event;
import ru.mts.media.platform.umc.domain.gql.types.FullExternalId;
import ru.mts.media.platform.umc.domain.gql.types.Venue;
import ru.mts.media.platform.umc.domain.venue.VenueSave;
import ru.mts.media.platform.umc.domain.venue.VenueSot;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class VenuePgDao implements VenueSot {
    private final VenuePgRepository repository;
    private final VenuePgMapper mapper;
    private final EventPgMapper pgMapper;

    public Optional<Venue> getVenueByReferenceId(String id) {
        return Optional.of(id)
                .map(repository::findByReferenceId)
                .map(mapper::asModel);
    }

    @Override
    public Optional<Venue> getVenueById(FullExternalId externalId) {
        Optional.of(externalId)
                .map(mapper::asPk)
                .flatMap(repository::findById);
        return Optional.empty();
    }

    @Override
    public List<Event> getAllEvents() {
        return repository.findAllEventsWithVenue().stream()
                .map(pgMapper::toModel)
                .toList();
    }

    @Override
    public List<Venue> getAllVenuesWithLastEvents() {
        return repository.findAllWithEvents().stream()
                .map(mapper::asModel)
                .toList();
    }

    @EventListener
    public void handleVenueCreatedEvent(VenueSave evt) {
        evt.unwrap()
                .map(mapper::asEntity)
                .ifPresent(repository::save);
    }
}
