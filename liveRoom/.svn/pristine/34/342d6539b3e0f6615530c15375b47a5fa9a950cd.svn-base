package com.liveRoom.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.UserLevel;
import com.liveRoom.dao.UserlevelDao;
@Repository("userlevelDaoImpl")
public class UserlevelDaoImpl  extends CommonDaoImpl<UserLevel> implements UserlevelDao {
	//主键字段名
	protected final String PRIMARYKEYNAME = "level_id";
	//实体类名
	protected final Class<UserLevel> USERLEVEL = UserLevel.class;

	@Override
	public void addUserlevel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delUserlevel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updUserlevel() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Map<String, Object>> selUserlevel(int roomId) {
		// TODO Auto-generated method stub
		return super.findManyBySql("select * from room_user_grade where room_id="+roomId);
	}

}
