package ch.pxg.cloud.produce.chpxgcloudproduce.service;

import ch.pxg.cloud.produce.chpxgcloudproduce.util.ResultInfo;

public interface ProduceServer {

    public ResultInfo getContentByUrl(String url);

    public  void exec();
}
