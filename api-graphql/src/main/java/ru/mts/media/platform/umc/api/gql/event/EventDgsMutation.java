package ru.mts.media.platform.umc.api.gql.event;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;
import ru.mts.media.platform.umc.domain.event.EventDomainService;
import ru.mts.media.platform.umc.domain.gql.types.Event;
import ru.mts.media.platform.umc.domain.gql.types.EventInput;

@DgsComponent
@RequiredArgsConstructor
public class EventDgsMutation {

    private final EventDomainService eventService;

    @DgsMutation
    public Event saveEvent(@InputArgument EventInput input) {
        return eventService.save(input);
    }
}
