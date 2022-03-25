package com.fp.pi.infomap;

import java.util.List;

public interface InfoMapMapper {

	int regInfo(InfoMapBean i);

	List<InfoMapBean> callInfo();

	List<InfoMapBean> searchPriceInfos(InfoMapBean i);

	int deletePriceInfo(InfoMapBean i);

}
