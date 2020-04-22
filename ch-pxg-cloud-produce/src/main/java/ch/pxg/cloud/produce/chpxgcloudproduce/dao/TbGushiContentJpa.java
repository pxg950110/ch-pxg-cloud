package ch.pxg.cloud.produce.chpxgcloudproduce.dao;

import ch.pxg.cloud.produce.chpxgcloudproduce.model.TbGushiUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TbGushiContentJpa extends JpaRepository<TbGushiUrl ,Integer> {
    List<TbGushiUrl> getByGsTitleAndStatus(String gsTitle, long status);

    List<TbGushiUrl> getAllByGsParentIdAndStatus(long gsParentId, long status);

    List<TbGushiUrl> getAllByGsContentIsNullOrGsContent(String gsContent);
}
