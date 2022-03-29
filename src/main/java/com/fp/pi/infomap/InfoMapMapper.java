package com.fp.pi.infomap;

import java.util.List;

public interface InfoMapMapper {

	public int regInfo(InfoMapBean i);

	public List<InfoMapBean> callInfo();

	public List<InfoMapBean> searchPriceInfos(InfoMapBean i);

	public int deletePriceInfo(InfoMapBean i);

	public List<InfoMapBean> searchForUpdate(InfoMapBean i);

	public abstract int updateInfo(InfoMapBean i);

}
