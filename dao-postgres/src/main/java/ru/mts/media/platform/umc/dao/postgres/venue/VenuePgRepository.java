package ru.mts.media.platform.umc.dao.postgres.venue;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mts.media.platform.umc.dao.postgres.common.FullExternalIdPk;
import ru.mts.media.platform.umc.dao.postgres.event.EventPgEntity;

@Repository
interface VenuePgRepository extends JpaRepository<VenuePgEntity, FullExternalIdPk> {

    VenuePgEntity findByReferenceId(String referenceId);

    @Query("SELECT e FROM EventPgEntity e JOIN FETCH e.venues")
    List<EventPgEntity> findAllEventsWithVenue();

    @Query("SELECT DISTINCT v FROM VenuePgEntity v JOIN FETCH v. e")
    List<VenuePgEntity> findAllWithEvents();
}
