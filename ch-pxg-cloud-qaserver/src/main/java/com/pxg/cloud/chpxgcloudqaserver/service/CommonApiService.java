package com.pxg.cloud.chpxgcloudqaserver.service;

import com.pxg.cloud.chpxgcloudqaserver.model.request.ApiCommonRequestVI;
import com.pxg.cloud.chpxgcloudqaserver.util.ResultInfo;

import java.util.List;

public interface CommonApiService {

    public ResultInfo getCommonApiResult(String url, ApiCommonRequestVI apiCommonRequestVI);
}
