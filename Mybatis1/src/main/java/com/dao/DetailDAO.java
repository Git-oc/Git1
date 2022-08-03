package com.dao;

import com.pojo.Detail;

public interface DetailDAO {
    public int insertDetail(Detail detail);

    public Detail queryDetailByUid(int uid);
}
