package org.hdwyl.tags.service;

import org.hdwyl.tags.domain.CityIndustryCount;
import org.hdwyl.tags.domain.DictArea;

import java.util.List;

public interface CityIndustryCountService {

    List<DictArea> getProvinces();

    List<DictArea> getCitys(String province);

    List<CityIndustryCount> queryByFacet(String query, String[] facetFields, String province, String city, String provinceCode, String cityCode);

    String getDefaultColumns(Integer themeId, Integer status);

}
