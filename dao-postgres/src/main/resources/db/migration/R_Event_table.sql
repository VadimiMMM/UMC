CREATE TABLE event (
                       id              BIGSERIAL PRIMARY KEY,
                       name            VARCHAR(255) NOT NULL,
                       start_time      TIMESTAMP NOT NULL,
                       end_time        TIMESTAMP NOT NULL
);

CREATE TABLE event_venue (
                             event_id        BIGINT NOT NULL,
                             brand           VARCHAR(255) NOT NULL,
                             provider        VARCHAR(255) NOT NULL,
                             external_id     VARCHAR(255) NOT NULL,
                             PRIMARY KEY (event_id, brand, provider, external_id),
                             FOREIGN KEY (event_id) REFERENCES event(id) ON DELETE CASCADE,
                             FOREIGN KEY (brand, provider, external_id)
                                 REFERENCES venue(brand, provider, external_id) ON DELETE CASCADE
);

-- Индекс для быстрого поиска по event_id
CREATE INDEX idx_event_venue_event_id ON event_venue(event_id);
