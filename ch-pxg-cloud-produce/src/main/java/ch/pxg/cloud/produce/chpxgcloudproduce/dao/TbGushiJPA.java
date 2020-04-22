package ch.pxg.cloud.produce.chpxgcloudproduce.dao;

import ch.pxg.cloud.produce.chpxgcloudproduce.model.TbGushi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TbGushiJPA extends JpaRepository<TbGushi,Integer> {
    TbGushi getByGsUrlAndStatus(String gsUrl, long status);
}
